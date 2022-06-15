package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColPacienteFamiliar", namespace ="ProjectThani")
public final  class StructSdtColPacienteFamiliar implements Cloneable, java.io.Serializable
{
   public StructSdtColPacienteFamiliar( )
   {
      this( -1, new ModelContext( StructSdtColPacienteFamiliar.class ));
   }

   public StructSdtColPacienteFamiliar( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColPacienteFamiliar( java.util.Vector<StructSdtPacienteFamiliar> value )
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

   @javax.xml.bind.annotation.XmlElement(name="PacienteFamiliar",namespace="ProjectThani")
   public java.util.Vector<StructSdtPacienteFamiliar> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtPacienteFamiliar> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtPacienteFamiliar> item = new java.util.Vector<>();
}

