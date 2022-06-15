package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paciente_bc extends GXWebPanel implements IGxSilentTrn
{
   public paciente_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paciente_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paciente_bc.class ));
   }

   public paciente_bc( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0916( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0916( ) ;
      standaloneModal( ) ;
      addRow0916( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e11092 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z20PacienteId = A20PacienteId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_090( )
   {
      beforeValidate0916( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0916( ) ;
         }
         else
         {
            checkExtendedTable0916( ) ;
            if ( AnyError == 0 )
            {
               zm0916( 14) ;
               zm0916( 15) ;
               zm0916( 16) ;
            }
            closeExtendedTableCursors0916( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12092( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      AV8IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Insert", GXv_boolean3) ;
         paciente_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Update", GXv_boolean3) ;
         paciente_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Delete", GXv_boolean3) ;
         paciente_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV27Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV27Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV28GXV1 = 1 ;
         while ( AV28GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV28GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PaisId") == 0 )
            {
               AV14Insert_PaisId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecUserId") == 0 )
            {
               AV12Insert_SecUserId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "UbigeoCode") == 0 )
            {
               AV15Insert_UbigeoCode = AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV28GXV1 = (int)(AV28GXV1+1) ;
         }
      }
   }

   public void e11092( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0916( int GX_JID )
   {
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         Z105PacienteNombres = A105PacienteNombres ;
         Z213PacienteFechaNacimiento = A213PacienteFechaNacimiento ;
         Z214PacienteTipoDocumento = A214PacienteTipoDocumento ;
         Z106PacienteNroDocumento = A106PacienteNroDocumento ;
         Z215PacienteDireccion = A215PacienteDireccion ;
         Z216PacienteSexo = A216PacienteSexo ;
         Z217PacienteCorreo = A217PacienteCorreo ;
         Z218PacienteTelefono = A218PacienteTelefono ;
         Z219PacienteEstado = A219PacienteEstado ;
         Z220PacienteEstatura = A220PacienteEstatura ;
         Z221PacientePeso = A221PacientePeso ;
         Z222PacienteNombreAnexo = A222PacienteNombreAnexo ;
         Z224PacienteEnterarse = A224PacienteEnterarse ;
         Z226PacienteFechaRegistro = A226PacienteFechaRegistro ;
         Z43PaisId = A43PaisId ;
         Z6SecUserId = A6SecUserId ;
         Z44UbigeoCode = A44UbigeoCode ;
         Z212PacienteNombreCompleto = A212PacienteNombreCompleto ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         Z184PaisDescripcion = A184PaisDescripcion ;
         Z212PacienteNombreCompleto = A212PacienteNombreCompleto ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         Z212PacienteNombreCompleto = A212PacienteNombreCompleto ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         Z186UbigeoDepartamento = A186UbigeoDepartamento ;
         Z187UbigeoProvincia = A187UbigeoProvincia ;
         Z188UbigeoDistrito = A188UbigeoDistrito ;
         Z212PacienteNombreCompleto = A212PacienteNombreCompleto ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( GX_JID == -13 )
      {
         Z20PacienteId = A20PacienteId ;
         Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         Z105PacienteNombres = A105PacienteNombres ;
         Z213PacienteFechaNacimiento = A213PacienteFechaNacimiento ;
         Z214PacienteTipoDocumento = A214PacienteTipoDocumento ;
         Z106PacienteNroDocumento = A106PacienteNroDocumento ;
         Z215PacienteDireccion = A215PacienteDireccion ;
         Z216PacienteSexo = A216PacienteSexo ;
         Z217PacienteCorreo = A217PacienteCorreo ;
         Z218PacienteTelefono = A218PacienteTelefono ;
         Z219PacienteEstado = A219PacienteEstado ;
         Z220PacienteEstatura = A220PacienteEstatura ;
         Z221PacientePeso = A221PacientePeso ;
         Z222PacienteNombreAnexo = A222PacienteNombreAnexo ;
         Z223PacienteAnexos = A223PacienteAnexos ;
         Z224PacienteEnterarse = A224PacienteEnterarse ;
         Z225PacienteEspecifique = A225PacienteEspecifique ;
         Z226PacienteFechaRegistro = A226PacienteFechaRegistro ;
         Z43PaisId = A43PaisId ;
         Z6SecUserId = A6SecUserId ;
         Z44UbigeoCode = A44UbigeoCode ;
         Z184PaisDescripcion = A184PaisDescripcion ;
         Z186UbigeoDepartamento = A186UbigeoDepartamento ;
         Z187UbigeoProvincia = A187UbigeoProvincia ;
         Z188UbigeoDistrito = A188UbigeoDistrito ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A226PacienteFechaRegistro) && ( Gx_BScreen == 0 ) )
      {
         A226PacienteFechaRegistro = GXutil.now( ) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0916( )
   {
      /* Using cursor BC00097 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A103PacienteApellidoPaterno = BC00097_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC00097_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC00097_A105PacienteNombres[0] ;
         A213PacienteFechaNacimiento = BC00097_A213PacienteFechaNacimiento[0] ;
         A214PacienteTipoDocumento = BC00097_A214PacienteTipoDocumento[0] ;
         A106PacienteNroDocumento = BC00097_A106PacienteNroDocumento[0] ;
         A215PacienteDireccion = BC00097_A215PacienteDireccion[0] ;
         A216PacienteSexo = BC00097_A216PacienteSexo[0] ;
         A217PacienteCorreo = BC00097_A217PacienteCorreo[0] ;
         A218PacienteTelefono = BC00097_A218PacienteTelefono[0] ;
         A184PaisDescripcion = BC00097_A184PaisDescripcion[0] ;
         A219PacienteEstado = BC00097_A219PacienteEstado[0] ;
         A220PacienteEstatura = BC00097_A220PacienteEstatura[0] ;
         A221PacientePeso = BC00097_A221PacientePeso[0] ;
         A222PacienteNombreAnexo = BC00097_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = BC00097_n222PacienteNombreAnexo[0] ;
         A223PacienteAnexos = BC00097_A223PacienteAnexos[0] ;
         n223PacienteAnexos = BC00097_n223PacienteAnexos[0] ;
         A224PacienteEnterarse = BC00097_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = BC00097_n224PacienteEnterarse[0] ;
         A225PacienteEspecifique = BC00097_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = BC00097_n225PacienteEspecifique[0] ;
         A226PacienteFechaRegistro = BC00097_A226PacienteFechaRegistro[0] ;
         A186UbigeoDepartamento = BC00097_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC00097_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC00097_A188UbigeoDistrito[0] ;
         A43PaisId = BC00097_A43PaisId[0] ;
         A6SecUserId = BC00097_A6SecUserId[0] ;
         n6SecUserId = BC00097_n6SecUserId[0] ;
         A44UbigeoCode = BC00097_A44UbigeoCode[0] ;
         n44UbigeoCode = BC00097_n44UbigeoCode[0] ;
         zm0916( -13) ;
      }
      pr_default.close(5);
      onLoadActions0916( ) ;
   }

   public void onLoadActions0916( )
   {
      AV27Pgmname = "Paciente_BC" ;
      A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
   }

   public void checkExtendedTable0916( )
   {
      nIsDirty_16 = (short)(0) ;
      standaloneModal( ) ;
      AV27Pgmname = "Paciente_BC" ;
      nIsDirty_16 = (short)(1) ;
      A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A213PacienteFechaNacimiento)) || (( GXutil.resetTime(A213PacienteFechaNacimiento).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A213PacienteFechaNacimiento), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Fecha Nacimiento fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A214PacienteTipoDocumento, "1") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "6") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "2") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "4") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "7") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "0") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Tipo Documento fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A216PacienteSexo, "M") == 0 ) || ( GXutil.strcmp(A216PacienteSexo, "F") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Sexo fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A217PacienteCorreo,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Paciente Correo no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC00098 */
      pr_default.execute(6, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Pais'.", "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
      }
      A184PaisDescripcion = BC00098_A184PaisDescripcion[0] ;
      pr_default.close(6);
      if ( ! ( ( GXutil.strcmp(A219PacienteEstado, "A") == 0 ) || ( GXutil.strcmp(A219PacienteEstado, "P") == 0 ) || ( GXutil.strcmp(A219PacienteEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC00099 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A6SecUserId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(7);
      /* Using cursor BC000910 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44UbigeoCode)==0) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
            AnyError = (short)(1) ;
         }
      }
      A186UbigeoDepartamento = BC000910_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = BC000910_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = BC000910_A188UbigeoDistrito[0] ;
      pr_default.close(8);
      nIsDirty_16 = (short)(1) ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      if ( ! ( ( GXutil.strcmp(A224PacienteEnterarse, "F") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "G") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "T") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "I") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "L") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "C") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "O") == 0 ) || (GXutil.strcmp("", A224PacienteEnterarse)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Enterarse fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A226PacienteFechaRegistro) || (( A226PacienteFechaRegistro.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A226PacienteFechaRegistro, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Fecha Registro fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0916( )
   {
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void getKey0916( )
   {
      /* Using cursor BC000911 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound16 = (short)(1) ;
      }
      else
      {
         RcdFound16 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000912 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         zm0916( 13) ;
         RcdFound16 = (short)(1) ;
         A20PacienteId = BC000912_A20PacienteId[0] ;
         A103PacienteApellidoPaterno = BC000912_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000912_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000912_A105PacienteNombres[0] ;
         A213PacienteFechaNacimiento = BC000912_A213PacienteFechaNacimiento[0] ;
         A214PacienteTipoDocumento = BC000912_A214PacienteTipoDocumento[0] ;
         A106PacienteNroDocumento = BC000912_A106PacienteNroDocumento[0] ;
         A215PacienteDireccion = BC000912_A215PacienteDireccion[0] ;
         A216PacienteSexo = BC000912_A216PacienteSexo[0] ;
         A217PacienteCorreo = BC000912_A217PacienteCorreo[0] ;
         A218PacienteTelefono = BC000912_A218PacienteTelefono[0] ;
         A219PacienteEstado = BC000912_A219PacienteEstado[0] ;
         A220PacienteEstatura = BC000912_A220PacienteEstatura[0] ;
         A221PacientePeso = BC000912_A221PacientePeso[0] ;
         A222PacienteNombreAnexo = BC000912_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = BC000912_n222PacienteNombreAnexo[0] ;
         A223PacienteAnexos = BC000912_A223PacienteAnexos[0] ;
         n223PacienteAnexos = BC000912_n223PacienteAnexos[0] ;
         A224PacienteEnterarse = BC000912_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = BC000912_n224PacienteEnterarse[0] ;
         A225PacienteEspecifique = BC000912_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = BC000912_n225PacienteEspecifique[0] ;
         A226PacienteFechaRegistro = BC000912_A226PacienteFechaRegistro[0] ;
         A43PaisId = BC000912_A43PaisId[0] ;
         A6SecUserId = BC000912_A6SecUserId[0] ;
         n6SecUserId = BC000912_n6SecUserId[0] ;
         A44UbigeoCode = BC000912_A44UbigeoCode[0] ;
         n44UbigeoCode = BC000912_n44UbigeoCode[0] ;
         Z20PacienteId = A20PacienteId ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0916( ) ;
         if ( AnyError == 1 )
         {
            RcdFound16 = (short)(0) ;
            initializeNonKey0916( ) ;
         }
         Gx_mode = sMode16 ;
      }
      else
      {
         RcdFound16 = (short)(0) ;
         initializeNonKey0916( ) ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode16 ;
      }
      pr_default.close(10);
   }

   public void getEqualNoModal( )
   {
      getKey0916( ) ;
      if ( RcdFound16 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_090( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0916( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000913 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(11) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paciente"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(11) == 101) || ( GXutil.strcmp(Z103PacienteApellidoPaterno, BC000913_A103PacienteApellidoPaterno[0]) != 0 ) || ( GXutil.strcmp(Z104PacienteApellidoMaterno, BC000913_A104PacienteApellidoMaterno[0]) != 0 ) || ( GXutil.strcmp(Z105PacienteNombres, BC000913_A105PacienteNombres[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z213PacienteFechaNacimiento), GXutil.resetTime(BC000913_A213PacienteFechaNacimiento[0])) ) || ( GXutil.strcmp(Z214PacienteTipoDocumento, BC000913_A214PacienteTipoDocumento[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z106PacienteNroDocumento, BC000913_A106PacienteNroDocumento[0]) != 0 ) || ( GXutil.strcmp(Z215PacienteDireccion, BC000913_A215PacienteDireccion[0]) != 0 ) || ( GXutil.strcmp(Z216PacienteSexo, BC000913_A216PacienteSexo[0]) != 0 ) || ( GXutil.strcmp(Z217PacienteCorreo, BC000913_A217PacienteCorreo[0]) != 0 ) || ( GXutil.strcmp(Z218PacienteTelefono, BC000913_A218PacienteTelefono[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z219PacienteEstado, BC000913_A219PacienteEstado[0]) != 0 ) || ( DecimalUtil.compareTo(Z220PacienteEstatura, BC000913_A220PacienteEstatura[0]) != 0 ) || ( DecimalUtil.compareTo(Z221PacientePeso, BC000913_A221PacientePeso[0]) != 0 ) || ( GXutil.strcmp(Z222PacienteNombreAnexo, BC000913_A222PacienteNombreAnexo[0]) != 0 ) || ( GXutil.strcmp(Z224PacienteEnterarse, BC000913_A224PacienteEnterarse[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(Z226PacienteFechaRegistro, BC000913_A226PacienteFechaRegistro[0]) ) || ( Z43PaisId != BC000913_A43PaisId[0] ) || ( Z6SecUserId != BC000913_A6SecUserId[0] ) || ( GXutil.strcmp(Z44UbigeoCode, BC000913_A44UbigeoCode[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paciente"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0916( )
   {
      beforeValidate0916( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0916( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0916( 0) ;
         checkOptimisticConcurrency0916( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0916( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0916( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000914 */
                  pr_default.execute(12, new Object[] {A103PacienteApellidoPaterno, A104PacienteApellidoMaterno, A105PacienteNombres, A213PacienteFechaNacimiento, A214PacienteTipoDocumento, A106PacienteNroDocumento, A215PacienteDireccion, A216PacienteSexo, A217PacienteCorreo, A218PacienteTelefono, A219PacienteEstado, A220PacienteEstatura, A221PacientePeso, Boolean.valueOf(n222PacienteNombreAnexo), A222PacienteNombreAnexo, Boolean.valueOf(n223PacienteAnexos), A223PacienteAnexos, Boolean.valueOf(n224PacienteEnterarse), A224PacienteEnterarse, Boolean.valueOf(n225PacienteEspecifique), A225PacienteEspecifique, A226PacienteFechaRegistro, Short.valueOf(A43PaisId), Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId), Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
                  A20PacienteId = BC000914_A20PacienteId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paciente");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0916( ) ;
         }
         endLevel0916( ) ;
      }
      closeExtendedTableCursors0916( ) ;
   }

   public void update0916( )
   {
      beforeValidate0916( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0916( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0916( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0916( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0916( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000915 */
                  pr_default.execute(13, new Object[] {A103PacienteApellidoPaterno, A104PacienteApellidoMaterno, A105PacienteNombres, A213PacienteFechaNacimiento, A214PacienteTipoDocumento, A106PacienteNroDocumento, A215PacienteDireccion, A216PacienteSexo, A217PacienteCorreo, A218PacienteTelefono, A219PacienteEstado, A220PacienteEstatura, A221PacientePeso, Boolean.valueOf(n222PacienteNombreAnexo), A222PacienteNombreAnexo, Boolean.valueOf(n224PacienteEnterarse), A224PacienteEnterarse, Boolean.valueOf(n225PacienteEspecifique), A225PacienteEspecifique, A226PacienteFechaRegistro, Short.valueOf(A43PaisId), Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId), Boolean.valueOf(n44UbigeoCode), A44UbigeoCode, Integer.valueOf(A20PacienteId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paciente");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paciente"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0916( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0916( ) ;
      }
      closeExtendedTableCursors0916( ) ;
   }

   public void deferredUpdate0916( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000916 */
         pr_default.execute(14, new Object[] {Boolean.valueOf(n223PacienteAnexos), A223PacienteAnexos, Integer.valueOf(A20PacienteId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Paciente");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0916( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0916( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0916( ) ;
         afterConfirm0916( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0916( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000917 */
               pr_default.execute(15, new Object[] {Integer.valueOf(A20PacienteId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paciente");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode16 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0916( ) ;
      Gx_mode = sMode16 ;
   }

   public void onDeleteControls0916( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV27Pgmname = "Paciente_BC" ;
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         /* Using cursor BC000918 */
         pr_default.execute(16, new Object[] {Short.valueOf(A43PaisId)});
         A184PaisDescripcion = BC000918_A184PaisDescripcion[0] ;
         pr_default.close(16);
         /* Using cursor BC000919 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
         A186UbigeoDepartamento = BC000919_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000919_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000919_A188UbigeoDistrito[0] ;
         pr_default.close(17);
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000920 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Rating Plataforma"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
         /* Using cursor BC000921 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(19) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sugerencias Mejoras Plataforma"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(19);
         /* Using cursor BC000922 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Comentario Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
         /* Using cursor BC000923 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Rating Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor BC000924 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Paciente Familiar"+" ("+"SGPaciente Hijo"+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor BC000925 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Paciente Familiar"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor BC000926 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Reclamo"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor BC000927 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
      }
   }

   public void endLevel0916( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0916( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0916( )
   {
      /* Scan By routine */
      /* Using cursor BC000928 */
      pr_default.execute(26, new Object[] {Integer.valueOf(A20PacienteId)});
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A20PacienteId = BC000928_A20PacienteId[0] ;
         A103PacienteApellidoPaterno = BC000928_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000928_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000928_A105PacienteNombres[0] ;
         A213PacienteFechaNacimiento = BC000928_A213PacienteFechaNacimiento[0] ;
         A214PacienteTipoDocumento = BC000928_A214PacienteTipoDocumento[0] ;
         A106PacienteNroDocumento = BC000928_A106PacienteNroDocumento[0] ;
         A215PacienteDireccion = BC000928_A215PacienteDireccion[0] ;
         A216PacienteSexo = BC000928_A216PacienteSexo[0] ;
         A217PacienteCorreo = BC000928_A217PacienteCorreo[0] ;
         A218PacienteTelefono = BC000928_A218PacienteTelefono[0] ;
         A184PaisDescripcion = BC000928_A184PaisDescripcion[0] ;
         A219PacienteEstado = BC000928_A219PacienteEstado[0] ;
         A220PacienteEstatura = BC000928_A220PacienteEstatura[0] ;
         A221PacientePeso = BC000928_A221PacientePeso[0] ;
         A222PacienteNombreAnexo = BC000928_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = BC000928_n222PacienteNombreAnexo[0] ;
         A223PacienteAnexos = BC000928_A223PacienteAnexos[0] ;
         n223PacienteAnexos = BC000928_n223PacienteAnexos[0] ;
         A224PacienteEnterarse = BC000928_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = BC000928_n224PacienteEnterarse[0] ;
         A225PacienteEspecifique = BC000928_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = BC000928_n225PacienteEspecifique[0] ;
         A226PacienteFechaRegistro = BC000928_A226PacienteFechaRegistro[0] ;
         A186UbigeoDepartamento = BC000928_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000928_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000928_A188UbigeoDistrito[0] ;
         A43PaisId = BC000928_A43PaisId[0] ;
         A6SecUserId = BC000928_A6SecUserId[0] ;
         n6SecUserId = BC000928_n6SecUserId[0] ;
         A44UbigeoCode = BC000928_A44UbigeoCode[0] ;
         n44UbigeoCode = BC000928_n44UbigeoCode[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0916( )
   {
      /* Scan next routine */
      pr_default.readNext(26);
      RcdFound16 = (short)(0) ;
      scanKeyLoad0916( ) ;
   }

   public void scanKeyLoad0916( )
   {
      sMode16 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A20PacienteId = BC000928_A20PacienteId[0] ;
         A103PacienteApellidoPaterno = BC000928_A103PacienteApellidoPaterno[0] ;
         A104PacienteApellidoMaterno = BC000928_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = BC000928_A105PacienteNombres[0] ;
         A213PacienteFechaNacimiento = BC000928_A213PacienteFechaNacimiento[0] ;
         A214PacienteTipoDocumento = BC000928_A214PacienteTipoDocumento[0] ;
         A106PacienteNroDocumento = BC000928_A106PacienteNroDocumento[0] ;
         A215PacienteDireccion = BC000928_A215PacienteDireccion[0] ;
         A216PacienteSexo = BC000928_A216PacienteSexo[0] ;
         A217PacienteCorreo = BC000928_A217PacienteCorreo[0] ;
         A218PacienteTelefono = BC000928_A218PacienteTelefono[0] ;
         A184PaisDescripcion = BC000928_A184PaisDescripcion[0] ;
         A219PacienteEstado = BC000928_A219PacienteEstado[0] ;
         A220PacienteEstatura = BC000928_A220PacienteEstatura[0] ;
         A221PacientePeso = BC000928_A221PacientePeso[0] ;
         A222PacienteNombreAnexo = BC000928_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = BC000928_n222PacienteNombreAnexo[0] ;
         A223PacienteAnexos = BC000928_A223PacienteAnexos[0] ;
         n223PacienteAnexos = BC000928_n223PacienteAnexos[0] ;
         A224PacienteEnterarse = BC000928_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = BC000928_n224PacienteEnterarse[0] ;
         A225PacienteEspecifique = BC000928_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = BC000928_n225PacienteEspecifique[0] ;
         A226PacienteFechaRegistro = BC000928_A226PacienteFechaRegistro[0] ;
         A186UbigeoDepartamento = BC000928_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000928_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000928_A188UbigeoDistrito[0] ;
         A43PaisId = BC000928_A43PaisId[0] ;
         A6SecUserId = BC000928_A6SecUserId[0] ;
         n6SecUserId = BC000928_n6SecUserId[0] ;
         A44UbigeoCode = BC000928_A44UbigeoCode[0] ;
         n44UbigeoCode = BC000928_n44UbigeoCode[0] ;
      }
      Gx_mode = sMode16 ;
   }

   public void scanKeyEnd0916( )
   {
      pr_default.close(26);
   }

   public void afterConfirm0916( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0916( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0916( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0916( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0916( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0916( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0916( )
   {
   }

   public void send_integrity_lvl_hashes0916( )
   {
   }

   public void addRow0916( )
   {
      VarsToRow16( bcPaciente) ;
   }

   public void readRow0916( )
   {
      RowToVars16( bcPaciente, 1) ;
   }

   public void initializeNonKey0916( )
   {
      A212PacienteNombreCompleto = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A214PacienteTipoDocumento = "" ;
      A106PacienteNroDocumento = "" ;
      A215PacienteDireccion = "" ;
      A216PacienteSexo = "" ;
      A217PacienteCorreo = "" ;
      A218PacienteTelefono = "" ;
      A43PaisId = (short)(0) ;
      A184PaisDescripcion = "" ;
      A219PacienteEstado = "" ;
      A6SecUserId = (short)(0) ;
      n6SecUserId = false ;
      A44UbigeoCode = "" ;
      n44UbigeoCode = false ;
      A185UbigeoNombre = "" ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      A221PacientePeso = DecimalUtil.ZERO ;
      A222PacienteNombreAnexo = "" ;
      n222PacienteNombreAnexo = false ;
      A223PacienteAnexos = "" ;
      n223PacienteAnexos = false ;
      A224PacienteEnterarse = "" ;
      n224PacienteEnterarse = false ;
      A225PacienteEspecifique = "" ;
      n225PacienteEspecifique = false ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      A226PacienteFechaRegistro = GXutil.now( ) ;
      Z103PacienteApellidoPaterno = "" ;
      Z104PacienteApellidoMaterno = "" ;
      Z105PacienteNombres = "" ;
      Z213PacienteFechaNacimiento = GXutil.nullDate() ;
      Z214PacienteTipoDocumento = "" ;
      Z106PacienteNroDocumento = "" ;
      Z215PacienteDireccion = "" ;
      Z216PacienteSexo = "" ;
      Z217PacienteCorreo = "" ;
      Z218PacienteTelefono = "" ;
      Z219PacienteEstado = "" ;
      Z220PacienteEstatura = DecimalUtil.ZERO ;
      Z221PacientePeso = DecimalUtil.ZERO ;
      Z222PacienteNombreAnexo = "" ;
      Z224PacienteEnterarse = "" ;
      Z226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      Z43PaisId = (short)(0) ;
      Z6SecUserId = (short)(0) ;
      Z44UbigeoCode = "" ;
   }

   public void initAll0916( )
   {
      A20PacienteId = 0 ;
      initializeNonKey0916( ) ;
   }

   public void standaloneModalInsert( )
   {
      A226PacienteFechaRegistro = i226PacienteFechaRegistro ;
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow16( com.projectthani.SdtPaciente obj16 )
   {
      obj16.setgxTv_SdtPaciente_Mode( Gx_mode );
      obj16.setgxTv_SdtPaciente_Pacientenombrecompleto( A212PacienteNombreCompleto );
      obj16.setgxTv_SdtPaciente_Pacienteapellidopaterno( A103PacienteApellidoPaterno );
      obj16.setgxTv_SdtPaciente_Pacienteapellidomaterno( A104PacienteApellidoMaterno );
      obj16.setgxTv_SdtPaciente_Pacientenombres( A105PacienteNombres );
      obj16.setgxTv_SdtPaciente_Pacientefechanacimiento( A213PacienteFechaNacimiento );
      obj16.setgxTv_SdtPaciente_Pacientetipodocumento( A214PacienteTipoDocumento );
      obj16.setgxTv_SdtPaciente_Pacientenrodocumento( A106PacienteNroDocumento );
      obj16.setgxTv_SdtPaciente_Pacientedireccion( A215PacienteDireccion );
      obj16.setgxTv_SdtPaciente_Pacientesexo( A216PacienteSexo );
      obj16.setgxTv_SdtPaciente_Pacientecorreo( A217PacienteCorreo );
      obj16.setgxTv_SdtPaciente_Pacientetelefono( A218PacienteTelefono );
      obj16.setgxTv_SdtPaciente_Paisid( A43PaisId );
      obj16.setgxTv_SdtPaciente_Paisdescripcion( A184PaisDescripcion );
      obj16.setgxTv_SdtPaciente_Pacienteestado( A219PacienteEstado );
      obj16.setgxTv_SdtPaciente_Secuserid( A6SecUserId );
      obj16.setgxTv_SdtPaciente_Ubigeocode( A44UbigeoCode );
      obj16.setgxTv_SdtPaciente_Ubigeonombre( A185UbigeoNombre );
      obj16.setgxTv_SdtPaciente_Pacienteestatura( A220PacienteEstatura );
      obj16.setgxTv_SdtPaciente_Pacientepeso( A221PacientePeso );
      obj16.setgxTv_SdtPaciente_Pacientenombreanexo( A222PacienteNombreAnexo );
      obj16.setgxTv_SdtPaciente_Pacienteanexos( A223PacienteAnexos );
      obj16.setgxTv_SdtPaciente_Pacienteenterarse( A224PacienteEnterarse );
      obj16.setgxTv_SdtPaciente_Pacienteespecifique( A225PacienteEspecifique );
      obj16.setgxTv_SdtPaciente_Pacientefecharegistro( A226PacienteFechaRegistro );
      obj16.setgxTv_SdtPaciente_Pacienteid( A20PacienteId );
      obj16.setgxTv_SdtPaciente_Pacienteid_Z( Z20PacienteId );
      obj16.setgxTv_SdtPaciente_Pacienteapellidopaterno_Z( Z103PacienteApellidoPaterno );
      obj16.setgxTv_SdtPaciente_Pacienteapellidomaterno_Z( Z104PacienteApellidoMaterno );
      obj16.setgxTv_SdtPaciente_Pacientenombres_Z( Z105PacienteNombres );
      obj16.setgxTv_SdtPaciente_Pacientenombrecompleto_Z( Z212PacienteNombreCompleto );
      obj16.setgxTv_SdtPaciente_Pacientefechanacimiento_Z( Z213PacienteFechaNacimiento );
      obj16.setgxTv_SdtPaciente_Pacientetipodocumento_Z( Z214PacienteTipoDocumento );
      obj16.setgxTv_SdtPaciente_Pacientenrodocumento_Z( Z106PacienteNroDocumento );
      obj16.setgxTv_SdtPaciente_Pacientedireccion_Z( Z215PacienteDireccion );
      obj16.setgxTv_SdtPaciente_Pacientesexo_Z( Z216PacienteSexo );
      obj16.setgxTv_SdtPaciente_Pacientecorreo_Z( Z217PacienteCorreo );
      obj16.setgxTv_SdtPaciente_Pacientetelefono_Z( Z218PacienteTelefono );
      obj16.setgxTv_SdtPaciente_Paisid_Z( Z43PaisId );
      obj16.setgxTv_SdtPaciente_Paisdescripcion_Z( Z184PaisDescripcion );
      obj16.setgxTv_SdtPaciente_Pacienteestado_Z( Z219PacienteEstado );
      obj16.setgxTv_SdtPaciente_Secuserid_Z( Z6SecUserId );
      obj16.setgxTv_SdtPaciente_Ubigeocode_Z( Z44UbigeoCode );
      obj16.setgxTv_SdtPaciente_Ubigeonombre_Z( Z185UbigeoNombre );
      obj16.setgxTv_SdtPaciente_Pacienteestatura_Z( Z220PacienteEstatura );
      obj16.setgxTv_SdtPaciente_Pacientepeso_Z( Z221PacientePeso );
      obj16.setgxTv_SdtPaciente_Pacientenombreanexo_Z( Z222PacienteNombreAnexo );
      obj16.setgxTv_SdtPaciente_Pacienteenterarse_Z( Z224PacienteEnterarse );
      obj16.setgxTv_SdtPaciente_Pacientefecharegistro_Z( Z226PacienteFechaRegistro );
      obj16.setgxTv_SdtPaciente_Secuserid_N( (byte)((byte)((n6SecUserId)?1:0)) );
      obj16.setgxTv_SdtPaciente_Ubigeocode_N( (byte)((byte)((n44UbigeoCode)?1:0)) );
      obj16.setgxTv_SdtPaciente_Pacientenombreanexo_N( (byte)((byte)((n222PacienteNombreAnexo)?1:0)) );
      obj16.setgxTv_SdtPaciente_Pacienteanexos_N( (byte)((byte)((n223PacienteAnexos)?1:0)) );
      obj16.setgxTv_SdtPaciente_Pacienteenterarse_N( (byte)((byte)((n224PacienteEnterarse)?1:0)) );
      obj16.setgxTv_SdtPaciente_Pacienteespecifique_N( (byte)((byte)((n225PacienteEspecifique)?1:0)) );
      obj16.setgxTv_SdtPaciente_Mode( Gx_mode );
   }

   public void KeyVarsToRow16( com.projectthani.SdtPaciente obj16 )
   {
      obj16.setgxTv_SdtPaciente_Pacienteid( A20PacienteId );
   }

   public void RowToVars16( com.projectthani.SdtPaciente obj16 ,
                            int forceLoad )
   {
      Gx_mode = obj16.getgxTv_SdtPaciente_Mode() ;
      A212PacienteNombreCompleto = obj16.getgxTv_SdtPaciente_Pacientenombrecompleto() ;
      A103PacienteApellidoPaterno = obj16.getgxTv_SdtPaciente_Pacienteapellidopaterno() ;
      A104PacienteApellidoMaterno = obj16.getgxTv_SdtPaciente_Pacienteapellidomaterno() ;
      A105PacienteNombres = obj16.getgxTv_SdtPaciente_Pacientenombres() ;
      A213PacienteFechaNacimiento = obj16.getgxTv_SdtPaciente_Pacientefechanacimiento() ;
      A214PacienteTipoDocumento = obj16.getgxTv_SdtPaciente_Pacientetipodocumento() ;
      A106PacienteNroDocumento = obj16.getgxTv_SdtPaciente_Pacientenrodocumento() ;
      A215PacienteDireccion = obj16.getgxTv_SdtPaciente_Pacientedireccion() ;
      A216PacienteSexo = obj16.getgxTv_SdtPaciente_Pacientesexo() ;
      A217PacienteCorreo = obj16.getgxTv_SdtPaciente_Pacientecorreo() ;
      A218PacienteTelefono = obj16.getgxTv_SdtPaciente_Pacientetelefono() ;
      A43PaisId = obj16.getgxTv_SdtPaciente_Paisid() ;
      A184PaisDescripcion = obj16.getgxTv_SdtPaciente_Paisdescripcion() ;
      A219PacienteEstado = obj16.getgxTv_SdtPaciente_Pacienteestado() ;
      A6SecUserId = obj16.getgxTv_SdtPaciente_Secuserid() ;
      n6SecUserId = false ;
      A44UbigeoCode = obj16.getgxTv_SdtPaciente_Ubigeocode() ;
      n44UbigeoCode = false ;
      A185UbigeoNombre = obj16.getgxTv_SdtPaciente_Ubigeonombre() ;
      A220PacienteEstatura = obj16.getgxTv_SdtPaciente_Pacienteestatura() ;
      A221PacientePeso = obj16.getgxTv_SdtPaciente_Pacientepeso() ;
      A222PacienteNombreAnexo = obj16.getgxTv_SdtPaciente_Pacientenombreanexo() ;
      n222PacienteNombreAnexo = false ;
      A223PacienteAnexos = obj16.getgxTv_SdtPaciente_Pacienteanexos() ;
      n223PacienteAnexos = false ;
      A224PacienteEnterarse = obj16.getgxTv_SdtPaciente_Pacienteenterarse() ;
      n224PacienteEnterarse = false ;
      A225PacienteEspecifique = obj16.getgxTv_SdtPaciente_Pacienteespecifique() ;
      n225PacienteEspecifique = false ;
      A226PacienteFechaRegistro = obj16.getgxTv_SdtPaciente_Pacientefecharegistro() ;
      A20PacienteId = obj16.getgxTv_SdtPaciente_Pacienteid() ;
      Z20PacienteId = obj16.getgxTv_SdtPaciente_Pacienteid_Z() ;
      Z103PacienteApellidoPaterno = obj16.getgxTv_SdtPaciente_Pacienteapellidopaterno_Z() ;
      Z104PacienteApellidoMaterno = obj16.getgxTv_SdtPaciente_Pacienteapellidomaterno_Z() ;
      Z105PacienteNombres = obj16.getgxTv_SdtPaciente_Pacientenombres_Z() ;
      Z212PacienteNombreCompleto = obj16.getgxTv_SdtPaciente_Pacientenombrecompleto_Z() ;
      Z213PacienteFechaNacimiento = obj16.getgxTv_SdtPaciente_Pacientefechanacimiento_Z() ;
      Z214PacienteTipoDocumento = obj16.getgxTv_SdtPaciente_Pacientetipodocumento_Z() ;
      Z106PacienteNroDocumento = obj16.getgxTv_SdtPaciente_Pacientenrodocumento_Z() ;
      Z215PacienteDireccion = obj16.getgxTv_SdtPaciente_Pacientedireccion_Z() ;
      Z216PacienteSexo = obj16.getgxTv_SdtPaciente_Pacientesexo_Z() ;
      Z217PacienteCorreo = obj16.getgxTv_SdtPaciente_Pacientecorreo_Z() ;
      Z218PacienteTelefono = obj16.getgxTv_SdtPaciente_Pacientetelefono_Z() ;
      Z43PaisId = obj16.getgxTv_SdtPaciente_Paisid_Z() ;
      Z184PaisDescripcion = obj16.getgxTv_SdtPaciente_Paisdescripcion_Z() ;
      Z219PacienteEstado = obj16.getgxTv_SdtPaciente_Pacienteestado_Z() ;
      Z6SecUserId = obj16.getgxTv_SdtPaciente_Secuserid_Z() ;
      Z44UbigeoCode = obj16.getgxTv_SdtPaciente_Ubigeocode_Z() ;
      Z185UbigeoNombre = obj16.getgxTv_SdtPaciente_Ubigeonombre_Z() ;
      Z220PacienteEstatura = obj16.getgxTv_SdtPaciente_Pacienteestatura_Z() ;
      Z221PacientePeso = obj16.getgxTv_SdtPaciente_Pacientepeso_Z() ;
      Z222PacienteNombreAnexo = obj16.getgxTv_SdtPaciente_Pacientenombreanexo_Z() ;
      Z224PacienteEnterarse = obj16.getgxTv_SdtPaciente_Pacienteenterarse_Z() ;
      Z226PacienteFechaRegistro = obj16.getgxTv_SdtPaciente_Pacientefecharegistro_Z() ;
      n6SecUserId = (boolean)((obj16.getgxTv_SdtPaciente_Secuserid_N()==0)?false:true) ;
      n44UbigeoCode = (boolean)((obj16.getgxTv_SdtPaciente_Ubigeocode_N()==0)?false:true) ;
      n222PacienteNombreAnexo = (boolean)((obj16.getgxTv_SdtPaciente_Pacientenombreanexo_N()==0)?false:true) ;
      n223PacienteAnexos = (boolean)((obj16.getgxTv_SdtPaciente_Pacienteanexos_N()==0)?false:true) ;
      n224PacienteEnterarse = (boolean)((obj16.getgxTv_SdtPaciente_Pacienteenterarse_N()==0)?false:true) ;
      n225PacienteEspecifique = (boolean)((obj16.getgxTv_SdtPaciente_Pacienteespecifique_N()==0)?false:true) ;
      Gx_mode = obj16.getgxTv_SdtPaciente_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A20PacienteId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0916( ) ;
      scanKeyStart0916( ) ;
      if ( RcdFound16 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z20PacienteId = A20PacienteId ;
      }
      zm0916( -13) ;
      onLoadActions0916( ) ;
      addRow0916( ) ;
      scanKeyEnd0916( ) ;
      if ( RcdFound16 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars16( bcPaciente, 0) ;
      scanKeyStart0916( ) ;
      if ( RcdFound16 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z20PacienteId = A20PacienteId ;
      }
      zm0916( -13) ;
      onLoadActions0916( ) ;
      addRow0916( ) ;
      scanKeyEnd0916( ) ;
      if ( RcdFound16 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0916( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0916( ) ;
      }
      else
      {
         if ( RcdFound16 == 1 )
         {
            if ( A20PacienteId != Z20PacienteId )
            {
               A20PacienteId = Z20PacienteId ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0916( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A20PacienteId != Z20PacienteId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0916( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0916( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars16( bcPaciente, 1) ;
      saveImpl( ) ;
      VarsToRow16( bcPaciente) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars16( bcPaciente, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0916( ) ;
      afterTrn( ) ;
      VarsToRow16( bcPaciente) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         com.projectthani.SdtPaciente auxBC = new com.projectthani.SdtPaciente( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A20PacienteId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcPaciente);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars16( bcPaciente, 1) ;
      updateImpl( ) ;
      VarsToRow16( bcPaciente) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars16( bcPaciente, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0916( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow16( bcPaciente) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars16( bcPaciente, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0916( ) ;
      if ( RcdFound16 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A20PacienteId != Z20PacienteId )
         {
            A20PacienteId = Z20PacienteId ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A20PacienteId != Z20PacienteId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      pr_default.close(1);
      pr_default.close(0);
      pr_default.close(16);
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(17);
      pr_default.close(4);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "paciente_bc");
      VarsToRow16( bcPaciente) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcPaciente.getgxTv_SdtPaciente_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcPaciente.setgxTv_SdtPaciente_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtPaciente sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcPaciente )
      {
         bcPaciente = sdt ;
         if ( GXutil.strcmp(bcPaciente.getgxTv_SdtPaciente_Mode(), "") == 0 )
         {
            bcPaciente.setgxTv_SdtPaciente_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow16( bcPaciente) ;
         }
         else
         {
            RowToVars16( bcPaciente, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcPaciente.getgxTv_SdtPaciente_Mode(), "") == 0 )
         {
            bcPaciente.setgxTv_SdtPaciente_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars16( bcPaciente, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtPaciente getPaciente_BC( )
   {
      return bcPaciente ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV27Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV15Insert_UbigeoCode = "" ;
      Z103PacienteApellidoPaterno = "" ;
      A103PacienteApellidoPaterno = "" ;
      Z104PacienteApellidoMaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      Z105PacienteNombres = "" ;
      A105PacienteNombres = "" ;
      Z213PacienteFechaNacimiento = GXutil.nullDate() ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      Z214PacienteTipoDocumento = "" ;
      A214PacienteTipoDocumento = "" ;
      Z106PacienteNroDocumento = "" ;
      A106PacienteNroDocumento = "" ;
      Z215PacienteDireccion = "" ;
      A215PacienteDireccion = "" ;
      Z216PacienteSexo = "" ;
      A216PacienteSexo = "" ;
      Z217PacienteCorreo = "" ;
      A217PacienteCorreo = "" ;
      Z218PacienteTelefono = "" ;
      A218PacienteTelefono = "" ;
      Z219PacienteEstado = "" ;
      A219PacienteEstado = "" ;
      Z220PacienteEstatura = DecimalUtil.ZERO ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      Z221PacientePeso = DecimalUtil.ZERO ;
      A221PacientePeso = DecimalUtil.ZERO ;
      Z222PacienteNombreAnexo = "" ;
      A222PacienteNombreAnexo = "" ;
      Z224PacienteEnterarse = "" ;
      A224PacienteEnterarse = "" ;
      Z226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      A226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      Z44UbigeoCode = "" ;
      A44UbigeoCode = "" ;
      Z212PacienteNombreCompleto = "" ;
      A212PacienteNombreCompleto = "" ;
      Z185UbigeoNombre = "" ;
      A185UbigeoNombre = "" ;
      Z184PaisDescripcion = "" ;
      A184PaisDescripcion = "" ;
      Z186UbigeoDepartamento = "" ;
      A186UbigeoDepartamento = "" ;
      Z187UbigeoProvincia = "" ;
      A187UbigeoProvincia = "" ;
      Z188UbigeoDistrito = "" ;
      A188UbigeoDistrito = "" ;
      Z223PacienteAnexos = "" ;
      A223PacienteAnexos = "" ;
      Z225PacienteEspecifique = "" ;
      A225PacienteEspecifique = "" ;
      BC00097_A20PacienteId = new int[1] ;
      BC00097_A103PacienteApellidoPaterno = new String[] {""} ;
      BC00097_A104PacienteApellidoMaterno = new String[] {""} ;
      BC00097_A105PacienteNombres = new String[] {""} ;
      BC00097_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      BC00097_A214PacienteTipoDocumento = new String[] {""} ;
      BC00097_A106PacienteNroDocumento = new String[] {""} ;
      BC00097_A215PacienteDireccion = new String[] {""} ;
      BC00097_A216PacienteSexo = new String[] {""} ;
      BC00097_A217PacienteCorreo = new String[] {""} ;
      BC00097_A218PacienteTelefono = new String[] {""} ;
      BC00097_A184PaisDescripcion = new String[] {""} ;
      BC00097_A219PacienteEstado = new String[] {""} ;
      BC00097_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00097_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00097_A222PacienteNombreAnexo = new String[] {""} ;
      BC00097_n222PacienteNombreAnexo = new boolean[] {false} ;
      BC00097_A223PacienteAnexos = new String[] {""} ;
      BC00097_n223PacienteAnexos = new boolean[] {false} ;
      BC00097_A224PacienteEnterarse = new String[] {""} ;
      BC00097_n224PacienteEnterarse = new boolean[] {false} ;
      BC00097_A225PacienteEspecifique = new String[] {""} ;
      BC00097_n225PacienteEspecifique = new boolean[] {false} ;
      BC00097_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC00097_A186UbigeoDepartamento = new String[] {""} ;
      BC00097_A187UbigeoProvincia = new String[] {""} ;
      BC00097_A188UbigeoDistrito = new String[] {""} ;
      BC00097_A43PaisId = new short[1] ;
      BC00097_A6SecUserId = new short[1] ;
      BC00097_n6SecUserId = new boolean[] {false} ;
      BC00097_A44UbigeoCode = new String[] {""} ;
      BC00097_n44UbigeoCode = new boolean[] {false} ;
      BC00098_A184PaisDescripcion = new String[] {""} ;
      BC00099_A6SecUserId = new short[1] ;
      BC00099_n6SecUserId = new boolean[] {false} ;
      BC000910_A186UbigeoDepartamento = new String[] {""} ;
      BC000910_A187UbigeoProvincia = new String[] {""} ;
      BC000910_A188UbigeoDistrito = new String[] {""} ;
      BC000911_A20PacienteId = new int[1] ;
      BC000912_A20PacienteId = new int[1] ;
      BC000912_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000912_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000912_A105PacienteNombres = new String[] {""} ;
      BC000912_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      BC000912_A214PacienteTipoDocumento = new String[] {""} ;
      BC000912_A106PacienteNroDocumento = new String[] {""} ;
      BC000912_A215PacienteDireccion = new String[] {""} ;
      BC000912_A216PacienteSexo = new String[] {""} ;
      BC000912_A217PacienteCorreo = new String[] {""} ;
      BC000912_A218PacienteTelefono = new String[] {""} ;
      BC000912_A219PacienteEstado = new String[] {""} ;
      BC000912_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000912_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000912_A222PacienteNombreAnexo = new String[] {""} ;
      BC000912_n222PacienteNombreAnexo = new boolean[] {false} ;
      BC000912_A223PacienteAnexos = new String[] {""} ;
      BC000912_n223PacienteAnexos = new boolean[] {false} ;
      BC000912_A224PacienteEnterarse = new String[] {""} ;
      BC000912_n224PacienteEnterarse = new boolean[] {false} ;
      BC000912_A225PacienteEspecifique = new String[] {""} ;
      BC000912_n225PacienteEspecifique = new boolean[] {false} ;
      BC000912_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC000912_A43PaisId = new short[1] ;
      BC000912_A6SecUserId = new short[1] ;
      BC000912_n6SecUserId = new boolean[] {false} ;
      BC000912_A44UbigeoCode = new String[] {""} ;
      BC000912_n44UbigeoCode = new boolean[] {false} ;
      sMode16 = "" ;
      BC000913_A20PacienteId = new int[1] ;
      BC000913_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000913_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000913_A105PacienteNombres = new String[] {""} ;
      BC000913_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      BC000913_A214PacienteTipoDocumento = new String[] {""} ;
      BC000913_A106PacienteNroDocumento = new String[] {""} ;
      BC000913_A215PacienteDireccion = new String[] {""} ;
      BC000913_A216PacienteSexo = new String[] {""} ;
      BC000913_A217PacienteCorreo = new String[] {""} ;
      BC000913_A218PacienteTelefono = new String[] {""} ;
      BC000913_A219PacienteEstado = new String[] {""} ;
      BC000913_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000913_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000913_A222PacienteNombreAnexo = new String[] {""} ;
      BC000913_n222PacienteNombreAnexo = new boolean[] {false} ;
      BC000913_A223PacienteAnexos = new String[] {""} ;
      BC000913_n223PacienteAnexos = new boolean[] {false} ;
      BC000913_A224PacienteEnterarse = new String[] {""} ;
      BC000913_n224PacienteEnterarse = new boolean[] {false} ;
      BC000913_A225PacienteEspecifique = new String[] {""} ;
      BC000913_n225PacienteEspecifique = new boolean[] {false} ;
      BC000913_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC000913_A43PaisId = new short[1] ;
      BC000913_A6SecUserId = new short[1] ;
      BC000913_n6SecUserId = new boolean[] {false} ;
      BC000913_A44UbigeoCode = new String[] {""} ;
      BC000913_n44UbigeoCode = new boolean[] {false} ;
      BC000914_A20PacienteId = new int[1] ;
      BC000918_A184PaisDescripcion = new String[] {""} ;
      BC000919_A186UbigeoDepartamento = new String[] {""} ;
      BC000919_A187UbigeoProvincia = new String[] {""} ;
      BC000919_A188UbigeoDistrito = new String[] {""} ;
      BC000920_A398RatingPlataformaId = new int[1] ;
      BC000921_A397SugerenciasMejorasPlataformaId = new int[1] ;
      BC000922_A63ComentarioProfesionalId = new int[1] ;
      BC000923_A60RatingProfesionalId = new int[1] ;
      BC000924_A45PacienteFamiliarId = new int[1] ;
      BC000925_A45PacienteFamiliarId = new int[1] ;
      BC000926_A51ReclamoId = new int[1] ;
      BC000927_A19CitaId = new int[1] ;
      BC000928_A20PacienteId = new int[1] ;
      BC000928_A103PacienteApellidoPaterno = new String[] {""} ;
      BC000928_A104PacienteApellidoMaterno = new String[] {""} ;
      BC000928_A105PacienteNombres = new String[] {""} ;
      BC000928_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      BC000928_A214PacienteTipoDocumento = new String[] {""} ;
      BC000928_A106PacienteNroDocumento = new String[] {""} ;
      BC000928_A215PacienteDireccion = new String[] {""} ;
      BC000928_A216PacienteSexo = new String[] {""} ;
      BC000928_A217PacienteCorreo = new String[] {""} ;
      BC000928_A218PacienteTelefono = new String[] {""} ;
      BC000928_A184PaisDescripcion = new String[] {""} ;
      BC000928_A219PacienteEstado = new String[] {""} ;
      BC000928_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000928_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000928_A222PacienteNombreAnexo = new String[] {""} ;
      BC000928_n222PacienteNombreAnexo = new boolean[] {false} ;
      BC000928_A223PacienteAnexos = new String[] {""} ;
      BC000928_n223PacienteAnexos = new boolean[] {false} ;
      BC000928_A224PacienteEnterarse = new String[] {""} ;
      BC000928_n224PacienteEnterarse = new boolean[] {false} ;
      BC000928_A225PacienteEspecifique = new String[] {""} ;
      BC000928_n225PacienteEspecifique = new boolean[] {false} ;
      BC000928_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC000928_A186UbigeoDepartamento = new String[] {""} ;
      BC000928_A187UbigeoProvincia = new String[] {""} ;
      BC000928_A188UbigeoDistrito = new String[] {""} ;
      BC000928_A43PaisId = new short[1] ;
      BC000928_A6SecUserId = new short[1] ;
      BC000928_n6SecUserId = new boolean[] {false} ;
      BC000928_A44UbigeoCode = new String[] {""} ;
      BC000928_n44UbigeoCode = new boolean[] {false} ;
      i226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.paciente_bc__default(),
         new Object[] {
             new Object[] {
            BC00092_A20PacienteId, BC00092_A103PacienteApellidoPaterno, BC00092_A104PacienteApellidoMaterno, BC00092_A105PacienteNombres, BC00092_A213PacienteFechaNacimiento, BC00092_A214PacienteTipoDocumento, BC00092_A106PacienteNroDocumento, BC00092_A215PacienteDireccion, BC00092_A216PacienteSexo, BC00092_A217PacienteCorreo,
            BC00092_A218PacienteTelefono, BC00092_A219PacienteEstado, BC00092_A220PacienteEstatura, BC00092_A221PacientePeso, BC00092_A222PacienteNombreAnexo, BC00092_n222PacienteNombreAnexo, BC00092_A223PacienteAnexos, BC00092_n223PacienteAnexos, BC00092_A224PacienteEnterarse, BC00092_n224PacienteEnterarse,
            BC00092_A225PacienteEspecifique, BC00092_n225PacienteEspecifique, BC00092_A226PacienteFechaRegistro, BC00092_A43PaisId, BC00092_A6SecUserId, BC00092_n6SecUserId, BC00092_A44UbigeoCode, BC00092_n44UbigeoCode
            }
            , new Object[] {
            BC00093_A20PacienteId, BC00093_A103PacienteApellidoPaterno, BC00093_A104PacienteApellidoMaterno, BC00093_A105PacienteNombres, BC00093_A213PacienteFechaNacimiento, BC00093_A214PacienteTipoDocumento, BC00093_A106PacienteNroDocumento, BC00093_A215PacienteDireccion, BC00093_A216PacienteSexo, BC00093_A217PacienteCorreo,
            BC00093_A218PacienteTelefono, BC00093_A219PacienteEstado, BC00093_A220PacienteEstatura, BC00093_A221PacientePeso, BC00093_A222PacienteNombreAnexo, BC00093_n222PacienteNombreAnexo, BC00093_A223PacienteAnexos, BC00093_n223PacienteAnexos, BC00093_A224PacienteEnterarse, BC00093_n224PacienteEnterarse,
            BC00093_A225PacienteEspecifique, BC00093_n225PacienteEspecifique, BC00093_A226PacienteFechaRegistro, BC00093_A43PaisId, BC00093_A6SecUserId, BC00093_n6SecUserId, BC00093_A44UbigeoCode, BC00093_n44UbigeoCode
            }
            , new Object[] {
            BC00094_A184PaisDescripcion
            }
            , new Object[] {
            BC00095_A6SecUserId
            }
            , new Object[] {
            BC00096_A186UbigeoDepartamento, BC00096_A187UbigeoProvincia, BC00096_A188UbigeoDistrito
            }
            , new Object[] {
            BC00097_A20PacienteId, BC00097_A103PacienteApellidoPaterno, BC00097_A104PacienteApellidoMaterno, BC00097_A105PacienteNombres, BC00097_A213PacienteFechaNacimiento, BC00097_A214PacienteTipoDocumento, BC00097_A106PacienteNroDocumento, BC00097_A215PacienteDireccion, BC00097_A216PacienteSexo, BC00097_A217PacienteCorreo,
            BC00097_A218PacienteTelefono, BC00097_A184PaisDescripcion, BC00097_A219PacienteEstado, BC00097_A220PacienteEstatura, BC00097_A221PacientePeso, BC00097_A222PacienteNombreAnexo, BC00097_n222PacienteNombreAnexo, BC00097_A223PacienteAnexos, BC00097_n223PacienteAnexos, BC00097_A224PacienteEnterarse,
            BC00097_n224PacienteEnterarse, BC00097_A225PacienteEspecifique, BC00097_n225PacienteEspecifique, BC00097_A226PacienteFechaRegistro, BC00097_A186UbigeoDepartamento, BC00097_A187UbigeoProvincia, BC00097_A188UbigeoDistrito, BC00097_A43PaisId, BC00097_A6SecUserId, BC00097_n6SecUserId,
            BC00097_A44UbigeoCode, BC00097_n44UbigeoCode
            }
            , new Object[] {
            BC00098_A184PaisDescripcion
            }
            , new Object[] {
            BC00099_A6SecUserId
            }
            , new Object[] {
            BC000910_A186UbigeoDepartamento, BC000910_A187UbigeoProvincia, BC000910_A188UbigeoDistrito
            }
            , new Object[] {
            BC000911_A20PacienteId
            }
            , new Object[] {
            BC000912_A20PacienteId, BC000912_A103PacienteApellidoPaterno, BC000912_A104PacienteApellidoMaterno, BC000912_A105PacienteNombres, BC000912_A213PacienteFechaNacimiento, BC000912_A214PacienteTipoDocumento, BC000912_A106PacienteNroDocumento, BC000912_A215PacienteDireccion, BC000912_A216PacienteSexo, BC000912_A217PacienteCorreo,
            BC000912_A218PacienteTelefono, BC000912_A219PacienteEstado, BC000912_A220PacienteEstatura, BC000912_A221PacientePeso, BC000912_A222PacienteNombreAnexo, BC000912_n222PacienteNombreAnexo, BC000912_A223PacienteAnexos, BC000912_n223PacienteAnexos, BC000912_A224PacienteEnterarse, BC000912_n224PacienteEnterarse,
            BC000912_A225PacienteEspecifique, BC000912_n225PacienteEspecifique, BC000912_A226PacienteFechaRegistro, BC000912_A43PaisId, BC000912_A6SecUserId, BC000912_n6SecUserId, BC000912_A44UbigeoCode, BC000912_n44UbigeoCode
            }
            , new Object[] {
            BC000913_A20PacienteId, BC000913_A103PacienteApellidoPaterno, BC000913_A104PacienteApellidoMaterno, BC000913_A105PacienteNombres, BC000913_A213PacienteFechaNacimiento, BC000913_A214PacienteTipoDocumento, BC000913_A106PacienteNroDocumento, BC000913_A215PacienteDireccion, BC000913_A216PacienteSexo, BC000913_A217PacienteCorreo,
            BC000913_A218PacienteTelefono, BC000913_A219PacienteEstado, BC000913_A220PacienteEstatura, BC000913_A221PacientePeso, BC000913_A222PacienteNombreAnexo, BC000913_n222PacienteNombreAnexo, BC000913_A223PacienteAnexos, BC000913_n223PacienteAnexos, BC000913_A224PacienteEnterarse, BC000913_n224PacienteEnterarse,
            BC000913_A225PacienteEspecifique, BC000913_n225PacienteEspecifique, BC000913_A226PacienteFechaRegistro, BC000913_A43PaisId, BC000913_A6SecUserId, BC000913_n6SecUserId, BC000913_A44UbigeoCode, BC000913_n44UbigeoCode
            }
            , new Object[] {
            BC000914_A20PacienteId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000918_A184PaisDescripcion
            }
            , new Object[] {
            BC000919_A186UbigeoDepartamento, BC000919_A187UbigeoProvincia, BC000919_A188UbigeoDistrito
            }
            , new Object[] {
            BC000920_A398RatingPlataformaId
            }
            , new Object[] {
            BC000921_A397SugerenciasMejorasPlataformaId
            }
            , new Object[] {
            BC000922_A63ComentarioProfesionalId
            }
            , new Object[] {
            BC000923_A60RatingProfesionalId
            }
            , new Object[] {
            BC000924_A45PacienteFamiliarId
            }
            , new Object[] {
            BC000925_A45PacienteFamiliarId
            }
            , new Object[] {
            BC000926_A51ReclamoId
            }
            , new Object[] {
            BC000927_A19CitaId
            }
            , new Object[] {
            BC000928_A20PacienteId, BC000928_A103PacienteApellidoPaterno, BC000928_A104PacienteApellidoMaterno, BC000928_A105PacienteNombres, BC000928_A213PacienteFechaNacimiento, BC000928_A214PacienteTipoDocumento, BC000928_A106PacienteNroDocumento, BC000928_A215PacienteDireccion, BC000928_A216PacienteSexo, BC000928_A217PacienteCorreo,
            BC000928_A218PacienteTelefono, BC000928_A184PaisDescripcion, BC000928_A219PacienteEstado, BC000928_A220PacienteEstatura, BC000928_A221PacientePeso, BC000928_A222PacienteNombreAnexo, BC000928_n222PacienteNombreAnexo, BC000928_A223PacienteAnexos, BC000928_n223PacienteAnexos, BC000928_A224PacienteEnterarse,
            BC000928_n224PacienteEnterarse, BC000928_A225PacienteEspecifique, BC000928_n225PacienteEspecifique, BC000928_A226PacienteFechaRegistro, BC000928_A186UbigeoDepartamento, BC000928_A187UbigeoProvincia, BC000928_A188UbigeoDistrito, BC000928_A43PaisId, BC000928_A6SecUserId, BC000928_n6SecUserId,
            BC000928_A44UbigeoCode, BC000928_n44UbigeoCode
            }
         }
      );
      Z226PacienteFechaRegistro = GXutil.now( ) ;
      A226PacienteFechaRegistro = GXutil.now( ) ;
      i226PacienteFechaRegistro = GXutil.now( ) ;
      AV27Pgmname = "Paciente_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12092 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV14Insert_PaisId ;
   private short AV12Insert_SecUserId ;
   private short Z43PaisId ;
   private short A43PaisId ;
   private short Z6SecUserId ;
   private short A6SecUserId ;
   private short RcdFound16 ;
   private short nIsDirty_16 ;
   private int trnEnded ;
   private int Z20PacienteId ;
   private int A20PacienteId ;
   private int AV28GXV1 ;
   private int GX_JID ;
   private java.math.BigDecimal Z220PacienteEstatura ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal Z221PacientePeso ;
   private java.math.BigDecimal A221PacientePeso ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV27Pgmname ;
   private String AV15Insert_UbigeoCode ;
   private String Z214PacienteTipoDocumento ;
   private String A214PacienteTipoDocumento ;
   private String Z216PacienteSexo ;
   private String A216PacienteSexo ;
   private String Z218PacienteTelefono ;
   private String A218PacienteTelefono ;
   private String Z219PacienteEstado ;
   private String A219PacienteEstado ;
   private String Z44UbigeoCode ;
   private String A44UbigeoCode ;
   private String sMode16 ;
   private java.util.Date Z226PacienteFechaRegistro ;
   private java.util.Date A226PacienteFechaRegistro ;
   private java.util.Date i226PacienteFechaRegistro ;
   private java.util.Date Z213PacienteFechaNacimiento ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n222PacienteNombreAnexo ;
   private boolean n223PacienteAnexos ;
   private boolean n224PacienteEnterarse ;
   private boolean n225PacienteEspecifique ;
   private boolean n6SecUserId ;
   private boolean n44UbigeoCode ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z225PacienteEspecifique ;
   private String A225PacienteEspecifique ;
   private String Z223PacienteAnexos ;
   private String A223PacienteAnexos ;
   private String Z103PacienteApellidoPaterno ;
   private String A103PacienteApellidoPaterno ;
   private String Z104PacienteApellidoMaterno ;
   private String A104PacienteApellidoMaterno ;
   private String Z105PacienteNombres ;
   private String A105PacienteNombres ;
   private String Z106PacienteNroDocumento ;
   private String A106PacienteNroDocumento ;
   private String Z215PacienteDireccion ;
   private String A215PacienteDireccion ;
   private String Z217PacienteCorreo ;
   private String A217PacienteCorreo ;
   private String Z222PacienteNombreAnexo ;
   private String A222PacienteNombreAnexo ;
   private String Z224PacienteEnterarse ;
   private String A224PacienteEnterarse ;
   private String Z212PacienteNombreCompleto ;
   private String A212PacienteNombreCompleto ;
   private String Z185UbigeoNombre ;
   private String A185UbigeoNombre ;
   private String Z184PaisDescripcion ;
   private String A184PaisDescripcion ;
   private String Z186UbigeoDepartamento ;
   private String A186UbigeoDepartamento ;
   private String Z187UbigeoProvincia ;
   private String A187UbigeoProvincia ;
   private String Z188UbigeoDistrito ;
   private String A188UbigeoDistrito ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtPaciente bcPaciente ;
   private IDataStoreProvider pr_default ;
   private int[] BC00097_A20PacienteId ;
   private String[] BC00097_A103PacienteApellidoPaterno ;
   private String[] BC00097_A104PacienteApellidoMaterno ;
   private String[] BC00097_A105PacienteNombres ;
   private java.util.Date[] BC00097_A213PacienteFechaNacimiento ;
   private String[] BC00097_A214PacienteTipoDocumento ;
   private String[] BC00097_A106PacienteNroDocumento ;
   private String[] BC00097_A215PacienteDireccion ;
   private String[] BC00097_A216PacienteSexo ;
   private String[] BC00097_A217PacienteCorreo ;
   private String[] BC00097_A218PacienteTelefono ;
   private String[] BC00097_A184PaisDescripcion ;
   private String[] BC00097_A219PacienteEstado ;
   private java.math.BigDecimal[] BC00097_A220PacienteEstatura ;
   private java.math.BigDecimal[] BC00097_A221PacientePeso ;
   private String[] BC00097_A222PacienteNombreAnexo ;
   private boolean[] BC00097_n222PacienteNombreAnexo ;
   private String[] BC00097_A223PacienteAnexos ;
   private boolean[] BC00097_n223PacienteAnexos ;
   private String[] BC00097_A224PacienteEnterarse ;
   private boolean[] BC00097_n224PacienteEnterarse ;
   private String[] BC00097_A225PacienteEspecifique ;
   private boolean[] BC00097_n225PacienteEspecifique ;
   private java.util.Date[] BC00097_A226PacienteFechaRegistro ;
   private String[] BC00097_A186UbigeoDepartamento ;
   private String[] BC00097_A187UbigeoProvincia ;
   private String[] BC00097_A188UbigeoDistrito ;
   private short[] BC00097_A43PaisId ;
   private short[] BC00097_A6SecUserId ;
   private boolean[] BC00097_n6SecUserId ;
   private String[] BC00097_A44UbigeoCode ;
   private boolean[] BC00097_n44UbigeoCode ;
   private String[] BC00098_A184PaisDescripcion ;
   private short[] BC00099_A6SecUserId ;
   private boolean[] BC00099_n6SecUserId ;
   private String[] BC000910_A186UbigeoDepartamento ;
   private String[] BC000910_A187UbigeoProvincia ;
   private String[] BC000910_A188UbigeoDistrito ;
   private int[] BC000911_A20PacienteId ;
   private int[] BC000912_A20PacienteId ;
   private String[] BC000912_A103PacienteApellidoPaterno ;
   private String[] BC000912_A104PacienteApellidoMaterno ;
   private String[] BC000912_A105PacienteNombres ;
   private java.util.Date[] BC000912_A213PacienteFechaNacimiento ;
   private String[] BC000912_A214PacienteTipoDocumento ;
   private String[] BC000912_A106PacienteNroDocumento ;
   private String[] BC000912_A215PacienteDireccion ;
   private String[] BC000912_A216PacienteSexo ;
   private String[] BC000912_A217PacienteCorreo ;
   private String[] BC000912_A218PacienteTelefono ;
   private String[] BC000912_A219PacienteEstado ;
   private java.math.BigDecimal[] BC000912_A220PacienteEstatura ;
   private java.math.BigDecimal[] BC000912_A221PacientePeso ;
   private String[] BC000912_A222PacienteNombreAnexo ;
   private boolean[] BC000912_n222PacienteNombreAnexo ;
   private String[] BC000912_A223PacienteAnexos ;
   private boolean[] BC000912_n223PacienteAnexos ;
   private String[] BC000912_A224PacienteEnterarse ;
   private boolean[] BC000912_n224PacienteEnterarse ;
   private String[] BC000912_A225PacienteEspecifique ;
   private boolean[] BC000912_n225PacienteEspecifique ;
   private java.util.Date[] BC000912_A226PacienteFechaRegistro ;
   private short[] BC000912_A43PaisId ;
   private short[] BC000912_A6SecUserId ;
   private boolean[] BC000912_n6SecUserId ;
   private String[] BC000912_A44UbigeoCode ;
   private boolean[] BC000912_n44UbigeoCode ;
   private int[] BC000913_A20PacienteId ;
   private String[] BC000913_A103PacienteApellidoPaterno ;
   private String[] BC000913_A104PacienteApellidoMaterno ;
   private String[] BC000913_A105PacienteNombres ;
   private java.util.Date[] BC000913_A213PacienteFechaNacimiento ;
   private String[] BC000913_A214PacienteTipoDocumento ;
   private String[] BC000913_A106PacienteNroDocumento ;
   private String[] BC000913_A215PacienteDireccion ;
   private String[] BC000913_A216PacienteSexo ;
   private String[] BC000913_A217PacienteCorreo ;
   private String[] BC000913_A218PacienteTelefono ;
   private String[] BC000913_A219PacienteEstado ;
   private java.math.BigDecimal[] BC000913_A220PacienteEstatura ;
   private java.math.BigDecimal[] BC000913_A221PacientePeso ;
   private String[] BC000913_A222PacienteNombreAnexo ;
   private boolean[] BC000913_n222PacienteNombreAnexo ;
   private String[] BC000913_A223PacienteAnexos ;
   private boolean[] BC000913_n223PacienteAnexos ;
   private String[] BC000913_A224PacienteEnterarse ;
   private boolean[] BC000913_n224PacienteEnterarse ;
   private String[] BC000913_A225PacienteEspecifique ;
   private boolean[] BC000913_n225PacienteEspecifique ;
   private java.util.Date[] BC000913_A226PacienteFechaRegistro ;
   private short[] BC000913_A43PaisId ;
   private short[] BC000913_A6SecUserId ;
   private boolean[] BC000913_n6SecUserId ;
   private String[] BC000913_A44UbigeoCode ;
   private boolean[] BC000913_n44UbigeoCode ;
   private int[] BC000914_A20PacienteId ;
   private String[] BC000918_A184PaisDescripcion ;
   private String[] BC000919_A186UbigeoDepartamento ;
   private String[] BC000919_A187UbigeoProvincia ;
   private String[] BC000919_A188UbigeoDistrito ;
   private int[] BC000920_A398RatingPlataformaId ;
   private int[] BC000921_A397SugerenciasMejorasPlataformaId ;
   private int[] BC000922_A63ComentarioProfesionalId ;
   private int[] BC000923_A60RatingProfesionalId ;
   private int[] BC000924_A45PacienteFamiliarId ;
   private int[] BC000925_A45PacienteFamiliarId ;
   private int[] BC000926_A51ReclamoId ;
   private int[] BC000927_A19CitaId ;
   private int[] BC000928_A20PacienteId ;
   private String[] BC000928_A103PacienteApellidoPaterno ;
   private String[] BC000928_A104PacienteApellidoMaterno ;
   private String[] BC000928_A105PacienteNombres ;
   private java.util.Date[] BC000928_A213PacienteFechaNacimiento ;
   private String[] BC000928_A214PacienteTipoDocumento ;
   private String[] BC000928_A106PacienteNroDocumento ;
   private String[] BC000928_A215PacienteDireccion ;
   private String[] BC000928_A216PacienteSexo ;
   private String[] BC000928_A217PacienteCorreo ;
   private String[] BC000928_A218PacienteTelefono ;
   private String[] BC000928_A184PaisDescripcion ;
   private String[] BC000928_A219PacienteEstado ;
   private java.math.BigDecimal[] BC000928_A220PacienteEstatura ;
   private java.math.BigDecimal[] BC000928_A221PacientePeso ;
   private String[] BC000928_A222PacienteNombreAnexo ;
   private boolean[] BC000928_n222PacienteNombreAnexo ;
   private String[] BC000928_A223PacienteAnexos ;
   private boolean[] BC000928_n223PacienteAnexos ;
   private String[] BC000928_A224PacienteEnterarse ;
   private boolean[] BC000928_n224PacienteEnterarse ;
   private String[] BC000928_A225PacienteEspecifique ;
   private boolean[] BC000928_n225PacienteEspecifique ;
   private java.util.Date[] BC000928_A226PacienteFechaRegistro ;
   private String[] BC000928_A186UbigeoDepartamento ;
   private String[] BC000928_A187UbigeoProvincia ;
   private String[] BC000928_A188UbigeoDistrito ;
   private short[] BC000928_A43PaisId ;
   private short[] BC000928_A6SecUserId ;
   private boolean[] BC000928_n6SecUserId ;
   private String[] BC000928_A44UbigeoCode ;
   private boolean[] BC000928_n44UbigeoCode ;
   private int[] BC00092_A20PacienteId ;
   private String[] BC00092_A103PacienteApellidoPaterno ;
   private String[] BC00092_A104PacienteApellidoMaterno ;
   private String[] BC00092_A105PacienteNombres ;
   private java.util.Date[] BC00092_A213PacienteFechaNacimiento ;
   private String[] BC00092_A214PacienteTipoDocumento ;
   private String[] BC00092_A106PacienteNroDocumento ;
   private String[] BC00092_A215PacienteDireccion ;
   private String[] BC00092_A216PacienteSexo ;
   private String[] BC00092_A217PacienteCorreo ;
   private String[] BC00092_A218PacienteTelefono ;
   private String[] BC00092_A219PacienteEstado ;
   private java.math.BigDecimal[] BC00092_A220PacienteEstatura ;
   private java.math.BigDecimal[] BC00092_A221PacientePeso ;
   private String[] BC00092_A222PacienteNombreAnexo ;
   private String[] BC00092_A223PacienteAnexos ;
   private String[] BC00092_A224PacienteEnterarse ;
   private String[] BC00092_A225PacienteEspecifique ;
   private java.util.Date[] BC00092_A226PacienteFechaRegistro ;
   private short[] BC00092_A43PaisId ;
   private short[] BC00092_A6SecUserId ;
   private String[] BC00092_A44UbigeoCode ;
   private int[] BC00093_A20PacienteId ;
   private String[] BC00093_A103PacienteApellidoPaterno ;
   private String[] BC00093_A104PacienteApellidoMaterno ;
   private String[] BC00093_A105PacienteNombres ;
   private java.util.Date[] BC00093_A213PacienteFechaNacimiento ;
   private String[] BC00093_A214PacienteTipoDocumento ;
   private String[] BC00093_A106PacienteNroDocumento ;
   private String[] BC00093_A215PacienteDireccion ;
   private String[] BC00093_A216PacienteSexo ;
   private String[] BC00093_A217PacienteCorreo ;
   private String[] BC00093_A218PacienteTelefono ;
   private String[] BC00093_A219PacienteEstado ;
   private java.math.BigDecimal[] BC00093_A220PacienteEstatura ;
   private java.math.BigDecimal[] BC00093_A221PacientePeso ;
   private String[] BC00093_A222PacienteNombreAnexo ;
   private String[] BC00093_A223PacienteAnexos ;
   private String[] BC00093_A224PacienteEnterarse ;
   private String[] BC00093_A225PacienteEspecifique ;
   private java.util.Date[] BC00093_A226PacienteFechaRegistro ;
   private short[] BC00093_A43PaisId ;
   private short[] BC00093_A6SecUserId ;
   private String[] BC00093_A44UbigeoCode ;
   private String[] BC00094_A184PaisDescripcion ;
   private short[] BC00095_A6SecUserId ;
   private String[] BC00096_A186UbigeoDepartamento ;
   private String[] BC00096_A187UbigeoProvincia ;
   private String[] BC00096_A188UbigeoDistrito ;
   private boolean[] BC00092_n222PacienteNombreAnexo ;
   private boolean[] BC00092_n223PacienteAnexos ;
   private boolean[] BC00092_n224PacienteEnterarse ;
   private boolean[] BC00092_n225PacienteEspecifique ;
   private boolean[] BC00092_n6SecUserId ;
   private boolean[] BC00092_n44UbigeoCode ;
   private boolean[] BC00093_n222PacienteNombreAnexo ;
   private boolean[] BC00093_n223PacienteAnexos ;
   private boolean[] BC00093_n224PacienteEnterarse ;
   private boolean[] BC00093_n225PacienteEspecifique ;
   private boolean[] BC00093_n6SecUserId ;
   private boolean[] BC00093_n44UbigeoCode ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class paciente_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00092", "SELECT [PacienteId], [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteFechaNacimiento], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteDireccion], [PacienteSexo], [PacienteCorreo], [PacienteTelefono], [PacienteEstado], [PacienteEstatura], [PacientePeso], [PacienteNombreAnexo], [PacienteAnexos], [PacienteEnterarse], [PacienteEspecifique], [PacienteFechaRegistro], [PaisId], [SecUserId], [UbigeoCode] FROM [Paciente] WITH (UPDLOCK) WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00093", "SELECT [PacienteId], [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteFechaNacimiento], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteDireccion], [PacienteSexo], [PacienteCorreo], [PacienteTelefono], [PacienteEstado], [PacienteEstatura], [PacientePeso], [PacienteNombreAnexo], [PacienteAnexos], [PacienteEnterarse], [PacienteEspecifique], [PacienteFechaRegistro], [PaisId], [SecUserId], [UbigeoCode] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00094", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00095", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00096", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00097", "SELECT TM1.[PacienteId], TM1.[PacienteApellidoPaterno], TM1.[PacienteApellidoMaterno], TM1.[PacienteNombres], TM1.[PacienteFechaNacimiento], TM1.[PacienteTipoDocumento], TM1.[PacienteNroDocumento], TM1.[PacienteDireccion], TM1.[PacienteSexo], TM1.[PacienteCorreo], TM1.[PacienteTelefono], T2.[PaisDescripcion], TM1.[PacienteEstado], TM1.[PacienteEstatura], TM1.[PacientePeso], TM1.[PacienteNombreAnexo], TM1.[PacienteAnexos], TM1.[PacienteEnterarse], TM1.[PacienteEspecifique], TM1.[PacienteFechaRegistro], T3.[UbigeoDepartamento], T3.[UbigeoProvincia], T3.[UbigeoDistrito], TM1.[PaisId], TM1.[SecUserId], TM1.[UbigeoCode] FROM (([Paciente] TM1 INNER JOIN [Pais] T2 ON T2.[PaisId] = TM1.[PaisId]) LEFT JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = TM1.[UbigeoCode]) WHERE TM1.[PacienteId] = ? ORDER BY TM1.[PacienteId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00098", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00099", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000910", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000911", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000912", "SELECT [PacienteId], [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteFechaNacimiento], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteDireccion], [PacienteSexo], [PacienteCorreo], [PacienteTelefono], [PacienteEstado], [PacienteEstatura], [PacientePeso], [PacienteNombreAnexo], [PacienteAnexos], [PacienteEnterarse], [PacienteEspecifique], [PacienteFechaRegistro], [PaisId], [SecUserId], [UbigeoCode] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000913", "SELECT [PacienteId], [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteFechaNacimiento], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteDireccion], [PacienteSexo], [PacienteCorreo], [PacienteTelefono], [PacienteEstado], [PacienteEstatura], [PacientePeso], [PacienteNombreAnexo], [PacienteAnexos], [PacienteEnterarse], [PacienteEspecifique], [PacienteFechaRegistro], [PaisId], [SecUserId], [UbigeoCode] FROM [Paciente] WITH (UPDLOCK) WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000914", "INSERT INTO [Paciente]([PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteFechaNacimiento], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteDireccion], [PacienteSexo], [PacienteCorreo], [PacienteTelefono], [PacienteEstado], [PacienteEstatura], [PacientePeso], [PacienteNombreAnexo], [PacienteAnexos], [PacienteEnterarse], [PacienteEspecifique], [PacienteFechaRegistro], [PaisId], [SecUserId], [UbigeoCode]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000915", "UPDATE [Paciente] SET [PacienteApellidoPaterno]=?, [PacienteApellidoMaterno]=?, [PacienteNombres]=?, [PacienteFechaNacimiento]=?, [PacienteTipoDocumento]=?, [PacienteNroDocumento]=?, [PacienteDireccion]=?, [PacienteSexo]=?, [PacienteCorreo]=?, [PacienteTelefono]=?, [PacienteEstado]=?, [PacienteEstatura]=?, [PacientePeso]=?, [PacienteNombreAnexo]=?, [PacienteEnterarse]=?, [PacienteEspecifique]=?, [PacienteFechaRegistro]=?, [PaisId]=?, [SecUserId]=?, [UbigeoCode]=?  WHERE [PacienteId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000916", "UPDATE [Paciente] SET [PacienteAnexos]=?  WHERE [PacienteId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000917", "DELETE FROM [Paciente]  WHERE [PacienteId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000918", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000919", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000920", "SELECT TOP 1 [RatingPlataformaId] FROM [RatingPlataforma] WHERE [SGPacientePacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000921", "SELECT TOP 1 [SugerenciasMejorasPlataformaId] FROM [SugerenciasMejorasPlataforma] WHERE [SGPacientePacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000922", "SELECT TOP 1 [ComentarioProfesionalId] FROM [ComentarioProfesional] WHERE [SGPacientePacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000923", "SELECT TOP 1 [RatingProfesionalId] FROM [RatingProfesional] WHERE [SGPacientePacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000924", "SELECT TOP 1 [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE [SGPacienteHijoPacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000925", "SELECT TOP 1 [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000926", "SELECT TOP 1 [ReclamoId] FROM [Reclamo] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000927", "SELECT TOP 1 [CitaId] FROM [Cita] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000928", "SELECT TM1.[PacienteId], TM1.[PacienteApellidoPaterno], TM1.[PacienteApellidoMaterno], TM1.[PacienteNombres], TM1.[PacienteFechaNacimiento], TM1.[PacienteTipoDocumento], TM1.[PacienteNroDocumento], TM1.[PacienteDireccion], TM1.[PacienteSexo], TM1.[PacienteCorreo], TM1.[PacienteTelefono], T2.[PaisDescripcion], TM1.[PacienteEstado], TM1.[PacienteEstatura], TM1.[PacientePeso], TM1.[PacienteNombreAnexo], TM1.[PacienteAnexos], TM1.[PacienteEnterarse], TM1.[PacienteEspecifique], TM1.[PacienteFechaRegistro], T3.[UbigeoDepartamento], T3.[UbigeoProvincia], T3.[UbigeoDistrito], TM1.[PaisId], TM1.[SecUserId], TM1.[UbigeoCode] FROM (([Paciente] TM1 INNER JOIN [Pais] T2 ON T2.[PaisId] = TM1.[PaisId]) LEFT JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = TM1.[UbigeoCode]) WHERE TM1.[PacienteId] = ? ORDER BY TM1.[PacienteId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getBLOBFile(16, "tmp", "");
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDateTime(19);
               ((short[]) buf[23])[0] = rslt.getShort(20);
               ((short[]) buf[24])[0] = rslt.getShort(21);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(22, 10);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getBLOBFile(16, "tmp", "");
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDateTime(19);
               ((short[]) buf[23])[0] = rslt.getShort(20);
               ((short[]) buf[24])[0] = rslt.getShort(21);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(22, 10);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getBLOBFile(17, "tmp", "");
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getLongVarchar(19);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDateTime(20);
               ((String[]) buf[24])[0] = rslt.getVarchar(21);
               ((String[]) buf[25])[0] = rslt.getVarchar(22);
               ((String[]) buf[26])[0] = rslt.getVarchar(23);
               ((short[]) buf[27])[0] = rslt.getShort(24);
               ((short[]) buf[28])[0] = rslt.getShort(25);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getString(26, 10);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getBLOBFile(16, "tmp", "");
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDateTime(19);
               ((short[]) buf[23])[0] = rslt.getShort(20);
               ((short[]) buf[24])[0] = rslt.getShort(21);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(22, 10);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getBLOBFile(16, "tmp", "");
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDateTime(19);
               ((short[]) buf[23])[0] = rslt.getShort(20);
               ((short[]) buf[24])[0] = rslt.getShort(21);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(22, 10);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getBLOBFile(17, "tmp", "");
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getLongVarchar(19);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDateTime(20);
               ((String[]) buf[24])[0] = rslt.getVarchar(21);
               ((String[]) buf[25])[0] = rslt.getVarchar(22);
               ((String[]) buf[26])[0] = rslt.getVarchar(23);
               ((short[]) buf[27])[0] = rslt.getShort(24);
               ((short[]) buf[28])[0] = rslt.getShort(25);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getString(26, 10);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setVarchar(6, (String)parms[5], 15, false);
               stmt.setVarchar(7, (String)parms[6], 500, false);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[12], 2);
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[14], 100);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(15, (String)parms[16]);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(16, (String)parms[18], 2);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(17, (String)parms[20]);
               }
               stmt.setDateTime(18, (java.util.Date)parms[21], false);
               stmt.setShort(19, ((Number) parms[22]).shortValue());
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(20, ((Number) parms[24]).shortValue());
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(21, (String)parms[26], 10);
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setVarchar(6, (String)parms[5], 15, false);
               stmt.setVarchar(7, (String)parms[6], 500, false);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[12], 2);
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[14], 100);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(15, (String)parms[16], 2);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(16, (String)parms[18]);
               }
               stmt.setDateTime(17, (java.util.Date)parms[19], false);
               stmt.setShort(18, ((Number) parms[20]).shortValue());
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(19, ((Number) parms[22]).shortValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(20, (String)parms[24], 10);
               }
               stmt.setInt(21, ((Number) parms[25]).intValue());
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

