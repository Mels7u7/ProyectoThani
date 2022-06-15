package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalPremiosPerfil", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalPremiosPerfil implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalPremiosPerfil( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalPremiosPerfil.class ));
   }

   public StructSdtColSDTProfesionalPremiosPerfil( int remoteHandle ,
                                                   ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalPremiosPerfil( java.util.Vector<StructSdtSDTProfesionalPremiosPerfil> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalPremiosPerfil",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalPremiosPerfil> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalPremiosPerfil> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalPremiosPerfil> item = new java.util.Vector<>();
}

