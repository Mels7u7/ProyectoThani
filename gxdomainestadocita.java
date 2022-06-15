package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomainestadocita
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"R"), "Registrado");
      domain.put(new String((String)"C"), "Confirmado");
      domain.put(new String((String)"A"), "En Atención");
      domain.put(new String((String)"F"), "Finalizado");
      domain.put(new String((String)"X"), "Cancelado");
      domain.put(new String((String)"N"), "No se presentó");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        String key )
   {
      if (domain.containsKey( key.trim() ))
      {
         return (String)domain.get( key.trim() );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<String> getValues( )
   {
      GXSimpleCollection<String> value = new GXSimpleCollection<String>(String.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((String) itr.next());
      }
      return value;
   }

}

