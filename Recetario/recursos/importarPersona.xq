for $x at $i in doc("./recursos/recetario.xml")/recetario/receta/nombreReceta
return <receta>{$i}. {data($x)}</receta>
