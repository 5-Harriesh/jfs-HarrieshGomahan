package com.astrazeneca.training.makerchecker.datatable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class DatatableBuilder<T> {

    DatatableRequest datatableRequest;
    private EntityManager entityManager;
    Class clazz;


    public DatatableResponse<T> buildDatatableConfig() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> userRoot = criteriaQuery.from(clazz);
        List<Predicate> predicates = predicateBuilder(datatableRequest,criteriaBuilder,criteriaQuery,userRoot);
        Predicate[] predicateArray = predicates.toArray(new Predicate[predicates.size()]);
        criteriaQuery.select(userRoot);
        criteriaQuery.where(predicateArray);
        sortBuilder(datatableRequest,criteriaBuilder,criteriaQuery,userRoot);
        return paginationBuilder(datatableRequest,criteriaBuilder,criteriaQuery,userRoot,predicateArray);
    }

    private DatatableResponse<T> paginationBuilder(DatatableRequest datatableRequest, CriteriaBuilder criteriaBuilder,
                                                         CriteriaQuery<T> criteriaQuery, Root<T> userRoot, Predicate[] predicateArray) {

        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> countRoot = countQuery.from(clazz);
        countQuery.select(criteriaBuilder.count(countRoot));
        List<Predicate> countPredicates = predicateBuilder(datatableRequest,criteriaBuilder,countQuery,countRoot);
        Predicate[] countPredicateArray = countPredicates.toArray(new Predicate[countPredicates.size()]);
        countQuery.where(countPredicateArray);
        Long count = entityManager.createQuery(countQuery).getSingleResult();
        int pageNumber = datatableRequest.getFirst();
        int pageSize = datatableRequest.getRows();

        TypedQuery<T> finalQuery =  entityManager.createQuery(criteriaQuery);
        finalQuery.setFirstResult(pageNumber);
        finalQuery.setMaxResults(pageSize);
        pageNumber += pageSize;
        return new DatatableResponse<T>(count,finalQuery.getResultList());

    }


    private void sortBuilder(DatatableRequest datatableRequest, CriteriaBuilder criteriaBuilder,
                             CriteriaQuery criteriaQuery, Root<T> userRoot) {
        if(datatableRequest.getSortOrder() == 1 ){
            criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get(datatableRequest.getSortField())));
        }else if(datatableRequest.getSortOrder() == -1 ){
            criteriaQuery.orderBy(criteriaBuilder.desc(userRoot.get(datatableRequest.getSortField())));
        }
    }

    private List<Predicate> predicateBuilder(DatatableRequest datatableRequest, CriteriaBuilder criteriaBuilder,
                                             CriteriaQuery criteriaQuery, Root<T> userRoot) {

        List<Predicate> predicates = new ArrayList<Predicate>();
        for (Map.Entry<String, DatatableFilter> filter : datatableRequest.getFilters().entrySet()) {
            String key = filter.getKey();
            String value = filter.getValue().getValue();
            String mode = filter.getValue().getMatchMode();
            if ((key != null && !key.isEmpty()) && (value != null && !value.isEmpty())) {
                if (value.contains("%")) {
                    predicates.add(criteriaBuilder.like(userRoot.get(key), value));
                } else {
                    predicates.add(criteriaBuilder.equal(userRoot.get(key), value));
                }
            }
        }
        return predicates;
    }
}
