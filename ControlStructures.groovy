// Be careful with assign and test a conditiondef x = 1/* Even though this will throw a compile error.Not allowed as a top- level expression in an 'if' testif(x = 2) {  println x}*/// This will print. Should really be == rather than =while(x = 1){  println x  break}// Switchdef a = 1def log = ''switch (a) {  // case 0  and 1 fall through  case 0 :log+='0'  case 1 :log+='1'  // case 2 breaks the control  case 2 :log+='2';break  default : log += 'default'}assert log == '12'// Switch with classfiers. Quite cool.switch (12) {  case 0: assert false; break  case 0..9: assert false; break  case [8,9,11]: assert false; break  // Can classify by type  case Float: assert false; break  // Result of the closure call is coerced to a Boolean  case {it%3 == 0}: assert true; break  case ~/../: assert false; break  default: assert false; break}// Looping// Whiledef list = [1,2,3]// NOTE the condition herewhile (list) {  list.remove(0)}assert list == []while (list.size() < 3) list << list.size() + 1assert list == [1,2,3]// For has been covered already