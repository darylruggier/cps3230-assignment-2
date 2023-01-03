package aspects;

import larva.*;
public aspect _asp_automaton30 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_automaton30.initialize();
}
}
before () : (call(* *.viewAlertsCorrect1(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton30.lock){

_cls_automaton30 _cls_inst = _cls_automaton30._get_cls_automaton30_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 130/*viewAlertsCorrect1*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 130/*viewAlertsCorrect1*/);
}
}
before () : (call(* *.viewAlertsCorrect2(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton30.lock){

_cls_automaton30 _cls_inst = _cls_automaton30._get_cls_automaton30_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 132/*viewAlertsCorrect2*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 132/*viewAlertsCorrect2*/);
}
}
before () : (call(* *.viewAlertsBadState2(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton30.lock){

_cls_automaton30 _cls_inst = _cls_automaton30._get_cls_automaton30_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 136/*viewAlertsBadState2*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 136/*viewAlertsBadState2*/);
}
}
before () : (call(* *.viewAlertsBadState1(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton30.lock){

_cls_automaton30 _cls_inst = _cls_automaton30._get_cls_automaton30_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 134/*viewAlertsBadState1*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 134/*viewAlertsBadState1*/);
}
}
}