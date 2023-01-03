package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_automaton30 implements _callable{

public static PrintWriter pw; 
public static _cls_automaton30 root;

public static LinkedHashMap<_cls_automaton30,_cls_automaton30> _cls_automaton30_instances = new LinkedHashMap<_cls_automaton30,_cls_automaton30>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Daryl\\workspace\\SoftwareTesting/src/automaton3/output_automaton3.txt");

root = new _cls_automaton30();
_cls_automaton30_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_automaton30 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public int numberOfAlertsPosted ;
 public int visibleAlerts ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_automaton30() {
}

public void initialisation() {
}

public static _cls_automaton30 _get_cls_automaton30_inst() { synchronized(_cls_automaton30_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_automaton30))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_automaton30_instances){
_performLogic_alert_layout_limit_prop(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_automaton30[] a = new _cls_automaton30[1];
synchronized(_cls_automaton30_instances){
a = _cls_automaton30_instances.keySet().toArray(a);}
for (_cls_automaton30 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_automaton30_instances){
_cls_automaton30_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_alert_layout_limit_prop = 62;

public void _performLogic_alert_layout_limit_prop(String _info, int... _event) {

_cls_automaton30.pw.println("[alert_layout_limit_prop]AUTOMATON::> alert_layout_limit_prop("+") STATE::>"+ _string_alert_layout_limit_prop(_state_id_alert_layout_limit_prop, 0));
_cls_automaton30.pw.flush();

if (0==1){}
else if (_state_id_alert_layout_limit_prop==62){
		if (1==0){}
		else if ((_occurredEvent(_event,130/*viewAlertsCorrect1*/))){
		_cls_automaton30.pw .println ("viewingAlerts event");

		_state_id_alert_layout_limit_prop = 61;//moving to state viewingAlerts
		_goto_alert_layout_limit_prop(_info);
		}
		else if ((_occurredEvent(_event,132/*viewAlertsCorrect2*/))){
		_cls_automaton30.pw .println ("viewingAlerts event");

		_state_id_alert_layout_limit_prop = 61;//moving to state viewingAlerts
		_goto_alert_layout_limit_prop(_info);
		}
		else if ((_occurredEvent(_event,134/*viewAlertsBadState1*/))){
		_cls_automaton30.pw .println ("Entered bad state!");

		_state_id_alert_layout_limit_prop = 60;//moving to state badState
		_goto_alert_layout_limit_prop(_info);
		}
		else if ((_occurredEvent(_event,136/*viewAlertsBadState2*/))){
		_cls_automaton30.pw .println ("Entered bad state!");

		_state_id_alert_layout_limit_prop = 60;//moving to state badState
		_goto_alert_layout_limit_prop(_info);
		}
}
}

public void _goto_alert_layout_limit_prop(String _info){
_cls_automaton30.pw.println("[alert_layout_limit_prop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alert_layout_limit_prop(_state_id_alert_layout_limit_prop, 1));
_cls_automaton30.pw.flush();
}

public String _string_alert_layout_limit_prop(int _state_id, int _mode){
switch(_state_id){
case 60: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionautomaton3().toString()+" ";
case 61: if (_mode == 0) return "viewingAlerts"; else return "viewingAlerts";
case 62: if (_mode == 0) return "loggedIn"; else return "loggedIn";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}