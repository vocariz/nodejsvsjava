'use strict';

(function(){

	var count = 0;
	function activate(req,res,next){
		count++;
		console.log("nodejsRest; requestId=" + req.query.reqId + "; delayMillis=" + req.query.delay + ";");
		if(req.query.delay > 0){
			setTimeout(function() {
			  res.json({responseId:count, requestId:req.query.reqId, delayMillis:req.query.delay});
			}, req.query.delay);		
		}else{
			res.json({responseId:count, requestId:req.query.reqId, delayMillis:req.query.delay});
		}
		
	}

	exports.nodejsRestCrtl = activate;

}());

