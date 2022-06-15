package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomaintipodocumentocliente
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"6"), "RUC");
      domain.put(new String((String)"1"), "DNI");
      domain.put(new String((String)"4"), "CARNET DE EXT.");
      domain.put(new String((String)"7"), "PASAPORTE");
      domain.put(new String((String)"A"), "CDI");
      domain.put(new String((String)"0"), "NO DOMICILIADO");
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

