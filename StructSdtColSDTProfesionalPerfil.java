package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalPerfil", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalPerfil implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalPerfil( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalPerfil.class ));
   }

   public StructSdtColSDTProfesionalPerfil( int remoteHandle ,
                                            ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalPerfil( java.util.Vector<StructSdtSDTProfesionalPerfil> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalPerfil",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalPerfil> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalPerfil> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalPerfil> item = new java.util.Vector<>();
}

