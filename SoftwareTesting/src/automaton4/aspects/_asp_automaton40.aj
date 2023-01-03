package aspects;

import larva.*;
public aspect _asp_automaton40 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_automaton40.initialize();
}
}
before () : (call(* *.viewAlert_correctAlertType(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton40.lock){

_cls_automaton40 _cls_inst = _cls_automaton40._get_cls_automaton40_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 144/*viewAlert_correctAlertType*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 144/*viewAlert_correctAlertType*/);
}
}
before () : (call(* *.viewAlert_alertNotFound(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton40.lock){

_cls_automaton40 _cls_inst = _cls_automaton40._get_cls_automaton40_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 148/*viewAlert_alertNotFound*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 148/*viewAlert_alertNotFound*/);
}
}
before () : (call(* *.viewAlert_mismatchingAlertType(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton40.lock){

_cls_automaton40 _cls_inst = _cls_automaton40._get_cls_automaton40_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 146/*viewAlert_mismatchingAlertType*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 146/*viewAlert_mismatchingAlertType*/);
}
}
}