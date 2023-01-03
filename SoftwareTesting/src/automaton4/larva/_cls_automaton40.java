package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_automaton40 implements _callable{

public static PrintWriter pw; 
public static _cls_automaton40 root;

public static LinkedHashMap<_cls_automaton40,_cls_automaton40> _cls_automaton40_instances = new LinkedHashMap<_cls_automaton40,_cls_automaton40>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Daryl\\workspace\\SoftwareTesting/src/automaton4/output_automaton4.txt");

root = new _cls_automaton40();
_cls_automaton40_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_automaton40 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public int postedAlertIconType ;
 public int visibleAlerts ;
 public int visibleAlertIconType ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_automaton40() {
}

public void initialisation() {
}

public static _cls_automaton40 _get_cls_automaton40_inst() { synchronized(_cls_automaton40_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_automaton40))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_automaton40_instances){
_performLogic_alert_icon_type_prop(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_automaton40[] a = new _cls_automaton40[1];
synchronized(_cls_automaton40_instances){
a = _cls_automaton40_instances.keySet().toArray(a);}
for (_cls_automaton40 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_automaton40_instances){
_cls_automaton40_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_alert_icon_type_prop = 67;

public void _performLogic_alert_icon_type_prop(String _info, int... _event) {

_cls_automaton40.pw.println("[alert_icon_type_prop]AUTOMATON::> alert_icon_type_prop("+") STATE::>"+ _string_alert_icon_type_prop(_state_id_alert_icon_type_prop, 0));
_cls_automaton40.pw.flush();

if (0==1){}
else if (_state_id_alert_icon_type_prop==67){
		if (1==0){}
		else if ((_occurredEvent(_event,144/*viewAlert_correctAlertType*/))){
		_cls_automaton40.pw .println ("viewingAlerts event");

		_state_id_alert_icon_type_prop = 66;//moving to state viewingAlerts
		_goto_alert_icon_type_prop(_info);
		}
		else if ((_occurredEvent(_event,146/*viewAlert_mismatchingAlertType*/))){
		_cls_automaton40.pw .println ("Mismatching alert type - entered bad state!");

		_state_id_alert_icon_type_prop = 65;//moving to state badState
		_goto_alert_icon_type_prop(_info);
		}
		else if ((_occurredEvent(_event,148/*viewAlert_alertNotFound*/))){
		_cls_automaton40.pw .println ("Alert not found - entered bad state!");

		_state_id_alert_icon_type_prop = 65;//moving to state badState
		_goto_alert_icon_type_prop(_info);
		}
}
}

public void _goto_alert_icon_type_prop(String _info){
_cls_automaton40.pw.println("[alert_icon_type_prop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alert_icon_type_prop(_state_id_alert_icon_type_prop, 1));
_cls_automaton40.pw.flush();
}

public String _string_alert_icon_type_prop(int _state_id, int _mode){
switch(_state_id){
case 65: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionautomaton4().toString()+" ";
case 66: if (_mode == 0) return "viewingAlerts"; else return "viewingAlerts";
case 67: if (_mode == 0) return "loggedIn"; else return "loggedIn";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}