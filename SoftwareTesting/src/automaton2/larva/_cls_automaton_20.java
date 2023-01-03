package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_automaton_20 implements _callable{

public static PrintWriter pw; 
public static _cls_automaton_20 root;

public static LinkedHashMap<_cls_automaton_20,_cls_automaton_20> _cls_automaton_20_instances = new LinkedHashMap<_cls_automaton_20,_cls_automaton_20>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Daryl\\workspace\\SoftwareTesting/src/automaton2/output_automaton_2.txt");

root = new _cls_automaton_20();
_cls_automaton_20_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_automaton_20 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean alertsAreVerified ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_automaton_20() {
}

public void initialisation() {
}

public static _cls_automaton_20 _get_cls_automaton_20_inst() { synchronized(_cls_automaton_20_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_automaton_20))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_automaton_20_instances){
_performLogic_alert_layout_prop(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_automaton_20[] a = new _cls_automaton_20[1];
synchronized(_cls_automaton_20_instances){
a = _cls_automaton_20_instances.keySet().toArray(a);}
for (_cls_automaton_20 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_automaton_20_instances){
_cls_automaton_20_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_alert_layout_prop = 70;

public void _performLogic_alert_layout_prop(String _info, int... _event) {

_cls_automaton_20.pw.println("[alert_layout_prop]AUTOMATON::> alert_layout_prop("+") STATE::>"+ _string_alert_layout_prop(_state_id_alert_layout_prop, 0));
_cls_automaton_20.pw.flush();

if (0==1){}
else if (_state_id_alert_layout_prop==70){
		if (1==0){}
		else if ((_occurredEvent(_event,150/*viewAlertsWithValidLayout*/))){
		alertsAreVerified =true ;
_cls_automaton_20.pw .println ("Alert Layouts are Valid!");

		_state_id_alert_layout_prop = 69;//moving to state viewingAlerts
		_goto_alert_layout_prop(_info);
		}
		else if ((_occurredEvent(_event,152/*viewAlertsWithInvalidLayout*/))){
		alertsAreVerified =false ;
_cls_automaton_20.pw .println ("Invalid alert layouts! Entering bad state!");

		_state_id_alert_layout_prop = 68;//moving to state badState
		_goto_alert_layout_prop(_info);
		}
}
}

public void _goto_alert_layout_prop(String _info){
_cls_automaton_20.pw.println("[alert_layout_prop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alert_layout_prop(_state_id_alert_layout_prop, 1));
_cls_automaton_20.pw.flush();
}

public String _string_alert_layout_prop(int _state_id, int _mode){
switch(_state_id){
case 68: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionautomaton_2().toString()+" ";
case 69: if (_mode == 0) return "viewingAlerts"; else return "viewingAlerts";
case 70: if (_mode == 0) return "loggedIn"; else return "loggedIn";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}