package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTCuentaPorVerificarProfesional", namespace ="ProjectThani")
public final  class StructSdtColSDTCuentaPorVerificarProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTCuentaPorVerificarProfesional( )
   {
      this( -1, new ModelContext( StructSdtColSDTCuentaPorVerificarProfesional.class ));
   }

   public StructSdtColSDTCuentaPorVerificarProfesional( int remoteHandle ,
                                                        ModelContext context )
   {
   }

   public  StructSdtColSDTCuentaPorVerificarProfesional( java.util.Vector<StructSdtSDTCuentaPorVerificarProfesional> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTCuentaPorVerificarProfesional",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTCuentaPorVerificarProfesional> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTCuentaPorVerificarProfesional> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTCuentaPorVerificarProfesional> item = new java.util.Vector<>();
}

