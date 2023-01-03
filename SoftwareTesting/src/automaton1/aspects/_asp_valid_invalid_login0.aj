package aspects;

import larva.*;
public aspect _asp_valid_invalid_login0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_valid_invalid_login0.initialize();
}
}
before () : (call(* *.validLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_valid_invalid_login0.lock){

_cls_valid_invalid_login0 _cls_inst = _cls_valid_invalid_login0._get_cls_valid_invalid_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 8/*validLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 8/*validLogin*/);
}
}
before () : (call(* *.invalidLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_valid_invalid_login0.lock){

_cls_valid_invalid_login0 _cls_inst = _cls_valid_invalid_login0._get_cls_valid_invalid_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 6/*invalidLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 6/*invalidLogin*/);
}
}
before () : (call(* *.logOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_valid_invalid_login0.lock){

_cls_valid_invalid_login0 _cls_inst = _cls_valid_invalid_login0._get_cls_valid_invalid_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 10/*logOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 10/*logOut*/);
}
}
}