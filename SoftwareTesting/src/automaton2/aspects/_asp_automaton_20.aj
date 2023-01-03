package aspects;

import larva.*;
public aspect _asp_automaton_20 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_automaton_20.initialize();
}
}
before () : (call(* *.viewAlertsWithValidLayout(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton_20.lock){

_cls_automaton_20 _cls_inst = _cls_automaton_20._get_cls_automaton_20_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 150/*viewAlertsWithValidLayout*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 150/*viewAlertsWithValidLayout*/);
}
}
before () : (call(* *.viewAlertsWithInvalidLayout(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_automaton_20.lock){

_cls_automaton_20 _cls_inst = _cls_automaton_20._get_cls_automaton_20_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 152/*viewAlertsWithInvalidLayout*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 152/*viewAlertsWithInvalidLayout*/);
}
}
}