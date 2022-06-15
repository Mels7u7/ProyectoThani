package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColCitaDiagnostico", namespace ="ProjectThani")
public final  class StructSdtColCitaDiagnostico implements Cloneable, java.io.Serializable
{
   public StructSdtColCitaDiagnostico( )
   {
      this( -1, new ModelContext( StructSdtColCitaDiagnostico.class ));
   }

   public StructSdtColCitaDiagnostico( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtColCitaDiagnostico( java.util.Vector<StructSdtCitaDiagnostico> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="CitaDiagnostico",namespace="ProjectThani")
   public java.util.Vector<StructSdtCitaDiagnostico> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCitaDiagnostico> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCitaDiagnostico> item = new java.util.Vector<>();
}

