package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSecUser extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtSecUser( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtSecUser.class));
   }

   public SdtSecUser( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtSecUser");
      initialize( remoteHandle) ;
   }

   public SdtSecUser( int remoteHandle ,
                      StructSdtSecUser struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( short AV6SecUserId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV6SecUserId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"SecUserId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\SecUser");
      metadata.set("BT", "SecUser");
      metadata.set("PK", "[ \"SecUserId\" ]");
      metadata.set("PKAssigned", "[ \"SecUserId\" ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId") )
            {
               gxTv_SdtSecUser_Secuserid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserName") )
            {
               gxTv_SdtSecUser_Secusername = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPassword") )
            {
               gxTv_SdtSecUser_Secuserpassword = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserEmail") )
            {
               gxTv_SdtSecUser_Secuseremail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserEstadoR") )
            {
               gxTv_SdtSecUser_Secuserestador = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtSecUser_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtSecUser_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId_Z") )
            {
               gxTv_SdtSecUser_Secuserid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserName_Z") )
            {
               gxTv_SdtSecUser_Secusername_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserPassword_Z") )
            {
               gxTv_SdtSecUser_Secuserpassword_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserEmail_Z") )
            {
               gxTv_SdtSecUser_Secuseremail_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserEstadoR_Z") )
            {
               gxTv_SdtSecUser_Secuserestador_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId_N") )
            {
               gxTv_SdtSecUser_Secuserid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "SecUser" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "ProjectThani" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("SecUserId", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserName", GXutil.rtrim( gxTv_SdtSecUser_Secusername));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserPassword", GXutil.rtrim( gxTv_SdtSecUser_Secuserpassword));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserEmail", GXutil.rtrim( gxTv_SdtSecUser_Secuseremail));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserEstadoR", GXutil.rtrim( gxTv_SdtSecUser_Secuserestador));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtSecUser_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserId_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserName_Z", GXutil.rtrim( gxTv_SdtSecUser_Secusername_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserPassword_Z", GXutil.rtrim( gxTv_SdtSecUser_Secuserpassword_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserEmail_Z", GXutil.rtrim( gxTv_SdtSecUser_Secuseremail_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserEstadoR_Z", GXutil.rtrim( gxTv_SdtSecUser_Secuserestador_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserId_N", GXutil.trim( GXutil.str( gxTv_SdtSecUser_Secuserid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("SecUserId", gxTv_SdtSecUser_Secuserid, false, includeNonInitialized);
      AddObjectProperty("SecUserId_N", gxTv_SdtSecUser_Secuserid_N, false, includeNonInitialized);
      AddObjectProperty("SecUserName", gxTv_SdtSecUser_Secusername, false, includeNonInitialized);
      AddObjectProperty("SecUserPassword", gxTv_SdtSecUser_Secuserpassword, false, includeNonInitialized);
      AddObjectProperty("SecUserEmail", gxTv_SdtSecUser_Secuseremail, false, includeNonInitialized);
      AddObjectProperty("SecUserEstadoR", gxTv_SdtSecUser_Secuserestador, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtSecUser_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtSecUser_Initialized, false, includeNonInitialized);
         AddObjectProperty("SecUserId_Z", gxTv_SdtSecUser_Secuserid_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserName_Z", gxTv_SdtSecUser_Secusername_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserPassword_Z", gxTv_SdtSecUser_Secuserpassword_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserEmail_Z", gxTv_SdtSecUser_Secuseremail_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserEstadoR_Z", gxTv_SdtSecUser_Secuserestador_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserId_N", gxTv_SdtSecUser_Secuserid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.wwpbaseobjects.SdtSecUser sdt )
   {
      if ( sdt.IsDirty("SecUserId") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserid = sdt.getgxTv_SdtSecUser_Secuserid() ;
      }
      if ( sdt.IsDirty("SecUserName") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secusername = sdt.getgxTv_SdtSecUser_Secusername() ;
      }
      if ( sdt.IsDirty("SecUserPassword") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserpassword = sdt.getgxTv_SdtSecUser_Secuserpassword() ;
      }
      if ( sdt.IsDirty("SecUserEmail") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuseremail = sdt.getgxTv_SdtSecUser_Secuseremail() ;
      }
      if ( sdt.IsDirty("SecUserEstadoR") )
      {
         gxTv_SdtSecUser_N = (byte)(0) ;
         gxTv_SdtSecUser_Secuserestador = sdt.getgxTv_SdtSecUser_Secuserestador() ;
      }
   }

   public short getgxTv_SdtSecUser_Secuserid( )
   {
      return gxTv_SdtSecUser_Secuserid ;
   }

   public void setgxTv_SdtSecUser_Secuserid( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      if ( gxTv_SdtSecUser_Secuserid != value )
      {
         gxTv_SdtSecUser_Mode = "INS" ;
         this.setgxTv_SdtSecUser_Secuserid_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secusername_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secuserpassword_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secuseremail_Z_SetNull( );
         this.setgxTv_SdtSecUser_Secuserestador_Z_SetNull( );
      }
      SetDirty("Secuserid");
      gxTv_SdtSecUser_Secuserid = value ;
   }

   public String getgxTv_SdtSecUser_Secusername( )
   {
      return gxTv_SdtSecUser_Secusername ;
   }

   public void setgxTv_SdtSecUser_Secusername( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusername");
      gxTv_SdtSecUser_Secusername = value ;
   }

   public String getgxTv_SdtSecUser_Secuserpassword( )
   {
      return gxTv_SdtSecUser_Secuserpassword ;
   }

   public void setgxTv_SdtSecUser_Secuserpassword( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserpassword");
      gxTv_SdtSecUser_Secuserpassword = value ;
   }

   public String getgxTv_SdtSecUser_Secuseremail( )
   {
      return gxTv_SdtSecUser_Secuseremail ;
   }

   public void setgxTv_SdtSecUser_Secuseremail( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuseremail");
      gxTv_SdtSecUser_Secuseremail = value ;
   }

   public String getgxTv_SdtSecUser_Secuserestador( )
   {
      return gxTv_SdtSecUser_Secuserestador ;
   }

   public void setgxTv_SdtSecUser_Secuserestador( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserestador");
      gxTv_SdtSecUser_Secuserestador = value ;
   }

   public String getgxTv_SdtSecUser_Mode( )
   {
      return gxTv_SdtSecUser_Mode ;
   }

   public void setgxTv_SdtSecUser_Mode( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtSecUser_Mode = value ;
   }

   public void setgxTv_SdtSecUser_Mode_SetNull( )
   {
      gxTv_SdtSecUser_Mode = "" ;
   }

   public boolean getgxTv_SdtSecUser_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecUser_Initialized( )
   {
      return gxTv_SdtSecUser_Initialized ;
   }

   public void setgxTv_SdtSecUser_Initialized( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtSecUser_Initialized = value ;
   }

   public void setgxTv_SdtSecUser_Initialized_SetNull( )
   {
      gxTv_SdtSecUser_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtSecUser_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecUser_Secuserid_Z( )
   {
      return gxTv_SdtSecUser_Secuserid_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserid_Z( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserid_Z");
      gxTv_SdtSecUser_Secuserid_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserid_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtSecUser_Secuserid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secusername_Z( )
   {
      return gxTv_SdtSecUser_Secusername_Z ;
   }

   public void setgxTv_SdtSecUser_Secusername_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secusername_Z");
      gxTv_SdtSecUser_Secusername_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secusername_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secusername_Z = "" ;
   }

   public boolean getgxTv_SdtSecUser_Secusername_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secuserpassword_Z( )
   {
      return gxTv_SdtSecUser_Secuserpassword_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserpassword_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserpassword_Z");
      gxTv_SdtSecUser_Secuserpassword_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserpassword_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserpassword_Z = "" ;
   }

   public boolean getgxTv_SdtSecUser_Secuserpassword_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secuseremail_Z( )
   {
      return gxTv_SdtSecUser_Secuseremail_Z ;
   }

   public void setgxTv_SdtSecUser_Secuseremail_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuseremail_Z");
      gxTv_SdtSecUser_Secuseremail_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuseremail_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuseremail_Z = "" ;
   }

   public boolean getgxTv_SdtSecUser_Secuseremail_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUser_Secuserestador_Z( )
   {
      return gxTv_SdtSecUser_Secuserestador_Z ;
   }

   public void setgxTv_SdtSecUser_Secuserestador_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserestador_Z");
      gxTv_SdtSecUser_Secuserestador_Z = value ;
   }

   public void setgxTv_SdtSecUser_Secuserestador_Z_SetNull( )
   {
      gxTv_SdtSecUser_Secuserestador_Z = "" ;
   }

   public boolean getgxTv_SdtSecUser_Secuserestador_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtSecUser_Secuserid_N( )
   {
      return gxTv_SdtSecUser_Secuserid_N ;
   }

   public void setgxTv_SdtSecUser_Secuserid_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      SetDirty("Secuserid_N");
      gxTv_SdtSecUser_Secuserid_N = value ;
   }

   public void setgxTv_SdtSecUser_Secuserid_N_SetNull( )
   {
      gxTv_SdtSecUser_Secuserid_N = (byte)(0) ;
   }

   public boolean getgxTv_SdtSecUser_Secuserid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.wwpbaseobjects.secuser_bc obj;
      obj = new com.projectthani.wwpbaseobjects.secuser_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtSecUser_N = (byte)(1) ;
      gxTv_SdtSecUser_Secusername = "" ;
      gxTv_SdtSecUser_Secuserpassword = "" ;
      gxTv_SdtSecUser_Secuseremail = "" ;
      gxTv_SdtSecUser_Secuserestador = "A" ;
      gxTv_SdtSecUser_Mode = "" ;
      gxTv_SdtSecUser_Secusername_Z = "" ;
      gxTv_SdtSecUser_Secuserpassword_Z = "" ;
      gxTv_SdtSecUser_Secuseremail_Z = "" ;
      gxTv_SdtSecUser_Secuserestador_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSecUser_N ;
   }

   public com.projectthani.wwpbaseobjects.SdtSecUser Clone( )
   {
      com.projectthani.wwpbaseobjects.SdtSecUser sdt;
      com.projectthani.wwpbaseobjects.secuser_bc obj;
      sdt = (com.projectthani.wwpbaseobjects.SdtSecUser)(clone()) ;
      obj = (com.projectthani.wwpbaseobjects.secuser_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.wwpbaseobjects.StructSdtSecUser struct )
   {
      setgxTv_SdtSecUser_Secuserid(struct.getSecuserid());
      setgxTv_SdtSecUser_Secusername(struct.getSecusername());
      setgxTv_SdtSecUser_Secuserpassword(struct.getSecuserpassword());
      setgxTv_SdtSecUser_Secuseremail(struct.getSecuseremail());
      setgxTv_SdtSecUser_Secuserestador(struct.getSecuserestador());
      setgxTv_SdtSecUser_Mode(struct.getMode());
      setgxTv_SdtSecUser_Initialized(struct.getInitialized());
      setgxTv_SdtSecUser_Secuserid_Z(struct.getSecuserid_Z());
      setgxTv_SdtSecUser_Secusername_Z(struct.getSecusername_Z());
      setgxTv_SdtSecUser_Secuserpassword_Z(struct.getSecuserpassword_Z());
      setgxTv_SdtSecUser_Secuseremail_Z(struct.getSecuseremail_Z());
      setgxTv_SdtSecUser_Secuserestador_Z(struct.getSecuserestador_Z());
      setgxTv_SdtSecUser_Secuserid_N(struct.getSecuserid_N());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.StructSdtSecUser getStruct( )
   {
      com.projectthani.wwpbaseobjects.StructSdtSecUser struct = new com.projectthani.wwpbaseobjects.StructSdtSecUser ();
      struct.setSecuserid(getgxTv_SdtSecUser_Secuserid());
      struct.setSecusername(getgxTv_SdtSecUser_Secusername());
      struct.setSecuserpassword(getgxTv_SdtSecUser_Secuserpassword());
      struct.setSecuseremail(getgxTv_SdtSecUser_Secuseremail());
      struct.setSecuserestador(getgxTv_SdtSecUser_Secuserestador());
      struct.setMode(getgxTv_SdtSecUser_Mode());
      struct.setInitialized(getgxTv_SdtSecUser_Initialized());
      struct.setSecuserid_Z(getgxTv_SdtSecUser_Secuserid_Z());
      struct.setSecusername_Z(getgxTv_SdtSecUser_Secusername_Z());
      struct.setSecuserpassword_Z(getgxTv_SdtSecUser_Secuserpassword_Z());
      struct.setSecuseremail_Z(getgxTv_SdtSecUser_Secuseremail_Z());
      struct.setSecuserestador_Z(getgxTv_SdtSecUser_Secuserestador_Z());
      struct.setSecuserid_N(getgxTv_SdtSecUser_Secuserid_N());
      return struct ;
   }

   private byte gxTv_SdtSecUser_N ;
   private byte gxTv_SdtSecUser_Secuserid_N ;
   private short gxTv_SdtSecUser_Secuserid ;
   private short gxTv_SdtSecUser_Initialized ;
   private short gxTv_SdtSecUser_Secuserid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtSecUser_Secuserestador ;
   private String gxTv_SdtSecUser_Mode ;
   private String gxTv_SdtSecUser_Secuserestador_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtSecUser_Secusername ;
   private String gxTv_SdtSecUser_Secuserpassword ;
   private String gxTv_SdtSecUser_Secuseremail ;
   private String gxTv_SdtSecUser_Secusername_Z ;
   private String gxTv_SdtSecUser_Secuserpassword_Z ;
   private String gxTv_SdtSecUser_Secuseremail_Z ;
}

