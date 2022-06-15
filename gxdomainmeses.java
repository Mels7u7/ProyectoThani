package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomainmeses
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"01"), "Enero");
      domain.put(new String((String)"02"), "Febrero");
      domain.put(new String((String)"03"), "Marzo");
      domain.put(new String((String)"04"), "Abril");
      domain.put(new String((String)"05"), "Mayo");
      domain.put(new String((String)"06"), "Junio");
      domain.put(new String((String)"07"), "Julio");
      domain.put(new String((String)"08"), "Agosto");
      domain.put(new String((String)"09"), "Septiembre");
      domain.put(new String((String)"10"), "Octubre");
      domain.put(new String((String)"11"), "Noviembre");
      domain.put(new String((String)"12"), "Diciembre");
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

