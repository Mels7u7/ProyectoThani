package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class sede_bc extends GXWebPanel implements IGxSilentTrn
{
   public sede_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public sede_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sede_bc.class ));
   }

   public sede_bc( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0N44( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0N44( ) ;
      standaloneModal( ) ;
      addRow0N44( ) ;
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
         e110N2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z30SedeId = A30SedeId ;
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

   public void confirm_0N0( )
   {
      beforeValidate0N44( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0N44( ) ;
         }
         else
         {
            checkExtendedTable0N44( ) ;
            if ( AnyError == 0 )
            {
               zm0N44( 9) ;
               zm0N44( 10) ;
            }
            closeExtendedTableCursors0N44( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120N2( )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede_Insert", GXv_boolean3) ;
         sede_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede_Update", GXv_boolean3) ;
         sede_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede_Delete", GXv_boolean3) ;
         sede_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV28Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV28Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV29GXV1 = 1 ;
         while ( AV29GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV29GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ClinicaId") == 0 )
            {
               AV14Insert_ClinicaId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "UbigeoCode") == 0 )
            {
               AV12Insert_UbigeoCode = AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV29GXV1 = (int)(AV29GXV1+1) ;
         }
      }
   }

   public void e110N2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0N44( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z75SedeNombre = A75SedeNombre ;
         Z276SedeDireccion = A276SedeDireccion ;
         Z277SedeCorreo = A277SedeCorreo ;
         Z278SedeEstado = A278SedeEstado ;
         Z279SedeTipo = A279SedeTipo ;
         Z280SedeSector = A280SedeSector ;
         Z28ClinicaId = A28ClinicaId ;
         Z44UbigeoCode = A44UbigeoCode ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z118ClinicaRUC = A118ClinicaRUC ;
         Z116ClinicaNombreComercial = A116ClinicaNombreComercial ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         Z186UbigeoDepartamento = A186UbigeoDepartamento ;
         Z187UbigeoProvincia = A187UbigeoProvincia ;
         Z188UbigeoDistrito = A188UbigeoDistrito ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( GX_JID == -8 )
      {
         Z30SedeId = A30SedeId ;
         Z75SedeNombre = A75SedeNombre ;
         Z276SedeDireccion = A276SedeDireccion ;
         Z277SedeCorreo = A277SedeCorreo ;
         Z278SedeEstado = A278SedeEstado ;
         Z279SedeTipo = A279SedeTipo ;
         Z280SedeSector = A280SedeSector ;
         Z28ClinicaId = A28ClinicaId ;
         Z44UbigeoCode = A44UbigeoCode ;
         Z118ClinicaRUC = A118ClinicaRUC ;
         Z116ClinicaNombreComercial = A116ClinicaNombreComercial ;
         Z186UbigeoDepartamento = A186UbigeoDepartamento ;
         Z187UbigeoProvincia = A187UbigeoProvincia ;
         Z188UbigeoDistrito = A188UbigeoDistrito ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0N44( )
   {
      /* Using cursor BC000N6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound44 = (short)(1) ;
         A75SedeNombre = BC000N6_A75SedeNombre[0] ;
         A118ClinicaRUC = BC000N6_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = BC000N6_A116ClinicaNombreComercial[0] ;
         A276SedeDireccion = BC000N6_A276SedeDireccion[0] ;
         A277SedeCorreo = BC000N6_A277SedeCorreo[0] ;
         A278SedeEstado = BC000N6_A278SedeEstado[0] ;
         A279SedeTipo = BC000N6_A279SedeTipo[0] ;
         A280SedeSector = BC000N6_A280SedeSector[0] ;
         A186UbigeoDepartamento = BC000N6_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000N6_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000N6_A188UbigeoDistrito[0] ;
         A28ClinicaId = BC000N6_A28ClinicaId[0] ;
         A44UbigeoCode = BC000N6_A44UbigeoCode[0] ;
         zm0N44( -8) ;
      }
      pr_default.close(4);
      onLoadActions0N44( ) ;
   }

   public void onLoadActions0N44( )
   {
      AV28Pgmname = "Sede_BC" ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
   }

   public void checkExtendedTable0N44( )
   {
      nIsDirty_44 = (short)(0) ;
      standaloneModal( ) ;
      AV28Pgmname = "Sede_BC" ;
      /* Using cursor BC000N7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "CLINICAID");
         AnyError = (short)(1) ;
      }
      A118ClinicaRUC = BC000N7_A118ClinicaRUC[0] ;
      A116ClinicaNombreComercial = BC000N7_A116ClinicaNombreComercial[0] ;
      pr_default.close(5);
      /* Using cursor BC000N8 */
      pr_default.execute(6, new Object[] {A44UbigeoCode});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
         AnyError = (short)(1) ;
      }
      A186UbigeoDepartamento = BC000N8_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = BC000N8_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = BC000N8_A188UbigeoDistrito[0] ;
      pr_default.close(6);
      nIsDirty_44 = (short)(1) ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      if ( ! ( GxRegex.IsMatch(A277SedeCorreo,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Sede Correo no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A278SedeEstado, "A") == 0 ) || ( GXutil.strcmp(A278SedeEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sede Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A279SedeTipo, "H") == 0 ) || ( GXutil.strcmp(A279SedeTipo, "C") == 0 ) || ( GXutil.strcmp(A279SedeTipo, "P") == 0 ) || ( GXutil.strcmp(A279SedeTipo, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sede Tipo fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A280SedeSector, "P") == 0 ) || ( GXutil.strcmp(A280SedeSector, "V") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sede Sector fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0N44( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey0N44( )
   {
      /* Using cursor BC000N9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound44 = (short)(1) ;
      }
      else
      {
         RcdFound44 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000N10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0N44( 8) ;
         RcdFound44 = (short)(1) ;
         A30SedeId = BC000N10_A30SedeId[0] ;
         A75SedeNombre = BC000N10_A75SedeNombre[0] ;
         A276SedeDireccion = BC000N10_A276SedeDireccion[0] ;
         A277SedeCorreo = BC000N10_A277SedeCorreo[0] ;
         A278SedeEstado = BC000N10_A278SedeEstado[0] ;
         A279SedeTipo = BC000N10_A279SedeTipo[0] ;
         A280SedeSector = BC000N10_A280SedeSector[0] ;
         A28ClinicaId = BC000N10_A28ClinicaId[0] ;
         A44UbigeoCode = BC000N10_A44UbigeoCode[0] ;
         Z30SedeId = A30SedeId ;
         sMode44 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0N44( ) ;
         if ( AnyError == 1 )
         {
            RcdFound44 = (short)(0) ;
            initializeNonKey0N44( ) ;
         }
         Gx_mode = sMode44 ;
      }
      else
      {
         RcdFound44 = (short)(0) ;
         initializeNonKey0N44( ) ;
         sMode44 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode44 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0N44( ) ;
      if ( RcdFound44 == 0 )
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
      confirm_0N0( ) ;
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

   public void checkOptimisticConcurrency0N44( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000N11 */
         pr_default.execute(9, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Sede"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z75SedeNombre, BC000N11_A75SedeNombre[0]) != 0 ) || ( GXutil.strcmp(Z276SedeDireccion, BC000N11_A276SedeDireccion[0]) != 0 ) || ( GXutil.strcmp(Z277SedeCorreo, BC000N11_A277SedeCorreo[0]) != 0 ) || ( GXutil.strcmp(Z278SedeEstado, BC000N11_A278SedeEstado[0]) != 0 ) || ( GXutil.strcmp(Z279SedeTipo, BC000N11_A279SedeTipo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z280SedeSector, BC000N11_A280SedeSector[0]) != 0 ) || ( Z28ClinicaId != BC000N11_A28ClinicaId[0] ) || ( GXutil.strcmp(Z44UbigeoCode, BC000N11_A44UbigeoCode[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Sede"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0N44( )
   {
      beforeValidate0N44( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0N44( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0N44( 0) ;
         checkOptimisticConcurrency0N44( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0N44( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0N44( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000N12 */
                  pr_default.execute(10, new Object[] {A75SedeNombre, A276SedeDireccion, A277SedeCorreo, A278SedeEstado, A279SedeTipo, A280SedeSector, Short.valueOf(A28ClinicaId), A44UbigeoCode});
                  A30SedeId = BC000N12_A30SedeId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Sede");
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
            load0N44( ) ;
         }
         endLevel0N44( ) ;
      }
      closeExtendedTableCursors0N44( ) ;
   }

   public void update0N44( )
   {
      beforeValidate0N44( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0N44( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0N44( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0N44( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0N44( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000N13 */
                  pr_default.execute(11, new Object[] {A75SedeNombre, A276SedeDireccion, A277SedeCorreo, A278SedeEstado, A279SedeTipo, A280SedeSector, Short.valueOf(A28ClinicaId), A44UbigeoCode, Short.valueOf(A30SedeId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Sede");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Sede"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0N44( ) ;
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
         endLevel0N44( ) ;
      }
      closeExtendedTableCursors0N44( ) ;
   }

   public void deferredUpdate0N44( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0N44( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0N44( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0N44( ) ;
         afterConfirm0N44( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0N44( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000N14 */
               pr_default.execute(12, new Object[] {Short.valueOf(A30SedeId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Sede");
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
      sMode44 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0N44( ) ;
      Gx_mode = sMode44 ;
   }

   public void onDeleteControls0N44( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV28Pgmname = "Sede_BC" ;
         /* Using cursor BC000N15 */
         pr_default.execute(13, new Object[] {Short.valueOf(A28ClinicaId)});
         A118ClinicaRUC = BC000N15_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = BC000N15_A116ClinicaNombreComercial[0] ;
         pr_default.close(13);
         /* Using cursor BC000N16 */
         pr_default.execute(14, new Object[] {A44UbigeoCode});
         A186UbigeoDepartamento = BC000N16_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000N16_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000N16_A188UbigeoDistrito[0] ;
         pr_default.close(14);
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000N17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sede"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor BC000N18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Disponibilidad"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor BC000N19 */
         pr_default.execute(17, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Conf Comision"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor BC000N20 */
         pr_default.execute(18, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sede"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
      }
   }

   public void endLevel0N44( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0N44( ) ;
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

   public void scanKeyStart0N44( )
   {
      /* Scan By routine */
      /* Using cursor BC000N21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A30SedeId)});
      RcdFound44 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound44 = (short)(1) ;
         A30SedeId = BC000N21_A30SedeId[0] ;
         A75SedeNombre = BC000N21_A75SedeNombre[0] ;
         A118ClinicaRUC = BC000N21_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = BC000N21_A116ClinicaNombreComercial[0] ;
         A276SedeDireccion = BC000N21_A276SedeDireccion[0] ;
         A277SedeCorreo = BC000N21_A277SedeCorreo[0] ;
         A278SedeEstado = BC000N21_A278SedeEstado[0] ;
         A279SedeTipo = BC000N21_A279SedeTipo[0] ;
         A280SedeSector = BC000N21_A280SedeSector[0] ;
         A186UbigeoDepartamento = BC000N21_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000N21_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000N21_A188UbigeoDistrito[0] ;
         A28ClinicaId = BC000N21_A28ClinicaId[0] ;
         A44UbigeoCode = BC000N21_A44UbigeoCode[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0N44( )
   {
      /* Scan next routine */
      pr_default.readNext(19);
      RcdFound44 = (short)(0) ;
      scanKeyLoad0N44( ) ;
   }

   public void scanKeyLoad0N44( )
   {
      sMode44 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound44 = (short)(1) ;
         A30SedeId = BC000N21_A30SedeId[0] ;
         A75SedeNombre = BC000N21_A75SedeNombre[0] ;
         A118ClinicaRUC = BC000N21_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = BC000N21_A116ClinicaNombreComercial[0] ;
         A276SedeDireccion = BC000N21_A276SedeDireccion[0] ;
         A277SedeCorreo = BC000N21_A277SedeCorreo[0] ;
         A278SedeEstado = BC000N21_A278SedeEstado[0] ;
         A279SedeTipo = BC000N21_A279SedeTipo[0] ;
         A280SedeSector = BC000N21_A280SedeSector[0] ;
         A186UbigeoDepartamento = BC000N21_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000N21_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000N21_A188UbigeoDistrito[0] ;
         A28ClinicaId = BC000N21_A28ClinicaId[0] ;
         A44UbigeoCode = BC000N21_A44UbigeoCode[0] ;
      }
      Gx_mode = sMode44 ;
   }

   public void scanKeyEnd0N44( )
   {
      pr_default.close(19);
   }

   public void afterConfirm0N44( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0N44( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0N44( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0N44( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0N44( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0N44( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0N44( )
   {
   }

   public void send_integrity_lvl_hashes0N44( )
   {
   }

   public void addRow0N44( )
   {
      VarsToRow44( bcSede) ;
   }

   public void readRow0N44( )
   {
      RowToVars44( bcSede, 1) ;
   }

   public void initializeNonKey0N44( )
   {
      A75SedeNombre = "" ;
      A28ClinicaId = (short)(0) ;
      A118ClinicaRUC = 0 ;
      A116ClinicaNombreComercial = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A276SedeDireccion = "" ;
      A277SedeCorreo = "" ;
      A278SedeEstado = "" ;
      A279SedeTipo = "" ;
      A280SedeSector = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      Z75SedeNombre = "" ;
      Z276SedeDireccion = "" ;
      Z277SedeCorreo = "" ;
      Z278SedeEstado = "" ;
      Z279SedeTipo = "" ;
      Z280SedeSector = "" ;
      Z28ClinicaId = (short)(0) ;
      Z44UbigeoCode = "" ;
   }

   public void initAll0N44( )
   {
      A30SedeId = (short)(0) ;
      initializeNonKey0N44( ) ;
   }

   public void standaloneModalInsert( )
   {
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

   public void VarsToRow44( com.projectthani.SdtSede obj44 )
   {
      obj44.setgxTv_SdtSede_Mode( Gx_mode );
      obj44.setgxTv_SdtSede_Sedenombre( A75SedeNombre );
      obj44.setgxTv_SdtSede_Clinicaid( A28ClinicaId );
      obj44.setgxTv_SdtSede_Clinicaruc( A118ClinicaRUC );
      obj44.setgxTv_SdtSede_Clinicanombrecomercial( A116ClinicaNombreComercial );
      obj44.setgxTv_SdtSede_Ubigeocode( A44UbigeoCode );
      obj44.setgxTv_SdtSede_Ubigeonombre( A185UbigeoNombre );
      obj44.setgxTv_SdtSede_Sededireccion( A276SedeDireccion );
      obj44.setgxTv_SdtSede_Sedecorreo( A277SedeCorreo );
      obj44.setgxTv_SdtSede_Sedeestado( A278SedeEstado );
      obj44.setgxTv_SdtSede_Sedetipo( A279SedeTipo );
      obj44.setgxTv_SdtSede_Sedesector( A280SedeSector );
      obj44.setgxTv_SdtSede_Sedeid( A30SedeId );
      obj44.setgxTv_SdtSede_Sedeid_Z( Z30SedeId );
      obj44.setgxTv_SdtSede_Sedenombre_Z( Z75SedeNombre );
      obj44.setgxTv_SdtSede_Clinicaid_Z( Z28ClinicaId );
      obj44.setgxTv_SdtSede_Clinicaruc_Z( Z118ClinicaRUC );
      obj44.setgxTv_SdtSede_Clinicanombrecomercial_Z( Z116ClinicaNombreComercial );
      obj44.setgxTv_SdtSede_Ubigeocode_Z( Z44UbigeoCode );
      obj44.setgxTv_SdtSede_Ubigeonombre_Z( Z185UbigeoNombre );
      obj44.setgxTv_SdtSede_Sededireccion_Z( Z276SedeDireccion );
      obj44.setgxTv_SdtSede_Sedecorreo_Z( Z277SedeCorreo );
      obj44.setgxTv_SdtSede_Sedeestado_Z( Z278SedeEstado );
      obj44.setgxTv_SdtSede_Sedetipo_Z( Z279SedeTipo );
      obj44.setgxTv_SdtSede_Sedesector_Z( Z280SedeSector );
      obj44.setgxTv_SdtSede_Mode( Gx_mode );
   }

   public void KeyVarsToRow44( com.projectthani.SdtSede obj44 )
   {
      obj44.setgxTv_SdtSede_Sedeid( A30SedeId );
   }

   public void RowToVars44( com.projectthani.SdtSede obj44 ,
                            int forceLoad )
   {
      Gx_mode = obj44.getgxTv_SdtSede_Mode() ;
      A75SedeNombre = obj44.getgxTv_SdtSede_Sedenombre() ;
      A28ClinicaId = obj44.getgxTv_SdtSede_Clinicaid() ;
      A118ClinicaRUC = obj44.getgxTv_SdtSede_Clinicaruc() ;
      A116ClinicaNombreComercial = obj44.getgxTv_SdtSede_Clinicanombrecomercial() ;
      A44UbigeoCode = obj44.getgxTv_SdtSede_Ubigeocode() ;
      A185UbigeoNombre = obj44.getgxTv_SdtSede_Ubigeonombre() ;
      A276SedeDireccion = obj44.getgxTv_SdtSede_Sededireccion() ;
      A277SedeCorreo = obj44.getgxTv_SdtSede_Sedecorreo() ;
      A278SedeEstado = obj44.getgxTv_SdtSede_Sedeestado() ;
      A279SedeTipo = obj44.getgxTv_SdtSede_Sedetipo() ;
      A280SedeSector = obj44.getgxTv_SdtSede_Sedesector() ;
      A30SedeId = obj44.getgxTv_SdtSede_Sedeid() ;
      Z30SedeId = obj44.getgxTv_SdtSede_Sedeid_Z() ;
      Z75SedeNombre = obj44.getgxTv_SdtSede_Sedenombre_Z() ;
      Z28ClinicaId = obj44.getgxTv_SdtSede_Clinicaid_Z() ;
      Z118ClinicaRUC = obj44.getgxTv_SdtSede_Clinicaruc_Z() ;
      Z116ClinicaNombreComercial = obj44.getgxTv_SdtSede_Clinicanombrecomercial_Z() ;
      Z44UbigeoCode = obj44.getgxTv_SdtSede_Ubigeocode_Z() ;
      Z185UbigeoNombre = obj44.getgxTv_SdtSede_Ubigeonombre_Z() ;
      Z276SedeDireccion = obj44.getgxTv_SdtSede_Sededireccion_Z() ;
      Z277SedeCorreo = obj44.getgxTv_SdtSede_Sedecorreo_Z() ;
      Z278SedeEstado = obj44.getgxTv_SdtSede_Sedeestado_Z() ;
      Z279SedeTipo = obj44.getgxTv_SdtSede_Sedetipo_Z() ;
      Z280SedeSector = obj44.getgxTv_SdtSede_Sedesector_Z() ;
      Gx_mode = obj44.getgxTv_SdtSede_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A30SedeId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0N44( ) ;
      scanKeyStart0N44( ) ;
      if ( RcdFound44 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z30SedeId = A30SedeId ;
      }
      zm0N44( -8) ;
      onLoadActions0N44( ) ;
      addRow0N44( ) ;
      scanKeyEnd0N44( ) ;
      if ( RcdFound44 == 0 )
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
      RowToVars44( bcSede, 0) ;
      scanKeyStart0N44( ) ;
      if ( RcdFound44 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z30SedeId = A30SedeId ;
      }
      zm0N44( -8) ;
      onLoadActions0N44( ) ;
      addRow0N44( ) ;
      scanKeyEnd0N44( ) ;
      if ( RcdFound44 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0N44( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0N44( ) ;
      }
      else
      {
         if ( RcdFound44 == 1 )
         {
            if ( A30SedeId != Z30SedeId )
            {
               A30SedeId = Z30SedeId ;
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
               update0N44( ) ;
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
               if ( A30SedeId != Z30SedeId )
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
                     insert0N44( ) ;
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
                     insert0N44( ) ;
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
      RowToVars44( bcSede, 1) ;
      saveImpl( ) ;
      VarsToRow44( bcSede) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars44( bcSede, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0N44( ) ;
      afterTrn( ) ;
      VarsToRow44( bcSede) ;
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
         com.projectthani.SdtSede auxBC = new com.projectthani.SdtSede( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A30SedeId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcSede);
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
      RowToVars44( bcSede, 1) ;
      updateImpl( ) ;
      VarsToRow44( bcSede) ;
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
      RowToVars44( bcSede, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0N44( ) ;
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
      VarsToRow44( bcSede) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars44( bcSede, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0N44( ) ;
      if ( RcdFound44 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A30SedeId != Z30SedeId )
         {
            A30SedeId = Z30SedeId ;
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
         if ( A30SedeId != Z30SedeId )
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
      pr_default.close(13);
      pr_default.close(2);
      pr_default.close(14);
      pr_default.close(3);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "sede_bc");
      VarsToRow44( bcSede) ;
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
      Gx_mode = bcSede.getgxTv_SdtSede_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcSede.setgxTv_SdtSede_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtSede sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcSede )
      {
         bcSede = sdt ;
         if ( GXutil.strcmp(bcSede.getgxTv_SdtSede_Mode(), "") == 0 )
         {
            bcSede.setgxTv_SdtSede_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow44( bcSede) ;
         }
         else
         {
            RowToVars44( bcSede, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcSede.getgxTv_SdtSede_Mode(), "") == 0 )
         {
            bcSede.setgxTv_SdtSede_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars44( bcSede, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtSede getSede_BC( )
   {
      return bcSede ;
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
      AV28Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV12Insert_UbigeoCode = "" ;
      Z75SedeNombre = "" ;
      A75SedeNombre = "" ;
      Z276SedeDireccion = "" ;
      A276SedeDireccion = "" ;
      Z277SedeCorreo = "" ;
      A277SedeCorreo = "" ;
      Z278SedeEstado = "" ;
      A278SedeEstado = "" ;
      Z279SedeTipo = "" ;
      A279SedeTipo = "" ;
      Z280SedeSector = "" ;
      A280SedeSector = "" ;
      Z44UbigeoCode = "" ;
      A44UbigeoCode = "" ;
      Z185UbigeoNombre = "" ;
      A185UbigeoNombre = "" ;
      Z116ClinicaNombreComercial = "" ;
      A116ClinicaNombreComercial = "" ;
      Z186UbigeoDepartamento = "" ;
      A186UbigeoDepartamento = "" ;
      Z187UbigeoProvincia = "" ;
      A187UbigeoProvincia = "" ;
      Z188UbigeoDistrito = "" ;
      A188UbigeoDistrito = "" ;
      BC000N6_A30SedeId = new short[1] ;
      BC000N6_A75SedeNombre = new String[] {""} ;
      BC000N6_A118ClinicaRUC = new long[1] ;
      BC000N6_A116ClinicaNombreComercial = new String[] {""} ;
      BC000N6_A276SedeDireccion = new String[] {""} ;
      BC000N6_A277SedeCorreo = new String[] {""} ;
      BC000N6_A278SedeEstado = new String[] {""} ;
      BC000N6_A279SedeTipo = new String[] {""} ;
      BC000N6_A280SedeSector = new String[] {""} ;
      BC000N6_A186UbigeoDepartamento = new String[] {""} ;
      BC000N6_A187UbigeoProvincia = new String[] {""} ;
      BC000N6_A188UbigeoDistrito = new String[] {""} ;
      BC000N6_A28ClinicaId = new short[1] ;
      BC000N6_A44UbigeoCode = new String[] {""} ;
      BC000N7_A118ClinicaRUC = new long[1] ;
      BC000N7_A116ClinicaNombreComercial = new String[] {""} ;
      BC000N8_A186UbigeoDepartamento = new String[] {""} ;
      BC000N8_A187UbigeoProvincia = new String[] {""} ;
      BC000N8_A188UbigeoDistrito = new String[] {""} ;
      BC000N9_A30SedeId = new short[1] ;
      BC000N10_A30SedeId = new short[1] ;
      BC000N10_A75SedeNombre = new String[] {""} ;
      BC000N10_A276SedeDireccion = new String[] {""} ;
      BC000N10_A277SedeCorreo = new String[] {""} ;
      BC000N10_A278SedeEstado = new String[] {""} ;
      BC000N10_A279SedeTipo = new String[] {""} ;
      BC000N10_A280SedeSector = new String[] {""} ;
      BC000N10_A28ClinicaId = new short[1] ;
      BC000N10_A44UbigeoCode = new String[] {""} ;
      sMode44 = "" ;
      BC000N11_A30SedeId = new short[1] ;
      BC000N11_A75SedeNombre = new String[] {""} ;
      BC000N11_A276SedeDireccion = new String[] {""} ;
      BC000N11_A277SedeCorreo = new String[] {""} ;
      BC000N11_A278SedeEstado = new String[] {""} ;
      BC000N11_A279SedeTipo = new String[] {""} ;
      BC000N11_A280SedeSector = new String[] {""} ;
      BC000N11_A28ClinicaId = new short[1] ;
      BC000N11_A44UbigeoCode = new String[] {""} ;
      BC000N12_A30SedeId = new short[1] ;
      BC000N15_A118ClinicaRUC = new long[1] ;
      BC000N15_A116ClinicaNombreComercial = new String[] {""} ;
      BC000N16_A186UbigeoDepartamento = new String[] {""} ;
      BC000N16_A187UbigeoProvincia = new String[] {""} ;
      BC000N16_A188UbigeoDistrito = new String[] {""} ;
      BC000N17_A32EspecialidadId = new short[1] ;
      BC000N17_A38SGEspecialidadSedeId = new short[1] ;
      BC000N18_A34DisponibilidadId = new int[1] ;
      BC000N19_A29ConfComisionId = new short[1] ;
      BC000N20_A31ProfesionalId = new int[1] ;
      BC000N20_A32EspecialidadId = new short[1] ;
      BC000N20_A30SedeId = new short[1] ;
      BC000N20_A54SedeTipoConsulta = new String[] {""} ;
      BC000N21_A30SedeId = new short[1] ;
      BC000N21_A75SedeNombre = new String[] {""} ;
      BC000N21_A118ClinicaRUC = new long[1] ;
      BC000N21_A116ClinicaNombreComercial = new String[] {""} ;
      BC000N21_A276SedeDireccion = new String[] {""} ;
      BC000N21_A277SedeCorreo = new String[] {""} ;
      BC000N21_A278SedeEstado = new String[] {""} ;
      BC000N21_A279SedeTipo = new String[] {""} ;
      BC000N21_A280SedeSector = new String[] {""} ;
      BC000N21_A186UbigeoDepartamento = new String[] {""} ;
      BC000N21_A187UbigeoProvincia = new String[] {""} ;
      BC000N21_A188UbigeoDistrito = new String[] {""} ;
      BC000N21_A28ClinicaId = new short[1] ;
      BC000N21_A44UbigeoCode = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.sede_bc__default(),
         new Object[] {
             new Object[] {
            BC000N2_A30SedeId, BC000N2_A75SedeNombre, BC000N2_A276SedeDireccion, BC000N2_A277SedeCorreo, BC000N2_A278SedeEstado, BC000N2_A279SedeTipo, BC000N2_A280SedeSector, BC000N2_A28ClinicaId, BC000N2_A44UbigeoCode
            }
            , new Object[] {
            BC000N3_A30SedeId, BC000N3_A75SedeNombre, BC000N3_A276SedeDireccion, BC000N3_A277SedeCorreo, BC000N3_A278SedeEstado, BC000N3_A279SedeTipo, BC000N3_A280SedeSector, BC000N3_A28ClinicaId, BC000N3_A44UbigeoCode
            }
            , new Object[] {
            BC000N4_A118ClinicaRUC, BC000N4_A116ClinicaNombreComercial
            }
            , new Object[] {
            BC000N5_A186UbigeoDepartamento, BC000N5_A187UbigeoProvincia, BC000N5_A188UbigeoDistrito
            }
            , new Object[] {
            BC000N6_A30SedeId, BC000N6_A75SedeNombre, BC000N6_A118ClinicaRUC, BC000N6_A116ClinicaNombreComercial, BC000N6_A276SedeDireccion, BC000N6_A277SedeCorreo, BC000N6_A278SedeEstado, BC000N6_A279SedeTipo, BC000N6_A280SedeSector, BC000N6_A186UbigeoDepartamento,
            BC000N6_A187UbigeoProvincia, BC000N6_A188UbigeoDistrito, BC000N6_A28ClinicaId, BC000N6_A44UbigeoCode
            }
            , new Object[] {
            BC000N7_A118ClinicaRUC, BC000N7_A116ClinicaNombreComercial
            }
            , new Object[] {
            BC000N8_A186UbigeoDepartamento, BC000N8_A187UbigeoProvincia, BC000N8_A188UbigeoDistrito
            }
            , new Object[] {
            BC000N9_A30SedeId
            }
            , new Object[] {
            BC000N10_A30SedeId, BC000N10_A75SedeNombre, BC000N10_A276SedeDireccion, BC000N10_A277SedeCorreo, BC000N10_A278SedeEstado, BC000N10_A279SedeTipo, BC000N10_A280SedeSector, BC000N10_A28ClinicaId, BC000N10_A44UbigeoCode
            }
            , new Object[] {
            BC000N11_A30SedeId, BC000N11_A75SedeNombre, BC000N11_A276SedeDireccion, BC000N11_A277SedeCorreo, BC000N11_A278SedeEstado, BC000N11_A279SedeTipo, BC000N11_A280SedeSector, BC000N11_A28ClinicaId, BC000N11_A44UbigeoCode
            }
            , new Object[] {
            BC000N12_A30SedeId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000N15_A118ClinicaRUC, BC000N15_A116ClinicaNombreComercial
            }
            , new Object[] {
            BC000N16_A186UbigeoDepartamento, BC000N16_A187UbigeoProvincia, BC000N16_A188UbigeoDistrito
            }
            , new Object[] {
            BC000N17_A32EspecialidadId, BC000N17_A38SGEspecialidadSedeId
            }
            , new Object[] {
            BC000N18_A34DisponibilidadId
            }
            , new Object[] {
            BC000N19_A29ConfComisionId
            }
            , new Object[] {
            BC000N20_A31ProfesionalId, BC000N20_A32EspecialidadId, BC000N20_A30SedeId, BC000N20_A54SedeTipoConsulta
            }
            , new Object[] {
            BC000N21_A30SedeId, BC000N21_A75SedeNombre, BC000N21_A118ClinicaRUC, BC000N21_A116ClinicaNombreComercial, BC000N21_A276SedeDireccion, BC000N21_A277SedeCorreo, BC000N21_A278SedeEstado, BC000N21_A279SedeTipo, BC000N21_A280SedeSector, BC000N21_A186UbigeoDepartamento,
            BC000N21_A187UbigeoProvincia, BC000N21_A188UbigeoDistrito, BC000N21_A28ClinicaId, BC000N21_A44UbigeoCode
            }
         }
      );
      AV28Pgmname = "Sede_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120N2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z30SedeId ;
   private short A30SedeId ;
   private short AV14Insert_ClinicaId ;
   private short Z28ClinicaId ;
   private short A28ClinicaId ;
   private short RcdFound44 ;
   private short nIsDirty_44 ;
   private int trnEnded ;
   private int AV29GXV1 ;
   private int GX_JID ;
   private long Z118ClinicaRUC ;
   private long A118ClinicaRUC ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV28Pgmname ;
   private String AV12Insert_UbigeoCode ;
   private String Z278SedeEstado ;
   private String A278SedeEstado ;
   private String Z279SedeTipo ;
   private String A279SedeTipo ;
   private String Z280SedeSector ;
   private String A280SedeSector ;
   private String Z44UbigeoCode ;
   private String A44UbigeoCode ;
   private String sMode44 ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z75SedeNombre ;
   private String A75SedeNombre ;
   private String Z276SedeDireccion ;
   private String A276SedeDireccion ;
   private String Z277SedeCorreo ;
   private String A277SedeCorreo ;
   private String Z185UbigeoNombre ;
   private String A185UbigeoNombre ;
   private String Z116ClinicaNombreComercial ;
   private String A116ClinicaNombreComercial ;
   private String Z186UbigeoDepartamento ;
   private String A186UbigeoDepartamento ;
   private String Z187UbigeoProvincia ;
   private String A187UbigeoProvincia ;
   private String Z188UbigeoDistrito ;
   private String A188UbigeoDistrito ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtSede bcSede ;
   private IDataStoreProvider pr_default ;
   private short[] BC000N6_A30SedeId ;
   private String[] BC000N6_A75SedeNombre ;
   private long[] BC000N6_A118ClinicaRUC ;
   private String[] BC000N6_A116ClinicaNombreComercial ;
   private String[] BC000N6_A276SedeDireccion ;
   private String[] BC000N6_A277SedeCorreo ;
   private String[] BC000N6_A278SedeEstado ;
   private String[] BC000N6_A279SedeTipo ;
   private String[] BC000N6_A280SedeSector ;
   private String[] BC000N6_A186UbigeoDepartamento ;
   private String[] BC000N6_A187UbigeoProvincia ;
   private String[] BC000N6_A188UbigeoDistrito ;
   private short[] BC000N6_A28ClinicaId ;
   private String[] BC000N6_A44UbigeoCode ;
   private long[] BC000N7_A118ClinicaRUC ;
   private String[] BC000N7_A116ClinicaNombreComercial ;
   private String[] BC000N8_A186UbigeoDepartamento ;
   private String[] BC000N8_A187UbigeoProvincia ;
   private String[] BC000N8_A188UbigeoDistrito ;
   private short[] BC000N9_A30SedeId ;
   private short[] BC000N10_A30SedeId ;
   private String[] BC000N10_A75SedeNombre ;
   private String[] BC000N10_A276SedeDireccion ;
   private String[] BC000N10_A277SedeCorreo ;
   private String[] BC000N10_A278SedeEstado ;
   private String[] BC000N10_A279SedeTipo ;
   private String[] BC000N10_A280SedeSector ;
   private short[] BC000N10_A28ClinicaId ;
   private String[] BC000N10_A44UbigeoCode ;
   private short[] BC000N11_A30SedeId ;
   private String[] BC000N11_A75SedeNombre ;
   private String[] BC000N11_A276SedeDireccion ;
   private String[] BC000N11_A277SedeCorreo ;
   private String[] BC000N11_A278SedeEstado ;
   private String[] BC000N11_A279SedeTipo ;
   private String[] BC000N11_A280SedeSector ;
   private short[] BC000N11_A28ClinicaId ;
   private String[] BC000N11_A44UbigeoCode ;
   private short[] BC000N12_A30SedeId ;
   private long[] BC000N15_A118ClinicaRUC ;
   private String[] BC000N15_A116ClinicaNombreComercial ;
   private String[] BC000N16_A186UbigeoDepartamento ;
   private String[] BC000N16_A187UbigeoProvincia ;
   private String[] BC000N16_A188UbigeoDistrito ;
   private short[] BC000N17_A32EspecialidadId ;
   private short[] BC000N17_A38SGEspecialidadSedeId ;
   private int[] BC000N18_A34DisponibilidadId ;
   private short[] BC000N19_A29ConfComisionId ;
   private int[] BC000N20_A31ProfesionalId ;
   private short[] BC000N20_A32EspecialidadId ;
   private short[] BC000N20_A30SedeId ;
   private String[] BC000N20_A54SedeTipoConsulta ;
   private short[] BC000N21_A30SedeId ;
   private String[] BC000N21_A75SedeNombre ;
   private long[] BC000N21_A118ClinicaRUC ;
   private String[] BC000N21_A116ClinicaNombreComercial ;
   private String[] BC000N21_A276SedeDireccion ;
   private String[] BC000N21_A277SedeCorreo ;
   private String[] BC000N21_A278SedeEstado ;
   private String[] BC000N21_A279SedeTipo ;
   private String[] BC000N21_A280SedeSector ;
   private String[] BC000N21_A186UbigeoDepartamento ;
   private String[] BC000N21_A187UbigeoProvincia ;
   private String[] BC000N21_A188UbigeoDistrito ;
   private short[] BC000N21_A28ClinicaId ;
   private String[] BC000N21_A44UbigeoCode ;
   private short[] BC000N2_A30SedeId ;
   private String[] BC000N2_A75SedeNombre ;
   private String[] BC000N2_A276SedeDireccion ;
   private String[] BC000N2_A277SedeCorreo ;
   private String[] BC000N2_A278SedeEstado ;
   private String[] BC000N2_A279SedeTipo ;
   private String[] BC000N2_A280SedeSector ;
   private short[] BC000N2_A28ClinicaId ;
   private String[] BC000N2_A44UbigeoCode ;
   private short[] BC000N3_A30SedeId ;
   private String[] BC000N3_A75SedeNombre ;
   private String[] BC000N3_A276SedeDireccion ;
   private String[] BC000N3_A277SedeCorreo ;
   private String[] BC000N3_A278SedeEstado ;
   private String[] BC000N3_A279SedeTipo ;
   private String[] BC000N3_A280SedeSector ;
   private short[] BC000N3_A28ClinicaId ;
   private String[] BC000N3_A44UbigeoCode ;
   private long[] BC000N4_A118ClinicaRUC ;
   private String[] BC000N4_A116ClinicaNombreComercial ;
   private String[] BC000N5_A186UbigeoDepartamento ;
   private String[] BC000N5_A187UbigeoProvincia ;
   private String[] BC000N5_A188UbigeoDistrito ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class sede_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000N2", "SELECT [SedeId], [SedeNombre], [SedeDireccion], [SedeCorreo], [SedeEstado], [SedeTipo], [SedeSector], [ClinicaId], [UbigeoCode] FROM [Sede] WITH (UPDLOCK) WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N3", "SELECT [SedeId], [SedeNombre], [SedeDireccion], [SedeCorreo], [SedeEstado], [SedeTipo], [SedeSector], [ClinicaId], [UbigeoCode] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N4", "SELECT [ClinicaRUC], [ClinicaNombreComercial] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N5", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N6", "SELECT TM1.[SedeId], TM1.[SedeNombre], T2.[ClinicaRUC], T2.[ClinicaNombreComercial], TM1.[SedeDireccion], TM1.[SedeCorreo], TM1.[SedeEstado], TM1.[SedeTipo], TM1.[SedeSector], T3.[UbigeoDepartamento], T3.[UbigeoProvincia], T3.[UbigeoDistrito], TM1.[ClinicaId], TM1.[UbigeoCode] FROM (([Sede] TM1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = TM1.[ClinicaId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = TM1.[UbigeoCode]) WHERE TM1.[SedeId] = ? ORDER BY TM1.[SedeId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N7", "SELECT [ClinicaRUC], [ClinicaNombreComercial] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N8", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N9", "SELECT [SedeId] FROM [Sede] WHERE [SedeId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N10", "SELECT [SedeId], [SedeNombre], [SedeDireccion], [SedeCorreo], [SedeEstado], [SedeTipo], [SedeSector], [ClinicaId], [UbigeoCode] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N11", "SELECT [SedeId], [SedeNombre], [SedeDireccion], [SedeCorreo], [SedeEstado], [SedeTipo], [SedeSector], [ClinicaId], [UbigeoCode] FROM [Sede] WITH (UPDLOCK) WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N12", "INSERT INTO [Sede]([SedeNombre], [SedeDireccion], [SedeCorreo], [SedeEstado], [SedeTipo], [SedeSector], [ClinicaId], [UbigeoCode]) VALUES(?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000N13", "UPDATE [Sede] SET [SedeNombre]=?, [SedeDireccion]=?, [SedeCorreo]=?, [SedeEstado]=?, [SedeTipo]=?, [SedeSector]=?, [ClinicaId]=?, [UbigeoCode]=?  WHERE [SedeId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000N14", "DELETE FROM [Sede]  WHERE [SedeId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000N15", "SELECT [ClinicaRUC], [ClinicaNombreComercial] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N16", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000N17", "SELECT TOP 1 [EspecialidadId], [SGEspecialidadSedeId] FROM [EspecialidadSede] WHERE [SGEspecialidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000N18", "SELECT TOP 1 [DisponibilidadId] FROM [Disponibilidad] WHERE [SGSedeDisponibilidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000N19", "SELECT TOP 1 [ConfComisionId] FROM [ConfComision] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000N20", "SELECT TOP 1 [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] FROM [ProfesionalEspecialidadSede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000N21", "SELECT TM1.[SedeId], TM1.[SedeNombre], T2.[ClinicaRUC], T2.[ClinicaNombreComercial], TM1.[SedeDireccion], TM1.[SedeCorreo], TM1.[SedeEstado], TM1.[SedeTipo], TM1.[SedeSector], T3.[UbigeoDepartamento], T3.[UbigeoProvincia], T3.[UbigeoDistrito], TM1.[ClinicaId], TM1.[UbigeoCode] FROM (([Sede] TM1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = TM1.[ClinicaId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = TM1.[UbigeoCode]) WHERE TM1.[SedeId] = ? ORDER BY TM1.[SedeId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 10);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 10);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

