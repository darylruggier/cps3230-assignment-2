package aspects;

import larva.*;
public aspect _asp_automaton10 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_automaton10.initialize();
}
}
before () : (call(* *.validLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton10.lock){

_cls_automaton10 _cls_inst = _cls_automaton10._get_cls_automaton10_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 140/*validLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 140/*validLogin*/);
}
}
before () : (call(* *.invalidLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton10.lock){

_cls_automaton10 _cls_inst = _cls_automaton10._get_cls_automaton10_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 138/*invalidLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 138/*invalidLogin*/);
}
}
before () : (call(* *.logOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton10.lock){

_cls_automaton10 _cls_inst = _cls_automaton10._get_cls_automaton10_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 142/*logOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 142/*logOut*/);
}
}
}