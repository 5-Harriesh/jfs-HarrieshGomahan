import { TestBed } from '@angular/core/testing';

import { AppformService } from './appform.service';

describe('AppformService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AppformService = TestBed.get(AppformService);
    expect(service).toBeTruthy();
  });
});
