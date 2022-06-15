package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSecUserRole extends GxSilentTrnSdt implements Cloneable, java.io.Serializable
{
   public SdtSecUserRole( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtSecUserRole.class));
   }

   public SdtSecUserRole( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "SdtSecUserRole");
      initialize( remoteHandle) ;
   }

   public SdtSecUserRole( int remoteHandle ,
                          StructSdtSecUserRole struct )
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

   public void Load( short AV6SecUserId ,
                     short AV4SecRoleId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV6SecUserId),Short.valueOf(AV4SecRoleId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"SecUserId", short.class}, new Object[]{"SecRoleId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\SecUserRole");
      metadata.set("BT", "SecUserRole");
      metadata.set("PK", "[ \"SecUserId\",\"SecRoleId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"SecRoleId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SecUserId\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtSecUserRole_Secuserid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleId") )
            {
               gxTv_SdtSecUserRole_Secroleid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserName") )
            {
               gxTv_SdtSecUserRole_Secusername = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleName") )
            {
               gxTv_SdtSecUserRole_Secrolename = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleDescription") )
            {
               gxTv_SdtSecUserRole_Secroledescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtSecUserRole_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtSecUserRole_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserId_Z") )
            {
               gxTv_SdtSecUserRole_Secuserid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleId_Z") )
            {
               gxTv_SdtSecUserRole_Secroleid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecUserName_Z") )
            {
               gxTv_SdtSecUserRole_Secusername_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleName_Z") )
            {
               gxTv_SdtSecUserRole_Secrolename_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleDescription_Z") )
            {
               gxTv_SdtSecUserRole_Secroledescription_Z = oReader.getValue() ;
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
         sName = "SecUserRole" ;
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
      oWriter.writeElement("SecUserId", GXutil.trim( GXutil.str( gxTv_SdtSecUserRole_Secuserid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecRoleId", GXutil.trim( GXutil.str( gxTv_SdtSecUserRole_Secroleid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecUserName", GXutil.rtrim( gxTv_SdtSecUserRole_Secusername));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecRoleName", GXutil.rtrim( gxTv_SdtSecUserRole_Secrolename));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      oWriter.writeElement("SecRoleDescription", GXutil.rtrim( gxTv_SdtSecUserRole_Secroledescription));
      if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
      {
         oWriter.writeAttribute("xmlns", "ProjectThani");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", GXutil.rtrim( gxTv_SdtSecUserRole_Mode));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtSecUserRole_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserId_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUserRole_Secuserid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecRoleId_Z", GXutil.trim( GXutil.str( gxTv_SdtSecUserRole_Secroleid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecUserName_Z", GXutil.rtrim( gxTv_SdtSecUserRole_Secusername_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecRoleName_Z", GXutil.rtrim( gxTv_SdtSecUserRole_Secrolename_Z));
         if ( GXutil.strcmp(sNameSpace, "ProjectThani") != 0 )
         {
            oWriter.writeAttribute("xmlns", "ProjectThani");
         }
         oWriter.writeElement("SecRoleDescription_Z", GXutil.rtrim( gxTv_SdtSecUserRole_Secroledescription_Z));
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
      AddObjectProperty("SecUserId", gxTv_SdtSecUserRole_Secuserid, false, includeNonInitialized);
      AddObjectProperty("SecRoleId", gxTv_SdtSecUserRole_Secroleid, false, includeNonInitialized);
      AddObjectProperty("SecUserName", gxTv_SdtSecUserRole_Secusername, false, includeNonInitialized);
      AddObjectProperty("SecRoleName", gxTv_SdtSecUserRole_Secrolename, false, includeNonInitialized);
      AddObjectProperty("SecRoleDescription", gxTv_SdtSecUserRole_Secroledescription, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtSecUserRole_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtSecUserRole_Initialized, false, includeNonInitialized);
         AddObjectProperty("SecUserId_Z", gxTv_SdtSecUserRole_Secuserid_Z, false, includeNonInitialized);
         AddObjectProperty("SecRoleId_Z", gxTv_SdtSecUserRole_Secroleid_Z, false, includeNonInitialized);
         AddObjectProperty("SecUserName_Z", gxTv_SdtSecUserRole_Secusername_Z, false, includeNonInitialized);
         AddObjectProperty("SecRoleName_Z", gxTv_SdtSecUserRole_Secrolename_Z, false, includeNonInitialized);
         AddObjectProperty("SecRoleDescription_Z", gxTv_SdtSecUserRole_Secroledescription_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.projectthani.wwpbaseobjects.SdtSecUserRole sdt )
   {
      if ( sdt.IsDirty("SecUserId") )
      {
         gxTv_SdtSecUserRole_N = (byte)(0) ;
         gxTv_SdtSecUserRole_Secuserid = sdt.getgxTv_SdtSecUserRole_Secuserid() ;
      }
      if ( sdt.IsDirty("SecRoleId") )
      {
         gxTv_SdtSecUserRole_N = (byte)(0) ;
         gxTv_SdtSecUserRole_Secroleid = sdt.getgxTv_SdtSecUserRole_Secroleid() ;
      }
      if ( sdt.IsDirty("SecUserName") )
      {
         gxTv_SdtSecUserRole_N = (byte)(0) ;
         gxTv_SdtSecUserRole_Secusername = sdt.getgxTv_SdtSecUserRole_Secusername() ;
      }
      if ( sdt.IsDirty("SecRoleName") )
      {
         gxTv_SdtSecUserRole_N = (byte)(0) ;
         gxTv_SdtSecUserRole_Secrolename = sdt.getgxTv_SdtSecUserRole_Secrolename() ;
      }
      if ( sdt.IsDirty("SecRoleDescription") )
      {
         gxTv_SdtSecUserRole_N = (byte)(0) ;
         gxTv_SdtSecUserRole_Secroledescription = sdt.getgxTv_SdtSecUserRole_Secroledescription() ;
      }
   }

   public short getgxTv_SdtSecUserRole_Secuserid( )
   {
      return gxTv_SdtSecUserRole_Secuserid ;
   }

   public void setgxTv_SdtSecUserRole_Secuserid( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      if ( gxTv_SdtSecUserRole_Secuserid != value )
      {
         gxTv_SdtSecUserRole_Mode = "INS" ;
         this.setgxTv_SdtSecUserRole_Secuserid_Z_SetNull( );
         this.setgxTv_SdtSecUserRole_Secroleid_Z_SetNull( );
         this.setgxTv_SdtSecUserRole_Secusername_Z_SetNull( );
         this.setgxTv_SdtSecUserRole_Secrolename_Z_SetNull( );
         this.setgxTv_SdtSecUserRole_Secroledescription_Z_SetNull( );
      }
      SetDirty("Secuserid");
      gxTv_SdtSecUserRole_Secuserid = value ;
   }

   public short getgxTv_SdtSecUserRole_Secroleid( )
   {
      return gxTv_SdtSecUserRole_Secroleid ;
   }

   public void setgxTv_SdtSecUserRole_Secroleid( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      if ( gxTv_SdtSecUserRole_Secroleid != value )
      {
         gxTv_SdtSecUserRole_Mode = "INS" ;
         this.setgxTv_SdtSecUserRole_Secuserid_Z_SetNull( );
         this.setgxTv_SdtSecUserRole_Secroleid_Z_SetNull( );
         this.setgxTv_SdtSecUserRole_Secusername_Z_SetNull( );
         this.setgxTv_SdtSecUserRole_Secrolename_Z_SetNull( );
         this.setgxTv_SdtSecUserRole_Secroledescription_Z_SetNull( );
      }
      SetDirty("Secroleid");
      gxTv_SdtSecUserRole_Secroleid = value ;
   }

   public String getgxTv_SdtSecUserRole_Secusername( )
   {
      return gxTv_SdtSecUserRole_Secusername ;
   }

   public void setgxTv_SdtSecUserRole_Secusername( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Secusername");
      gxTv_SdtSecUserRole_Secusername = value ;
   }

   public String getgxTv_SdtSecUserRole_Secrolename( )
   {
      return gxTv_SdtSecUserRole_Secrolename ;
   }

   public void setgxTv_SdtSecUserRole_Secrolename( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Secrolename");
      gxTv_SdtSecUserRole_Secrolename = value ;
   }

   public String getgxTv_SdtSecUserRole_Secroledescription( )
   {
      return gxTv_SdtSecUserRole_Secroledescription ;
   }

   public void setgxTv_SdtSecUserRole_Secroledescription( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Secroledescription");
      gxTv_SdtSecUserRole_Secroledescription = value ;
   }

   public String getgxTv_SdtSecUserRole_Mode( )
   {
      return gxTv_SdtSecUserRole_Mode ;
   }

   public void setgxTv_SdtSecUserRole_Mode( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtSecUserRole_Mode = value ;
   }

   public void setgxTv_SdtSecUserRole_Mode_SetNull( )
   {
      gxTv_SdtSecUserRole_Mode = "" ;
   }

   public boolean getgxTv_SdtSecUserRole_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecUserRole_Initialized( )
   {
      return gxTv_SdtSecUserRole_Initialized ;
   }

   public void setgxTv_SdtSecUserRole_Initialized( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtSecUserRole_Initialized = value ;
   }

   public void setgxTv_SdtSecUserRole_Initialized_SetNull( )
   {
      gxTv_SdtSecUserRole_Initialized = (short)(0) ;
   }

   public boolean getgxTv_SdtSecUserRole_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecUserRole_Secuserid_Z( )
   {
      return gxTv_SdtSecUserRole_Secuserid_Z ;
   }

   public void setgxTv_SdtSecUserRole_Secuserid_Z( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Secuserid_Z");
      gxTv_SdtSecUserRole_Secuserid_Z = value ;
   }

   public void setgxTv_SdtSecUserRole_Secuserid_Z_SetNull( )
   {
      gxTv_SdtSecUserRole_Secuserid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtSecUserRole_Secuserid_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecUserRole_Secroleid_Z( )
   {
      return gxTv_SdtSecUserRole_Secroleid_Z ;
   }

   public void setgxTv_SdtSecUserRole_Secroleid_Z( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Secroleid_Z");
      gxTv_SdtSecUserRole_Secroleid_Z = value ;
   }

   public void setgxTv_SdtSecUserRole_Secroleid_Z_SetNull( )
   {
      gxTv_SdtSecUserRole_Secroleid_Z = (short)(0) ;
   }

   public boolean getgxTv_SdtSecUserRole_Secroleid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUserRole_Secusername_Z( )
   {
      return gxTv_SdtSecUserRole_Secusername_Z ;
   }

   public void setgxTv_SdtSecUserRole_Secusername_Z( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Secusername_Z");
      gxTv_SdtSecUserRole_Secusername_Z = value ;
   }

   public void setgxTv_SdtSecUserRole_Secusername_Z_SetNull( )
   {
      gxTv_SdtSecUserRole_Secusername_Z = "" ;
   }

   public boolean getgxTv_SdtSecUserRole_Secusername_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUserRole_Secrolename_Z( )
   {
      return gxTv_SdtSecUserRole_Secrolename_Z ;
   }

   public void setgxTv_SdtSecUserRole_Secrolename_Z( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Secrolename_Z");
      gxTv_SdtSecUserRole_Secrolename_Z = value ;
   }

   public void setgxTv_SdtSecUserRole_Secrolename_Z_SetNull( )
   {
      gxTv_SdtSecUserRole_Secrolename_Z = "" ;
   }

   public boolean getgxTv_SdtSecUserRole_Secrolename_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecUserRole_Secroledescription_Z( )
   {
      return gxTv_SdtSecUserRole_Secroledescription_Z ;
   }

   public void setgxTv_SdtSecUserRole_Secroledescription_Z( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      SetDirty("Secroledescription_Z");
      gxTv_SdtSecUserRole_Secroledescription_Z = value ;
   }

   public void setgxTv_SdtSecUserRole_Secroledescription_Z_SetNull( )
   {
      gxTv_SdtSecUserRole_Secroledescription_Z = "" ;
   }

   public boolean getgxTv_SdtSecUserRole_Secroledescription_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.projectthani.wwpbaseobjects.secuserrole_bc obj;
      obj = new com.projectthani.wwpbaseobjects.secuserrole_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtSecUserRole_N = (byte)(1) ;
      gxTv_SdtSecUserRole_Secusername = "" ;
      gxTv_SdtSecUserRole_Secrolename = "" ;
      gxTv_SdtSecUserRole_Secroledescription = "" ;
      gxTv_SdtSecUserRole_Mode = "" ;
      gxTv_SdtSecUserRole_Secusername_Z = "" ;
      gxTv_SdtSecUserRole_Secrolename_Z = "" ;
      gxTv_SdtSecUserRole_Secroledescription_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSecUserRole_N ;
   }

   public com.projectthani.wwpbaseobjects.SdtSecUserRole Clone( )
   {
      com.projectthani.wwpbaseobjects.SdtSecUserRole sdt;
      com.projectthani.wwpbaseobjects.secuserrole_bc obj;
      sdt = (com.projectthani.wwpbaseobjects.SdtSecUserRole)(clone()) ;
      obj = (com.projectthani.wwpbaseobjects.secuserrole_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.projectthani.wwpbaseobjects.StructSdtSecUserRole struct )
   {
      setgxTv_SdtSecUserRole_Secuserid(struct.getSecuserid());
      setgxTv_SdtSecUserRole_Secroleid(struct.getSecroleid());
      setgxTv_SdtSecUserRole_Secusername(struct.getSecusername());
      setgxTv_SdtSecUserRole_Secrolename(struct.getSecrolename());
      setgxTv_SdtSecUserRole_Secroledescription(struct.getSecroledescription());
      setgxTv_SdtSecUserRole_Mode(struct.getMode());
      setgxTv_SdtSecUserRole_Initialized(struct.getInitialized());
      setgxTv_SdtSecUserRole_Secuserid_Z(struct.getSecuserid_Z());
      setgxTv_SdtSecUserRole_Secroleid_Z(struct.getSecroleid_Z());
      setgxTv_SdtSecUserRole_Secusername_Z(struct.getSecusername_Z());
      setgxTv_SdtSecUserRole_Secrolename_Z(struct.getSecrolename_Z());
      setgxTv_SdtSecUserRole_Secroledescription_Z(struct.getSecroledescription_Z());
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.StructSdtSecUserRole getStruct( )
   {
      com.projectthani.wwpbaseobjects.StructSdtSecUserRole struct = new com.projectthani.wwpbaseobjects.StructSdtSecUserRole ();
      struct.setSecuserid(getgxTv_SdtSecUserRole_Secuserid());
      struct.setSecroleid(getgxTv_SdtSecUserRole_Secroleid());
      struct.setSecusername(getgxTv_SdtSecUserRole_Secusername());
      struct.setSecrolename(getgxTv_SdtSecUserRole_Secrolename());
      struct.setSecroledescription(getgxTv_SdtSecUserRole_Secroledescription());
      struct.setMode(getgxTv_SdtSecUserRole_Mode());
      struct.setInitialized(getgxTv_SdtSecUserRole_Initialized());
      struct.setSecuserid_Z(getgxTv_SdtSecUserRole_Secuserid_Z());
      struct.setSecroleid_Z(getgxTv_SdtSecUserRole_Secroleid_Z());
      struct.setSecusername_Z(getgxTv_SdtSecUserRole_Secusername_Z());
      struct.setSecrolename_Z(getgxTv_SdtSecUserRole_Secrolename_Z());
      struct.setSecroledescription_Z(getgxTv_SdtSecUserRole_Secroledescription_Z());
      return struct ;
   }

   private byte gxTv_SdtSecUserRole_N ;
   private short gxTv_SdtSecUserRole_Secuserid ;
   private short gxTv_SdtSecUserRole_Secroleid ;
   private short gxTv_SdtSecUserRole_Initialized ;
   private short gxTv_SdtSecUserRole_Secuserid_Z ;
   private short gxTv_SdtSecUserRole_Secroleid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtSecUserRole_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtSecUserRole_Secusername ;
   private String gxTv_SdtSecUserRole_Secrolename ;
   private String gxTv_SdtSecUserRole_Secroledescription ;
   private String gxTv_SdtSecUserRole_Secusername_Z ;
   private String gxTv_SdtSecUserRole_Secrolename_Z ;
   private String gxTv_SdtSecUserRole_Secroledescription_Z ;
}

