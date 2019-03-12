var mongoose = require('mongoose');
var bcrypt = require('bcrypt');
var Schema = mongoose.Schema;

//Create table
var Userschema = new Schema({
	//Data goes here
	name : { 
		type: String, 
		required: [true, "can't be blank"]
	},
	email : { 
		type: String, 
		required: [true, "can't be blank"],
		unique: true
	},
	password: { 
		type: String, 
		required: [true, "can't be blank"]
	},
	comfirmpw: { 
		type: String, 
		required: [true, "can't be blank"]
	},
	favorites: [{ 
		type: mongoose.Schema.Types.ObjectId, 
		ref: 'pizza' 
	}],
});

UserSchema.plugin(uniqueValidator, {message: 'is already taken.'});

// Bcrypt password function when saving
UserSchema.pre('save', function (next) {
  var user = this;
  bcrypt.hash(user.password, 10, function (err, hash){
    if (err) {
      return next(err);
    }
    user.password = hash;
    next();
  })
});

//Pre-create favourite food function
UserSchema.methods.favorite = function(id){
  if(this.favorites.indexOf(id) === -1){
    this.favorites.push(id);
  }

  return this.save();
};

UserSchema.methods.unfavorite = function(id){
  this.favorites.remove(id);
  return this.save();
};

module.export = mongoose.model('User',Userschema);