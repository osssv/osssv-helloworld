var express = require('express')
var router = express.Router();

router.get('/', function(req, res, next){
  var p1 = req.query.p1;
  var p2 = req.query.p2;
  var msg = p1 == undefined ? "":p1 + "," + p2;

  res.render(
    'sample', 
    {
      title: 'Sample Page',
      msg: msg,
      input:''
    }
  );
});

router.post('/', function(req, res, next){
  var str = req.body['input'];

  res.render(
    'sample',
    {
      title: 'Send Message',
      msg: "you typed: " + str,
      input: str
    }
  );
});

module.exports = router;
