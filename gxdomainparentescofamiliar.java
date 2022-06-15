package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomainparentescofamiliar
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"H"), "Hijo(a)");
      domain.put(new String((String)"P"), "Padre");
      domain.put(new String((String)"M"), "Madre");
      domain.put(new String((String)"HM"), "Hermano(a)");
      domain.put(new String((String)"S"), "Sobrino(a)");
      domain.put(new String((String)"T"), "Tio(a)");
      domain.put(new String((String)"A"), "Abuelo(a)");
      domain.put(new String((String)"N"), "Nieto(a)");
      domain.put(new String((String)"O"), "Otro");
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

