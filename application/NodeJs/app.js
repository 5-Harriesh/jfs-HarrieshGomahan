var express = require('express');
var bodyParser = require('body-parser');
const cors = require('cors');
var app = express();
const mongo = require('mongodb').MongoClient
 
const url = 'mongodb://localhost:27017'


app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
 
var corsOptions = {
   origin: 'http://localhost:4200',
   optionsSuccessStatus: 200 // some legacy browsers (IE11, various SmartTVs) choke on 204 
}
app.use(cors(corsOptions));

 
app.get('', function (req, res) {
    res.end('Node is Working'); 
 })



app.post('/login/save', function (req, res) {
   mongo.connect(url, (err, client) => {
      if (err) {
        console.error(err)
        return
      }
      const db = client.db('user')
      const collection = db.collection('user')
      collection.insertOne(req.body);
    })
    res.end('Saved Successfully');
});

app.post('/login', function (req, res) {
   mongo.connect(url, (err, client) => {
      if (err) {
        console.error(err)
        return
      }
      const db = client.db('user')
      const collection = db.collection('user')
      collection.find(req.body).toArray((err, items) => {
         if(items.length>0)
            res.end(JSON.stringify(items[0]));
         else 
            res.end('');
       })
    })
})



 var server = app.listen(8081, function () {
    var host = server.address().address
    var port = server.address().port
    console.log("app listening at http://%s:%s", host, port)
 })

 
