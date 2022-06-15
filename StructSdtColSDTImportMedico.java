package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTImportMedico", namespace ="ProjectThani")
public final  class StructSdtColSDTImportMedico implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTImportMedico( )
   {
      this( -1, new ModelContext( StructSdtColSDTImportMedico.class ));
   }

   public StructSdtColSDTImportMedico( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtColSDTImportMedico( java.util.Vector<StructSdtSDTImportMedico> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTImportMedico",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTImportMedico> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTImportMedico> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTImportMedico> item = new java.util.Vector<>();
}

