var express = require('express');
var router = express.Router();
var User = require('../models/user');


//route for posting new user data
router.post('/register', function (req, res, next) {
  // confirm that user typed same password twice
  if (req.body.password !== req.body.confirmpw) {
    var err = new Error('Passwords do not match.');
    err.status = 400;
    return next(err);
  }
  else {
    var user = new User();
    user.name = req.body.name;
    user.email = req.body.email;
    user.password = req.body.password;
    user.save(function(err) {
      if (err) res.send(err)
      res.json({ message: 'Post saved'})
    })
  }
});
