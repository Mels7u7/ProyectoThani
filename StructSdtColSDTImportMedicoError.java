package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTImportMedicoError", namespace ="ProjectThani")
public final  class StructSdtColSDTImportMedicoError implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTImportMedicoError( )
   {
      this( -1, new ModelContext( StructSdtColSDTImportMedicoError.class ));
   }

   public StructSdtColSDTImportMedicoError( int remoteHandle ,
                                            ModelContext context )
   {
   }

   public  StructSdtColSDTImportMedicoError( java.util.Vector<StructSdtSDTImportMedicoError> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTImportMedicoError",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTImportMedicoError> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTImportMedicoError> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTImportMedicoError> item = new java.util.Vector<>();
}

