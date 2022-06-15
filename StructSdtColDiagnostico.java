package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColDiagnostico", namespace ="ProjectThani")
public final  class StructSdtColDiagnostico implements Cloneable, java.io.Serializable
{
   public StructSdtColDiagnostico( )
   {
      this( -1, new ModelContext( StructSdtColDiagnostico.class ));
   }

   public StructSdtColDiagnostico( int remoteHandle ,
                                   ModelContext context )
   {
   }

   public  StructSdtColDiagnostico( java.util.Vector<StructSdtDiagnostico> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Diagnostico",namespace="ProjectThani")
   public java.util.Vector<StructSdtDiagnostico> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDiagnostico> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDiagnostico> item = new java.util.Vector<>();
}

