for $x at $i in doc("./recursos/xquery_ejemplo1.xml")/recetario/receta/nombreReceta
return <receta>{$i}. {data($x)}</receta>
