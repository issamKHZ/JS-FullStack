// index.js
// where your node app starts

// init project
var express = require('express');
var app = express();

// enable CORS (https://en.wikipedia.org/wiki/Cross-origin_resource_sharing)
// so that your API is remotely testable by FCC 
var cors = require('cors');
app.use(cors({ optionsSuccessStatus: 200 }));  // some legacy browsers choke on 204

// http://expressjs.com/en/starter/static-files.html
app.use(express.static('public'));

// http://expressjs.com/en/starter/basic-routing.html
app.get("/", function(req, res) {
  res.sendFile(__dirname + '/views/index.html');
});


// your first API endpoint... 
app.get("/api/:param", function(req, res, next) {
  const input = req.params.param;
  if (/^[0-9]+$/.test(input)) {   
    var date = new Date(parseInt(input));
    console.log(date);
    var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    var days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    var output = days[date.getUTCDay()] + ', ' +
             ('0' + date.getUTCDate()).slice(-2) + ' ' +
             months[date.getUTCMonth()] + ' ' +
             date.getUTCFullYear() + ' ' +
             ('0' + date.getUTCHours()).slice(-2) + ':' +
             ('0' + date.getUTCMinutes()).slice(-2) + ':' +
             ('0' + date.getUTCSeconds()).slice(-2) + ' GMT';
    res.json({unix: input, utc:output}); 
  } 
  if (/^\d{4}-\d{2}-\d{2}$/.test(input)) {
    var dateDonnee = new Date(input);
    var timestamp = dateDonnee.getTime();    
    var date = new Date(timestamp);
    var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    var days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    var output = days[date.getUTCDay()] + ', ' +
             ('0' + date.getUTCDate()).slice(-2) + ' ' +
             months[date.getUTCMonth()] + ' ' +
             date.getUTCFullYear() + ' ' +
             ('0' + date.getUTCHours()).slice(-2) + ':' +
             ('0' + date.getUTCMinutes()).slice(-2) + ':' +
             ('0' + date.getUTCSeconds()).slice(-2) + ' GMT';

  res.json({unix: timestamp, utc:output});
  } else {
    res.json({ boolean: "req out service" });
  }
});



// listen for requests :)
var listener = app.listen(process.env.PORT, function() {
  console.log('Your app is listening on port ' + listener.address().port);
});
