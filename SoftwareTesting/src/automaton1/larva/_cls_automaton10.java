package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_automaton10 implements _callable{

public static PrintWriter pw; 
public static _cls_automaton10 root;

public static LinkedHashMap<_cls_automaton10,_cls_automaton10> _cls_automaton10_instances = new LinkedHashMap<_cls_automaton10,_cls_automaton10>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\Daryl\\workspace\\SoftwareTesting/src/automaton1/output_automaton1.txt");

root = new _cls_automaton10();
_cls_automaton10_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_automaton10 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean loggedIn =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_automaton10() {
}

public void initialisation() {
}

public static _cls_automaton10 _get_cls_automaton10_inst() { synchronized(_cls_automaton10_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_automaton10))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_automaton10_instances){
_performLogic_valid_invalid_logins_prop(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_automaton10[] a = new _cls_automaton10[1];
synchronized(_cls_automaton10_instances){
a = _cls_automaton10_instances.keySet().toArray(a);}
for (_cls_automaton10 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_automaton10_instances){
_cls_automaton10_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_valid_invalid_logins_prop = 64;

public void _performLogic_valid_invalid_logins_prop(String _info, int... _event) {

_cls_automaton10.pw.println("[valid_invalid_logins_prop]AUTOMATON::> valid_invalid_logins_prop("+") STATE::>"+ _string_valid_invalid_logins_prop(_state_id_valid_invalid_logins_prop, 0));
_cls_automaton10.pw.flush();

if (0==1){}
else if (_state_id_valid_invalid_logins_prop==63){
		if (1==0){}
		else if ((_occurredEvent(_event,142/*logOut*/))){
		loggedIn =false ;
_cls_automaton10.pw .println ("logOut event");

		_state_id_valid_invalid_logins_prop = 64;//moving to state loggedOut
		_goto_valid_invalid_logins_prop(_info);
		}
}
else if (_state_id_valid_invalid_logins_prop==64){
		if (1==0){}
		else if ((_occurredEvent(_event,138/*invalidLogin*/))){
		_cls_automaton10.pw .println ("invalidLogin event");

		_state_id_valid_invalid_logins_prop = 64;//moving to state loggedOut
		_goto_valid_invalid_logins_prop(_info);
		}
		else if ((_occurredEvent(_event,140/*validLogin*/))){
		loggedIn =true ;
_cls_automaton10.pw .println ("validLogin event");

		_state_id_valid_invalid_logins_prop = 63;//moving to state loggedIn
		_goto_valid_invalid_logins_prop(_info);
		}
}
}

public void _goto_valid_invalid_logins_prop(String _info){
_cls_automaton10.pw.println("[valid_invalid_logins_prop]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_valid_invalid_logins_prop(_state_id_valid_invalid_logins_prop, 1));
_cls_automaton10.pw.flush();
}

public String _string_valid_invalid_logins_prop(int _state_id, int _mode){
switch(_state_id){
case 63: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 64: if (_mode == 0) return "loggedOut"; else return "loggedOut";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}