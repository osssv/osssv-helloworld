var http = require('http');

var server = http.createServer();
server.on('request', doRequest);
server.listen(1337);
console.log('Server running!');

function doRequest(req, res){
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.write('Hello World\n');
  res.end();
}
