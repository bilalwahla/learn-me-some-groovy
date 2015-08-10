def map = [a:[b:[c:1]]]assert map.a.b.c == 1// Short-circuit evaluationif(map && map.a && map.a.x) {  assert map.a.x.c == null}// try/catchtry {  assert map.a.x.c == null} catch (NullPointerException npe){}// Safe dereferencing/*Groovy provides the additional ?. operator for safe dereferencing. When thereference before that operator is a null reference, the evaluation of thecurrent expression stops, and null is returned*/assert map?.a?.x?.c == null // evaluation stops at x?.