package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class recetamedica_bc extends GXWebPanel implements IGxSilentTrn
{
   public recetamedica_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public recetamedica_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recetamedica_bc.class ));
   }

   public recetamedica_bc( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0Y43( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0Y43( ) ;
      standaloneModal( ) ;
      addRow0Y43( ) ;
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
         e110Y2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z50RecetaMedicaId = A50RecetaMedicaId ;
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

   public void confirm_0Y0( )
   {
      beforeValidate0Y43( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Y43( ) ;
         }
         else
         {
            checkExtendedTable0Y43( ) ;
            if ( AnyError == 0 )
            {
               zm0Y43( 4) ;
               zm0Y43( 5) ;
            }
            closeExtendedTableCursors0Y43( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120Y2( )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Insert", GXv_boolean3) ;
         recetamedica_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Update", GXv_boolean3) ;
         recetamedica_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Delete", GXv_boolean3) ;
         recetamedica_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV24Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV25GXV1 = 1 ;
         while ( AV25GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV25GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CitaId") == 0 )
            {
               AV12Insert_CitaId = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MedicamentoId") == 0 )
            {
               AV13Insert_MedicamentoId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV25GXV1 = (int)(AV25GXV1+1) ;
         }
      }
   }

   public void e110Y2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0Y43( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z268RecetaMedicaConcentracion = A268RecetaMedicaConcentracion ;
         Z269RecetaMedicaCantidad = A269RecetaMedicaCantidad ;
         Z273RecetaMedicaAtencion = A273RecetaMedicaAtencion ;
         Z272RecetaMedicaFlag = A272RecetaMedicaFlag ;
         Z332RecetaIndicaciones = A332RecetaIndicaciones ;
         Z19CitaId = A19CitaId ;
         Z42MedicamentoId = A42MedicamentoId ;
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z229MedicamentoCodigo = A229MedicamentoCodigo ;
         Z230MedicamentoNombre = A230MedicamentoNombre ;
         Z231MedicamentoFormaFarm = A231MedicamentoFormaFarm ;
      }
      if ( GX_JID == -3 )
      {
         Z50RecetaMedicaId = A50RecetaMedicaId ;
         Z268RecetaMedicaConcentracion = A268RecetaMedicaConcentracion ;
         Z269RecetaMedicaCantidad = A269RecetaMedicaCantidad ;
         Z273RecetaMedicaAtencion = A273RecetaMedicaAtencion ;
         Z270RecetaMedicaArchivo = A270RecetaMedicaArchivo ;
         Z272RecetaMedicaFlag = A272RecetaMedicaFlag ;
         Z332RecetaIndicaciones = A332RecetaIndicaciones ;
         Z271RecetaArchivoTipo = A271RecetaArchivoTipo ;
         Z267RecetaMedicaNombreArchivo = A267RecetaMedicaNombreArchivo ;
         Z19CitaId = A19CitaId ;
         Z42MedicamentoId = A42MedicamentoId ;
         Z229MedicamentoCodigo = A229MedicamentoCodigo ;
         Z230MedicamentoNombre = A230MedicamentoNombre ;
         Z231MedicamentoFormaFarm = A231MedicamentoFormaFarm ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0Y43( )
   {
      /* Using cursor BC000Y6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A50RecetaMedicaId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A229MedicamentoCodigo = BC000Y6_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = BC000Y6_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = BC000Y6_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = BC000Y6_n231MedicamentoFormaFarm[0] ;
         A268RecetaMedicaConcentracion = BC000Y6_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = BC000Y6_n268RecetaMedicaConcentracion[0] ;
         A269RecetaMedicaCantidad = BC000Y6_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = BC000Y6_n269RecetaMedicaCantidad[0] ;
         A273RecetaMedicaAtencion = BC000Y6_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = BC000Y6_n273RecetaMedicaAtencion[0] ;
         A270RecetaMedicaArchivo = BC000Y6_A270RecetaMedicaArchivo[0] ;
         n270RecetaMedicaArchivo = BC000Y6_n270RecetaMedicaArchivo[0] ;
         A272RecetaMedicaFlag = BC000Y6_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = BC000Y6_n272RecetaMedicaFlag[0] ;
         A332RecetaIndicaciones = BC000Y6_A332RecetaIndicaciones[0] ;
         A271RecetaArchivoTipo = BC000Y6_A271RecetaArchivoTipo[0] ;
         A270RecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         A267RecetaMedicaNombreArchivo = BC000Y6_A267RecetaMedicaNombreArchivo[0] ;
         n267RecetaMedicaNombreArchivo = BC000Y6_n267RecetaMedicaNombreArchivo[0] ;
         A270RecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         A19CitaId = BC000Y6_A19CitaId[0] ;
         A42MedicamentoId = BC000Y6_A42MedicamentoId[0] ;
         n42MedicamentoId = BC000Y6_n42MedicamentoId[0] ;
         zm0Y43( -3) ;
      }
      pr_default.close(4);
      onLoadActions0Y43( ) ;
   }

   public void onLoadActions0Y43( )
   {
      AV24Pgmname = "RecetaMedica_BC" ;
   }

   public void checkExtendedTable0Y43( )
   {
      nIsDirty_43 = (short)(0) ;
      standaloneModal( ) ;
      AV24Pgmname = "RecetaMedica_BC" ;
      /* Using cursor BC000Y7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC000Y8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A42MedicamentoId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Medicamento'.", "ForeignKeyNotFound", 1, "MEDICAMENTOID");
            AnyError = (short)(1) ;
         }
      }
      A229MedicamentoCodigo = BC000Y8_A229MedicamentoCodigo[0] ;
      A230MedicamentoNombre = BC000Y8_A230MedicamentoNombre[0] ;
      A231MedicamentoFormaFarm = BC000Y8_A231MedicamentoFormaFarm[0] ;
      n231MedicamentoFormaFarm = BC000Y8_n231MedicamentoFormaFarm[0] ;
      pr_default.close(6);
   }

   public void closeExtendedTableCursors0Y43( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey0Y43( )
   {
      /* Using cursor BC000Y9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A50RecetaMedicaId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound43 = (short)(1) ;
      }
      else
      {
         RcdFound43 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000Y10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A50RecetaMedicaId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0Y43( 3) ;
         RcdFound43 = (short)(1) ;
         A50RecetaMedicaId = BC000Y10_A50RecetaMedicaId[0] ;
         A268RecetaMedicaConcentracion = BC000Y10_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = BC000Y10_n268RecetaMedicaConcentracion[0] ;
         A269RecetaMedicaCantidad = BC000Y10_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = BC000Y10_n269RecetaMedicaCantidad[0] ;
         A273RecetaMedicaAtencion = BC000Y10_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = BC000Y10_n273RecetaMedicaAtencion[0] ;
         A270RecetaMedicaArchivo = BC000Y10_A270RecetaMedicaArchivo[0] ;
         n270RecetaMedicaArchivo = BC000Y10_n270RecetaMedicaArchivo[0] ;
         A272RecetaMedicaFlag = BC000Y10_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = BC000Y10_n272RecetaMedicaFlag[0] ;
         A332RecetaIndicaciones = BC000Y10_A332RecetaIndicaciones[0] ;
         A271RecetaArchivoTipo = BC000Y10_A271RecetaArchivoTipo[0] ;
         A270RecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         A267RecetaMedicaNombreArchivo = BC000Y10_A267RecetaMedicaNombreArchivo[0] ;
         n267RecetaMedicaNombreArchivo = BC000Y10_n267RecetaMedicaNombreArchivo[0] ;
         A270RecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         A19CitaId = BC000Y10_A19CitaId[0] ;
         A42MedicamentoId = BC000Y10_A42MedicamentoId[0] ;
         n42MedicamentoId = BC000Y10_n42MedicamentoId[0] ;
         Z50RecetaMedicaId = A50RecetaMedicaId ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0Y43( ) ;
         if ( AnyError == 1 )
         {
            RcdFound43 = (short)(0) ;
            initializeNonKey0Y43( ) ;
         }
         Gx_mode = sMode43 ;
      }
      else
      {
         RcdFound43 = (short)(0) ;
         initializeNonKey0Y43( ) ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode43 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0Y43( ) ;
      if ( RcdFound43 == 0 )
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
      confirm_0Y0( ) ;
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

   public void checkOptimisticConcurrency0Y43( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000Y11 */
         pr_default.execute(9, new Object[] {Short.valueOf(A50RecetaMedicaId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RecetaMedica"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z268RecetaMedicaConcentracion, BC000Y11_A268RecetaMedicaConcentracion[0]) != 0 ) || ( Z269RecetaMedicaCantidad != BC000Y11_A269RecetaMedicaCantidad[0] ) || ( GXutil.strcmp(Z273RecetaMedicaAtencion, BC000Y11_A273RecetaMedicaAtencion[0]) != 0 ) || ( Z272RecetaMedicaFlag != BC000Y11_A272RecetaMedicaFlag[0] ) || ( GXutil.strcmp(Z332RecetaIndicaciones, BC000Y11_A332RecetaIndicaciones[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z19CitaId != BC000Y11_A19CitaId[0] ) || ( Z42MedicamentoId != BC000Y11_A42MedicamentoId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"RecetaMedica"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Y43( )
   {
      beforeValidate0Y43( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y43( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Y43( 0) ;
         checkOptimisticConcurrency0Y43( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y43( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Y43( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Y12 */
                  pr_default.execute(10, new Object[] {Boolean.valueOf(n268RecetaMedicaConcentracion), A268RecetaMedicaConcentracion, Boolean.valueOf(n269RecetaMedicaCantidad), Short.valueOf(A269RecetaMedicaCantidad), Boolean.valueOf(n273RecetaMedicaAtencion), A273RecetaMedicaAtencion, Boolean.valueOf(n270RecetaMedicaArchivo), A270RecetaMedicaArchivo, Boolean.valueOf(n272RecetaMedicaFlag), Byte.valueOf(A272RecetaMedicaFlag), A332RecetaIndicaciones, A271RecetaArchivoTipo, Boolean.valueOf(n267RecetaMedicaNombreArchivo), A267RecetaMedicaNombreArchivo, Integer.valueOf(A19CitaId), Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
                  A50RecetaMedicaId = BC000Y12_A50RecetaMedicaId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
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
            load0Y43( ) ;
         }
         endLevel0Y43( ) ;
      }
      closeExtendedTableCursors0Y43( ) ;
   }

   public void update0Y43( )
   {
      beforeValidate0Y43( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y43( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y43( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y43( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Y43( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Y13 */
                  pr_default.execute(11, new Object[] {Boolean.valueOf(n268RecetaMedicaConcentracion), A268RecetaMedicaConcentracion, Boolean.valueOf(n269RecetaMedicaCantidad), Short.valueOf(A269RecetaMedicaCantidad), Boolean.valueOf(n273RecetaMedicaAtencion), A273RecetaMedicaAtencion, Boolean.valueOf(n272RecetaMedicaFlag), Byte.valueOf(A272RecetaMedicaFlag), A332RecetaIndicaciones, A271RecetaArchivoTipo, Boolean.valueOf(n267RecetaMedicaNombreArchivo), A267RecetaMedicaNombreArchivo, Integer.valueOf(A19CitaId), Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId), Short.valueOf(A50RecetaMedicaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RecetaMedica"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Y43( ) ;
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
         endLevel0Y43( ) ;
      }
      closeExtendedTableCursors0Y43( ) ;
   }

   public void deferredUpdate0Y43( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000Y14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n270RecetaMedicaArchivo), A270RecetaMedicaArchivo, Short.valueOf(A50RecetaMedicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0Y43( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y43( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Y43( ) ;
         afterConfirm0Y43( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Y43( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000Y15 */
               pr_default.execute(13, new Object[] {Short.valueOf(A50RecetaMedicaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
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
      sMode43 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0Y43( ) ;
      Gx_mode = sMode43 ;
   }

   public void onDeleteControls0Y43( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV24Pgmname = "RecetaMedica_BC" ;
         /* Using cursor BC000Y16 */
         pr_default.execute(14, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
         A229MedicamentoCodigo = BC000Y16_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = BC000Y16_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = BC000Y16_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = BC000Y16_n231MedicamentoFormaFarm[0] ;
         pr_default.close(14);
      }
   }

   public void endLevel0Y43( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Y43( ) ;
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

   public void scanKeyStart0Y43( )
   {
      /* Scan By routine */
      /* Using cursor BC000Y17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A50RecetaMedicaId)});
      RcdFound43 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A50RecetaMedicaId = BC000Y17_A50RecetaMedicaId[0] ;
         A229MedicamentoCodigo = BC000Y17_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = BC000Y17_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = BC000Y17_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = BC000Y17_n231MedicamentoFormaFarm[0] ;
         A268RecetaMedicaConcentracion = BC000Y17_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = BC000Y17_n268RecetaMedicaConcentracion[0] ;
         A269RecetaMedicaCantidad = BC000Y17_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = BC000Y17_n269RecetaMedicaCantidad[0] ;
         A273RecetaMedicaAtencion = BC000Y17_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = BC000Y17_n273RecetaMedicaAtencion[0] ;
         A270RecetaMedicaArchivo = BC000Y17_A270RecetaMedicaArchivo[0] ;
         n270RecetaMedicaArchivo = BC000Y17_n270RecetaMedicaArchivo[0] ;
         A272RecetaMedicaFlag = BC000Y17_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = BC000Y17_n272RecetaMedicaFlag[0] ;
         A332RecetaIndicaciones = BC000Y17_A332RecetaIndicaciones[0] ;
         A271RecetaArchivoTipo = BC000Y17_A271RecetaArchivoTipo[0] ;
         A270RecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         A267RecetaMedicaNombreArchivo = BC000Y17_A267RecetaMedicaNombreArchivo[0] ;
         n267RecetaMedicaNombreArchivo = BC000Y17_n267RecetaMedicaNombreArchivo[0] ;
         A270RecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         A19CitaId = BC000Y17_A19CitaId[0] ;
         A42MedicamentoId = BC000Y17_A42MedicamentoId[0] ;
         n42MedicamentoId = BC000Y17_n42MedicamentoId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0Y43( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound43 = (short)(0) ;
      scanKeyLoad0Y43( ) ;
   }

   public void scanKeyLoad0Y43( )
   {
      sMode43 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A50RecetaMedicaId = BC000Y17_A50RecetaMedicaId[0] ;
         A229MedicamentoCodigo = BC000Y17_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = BC000Y17_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = BC000Y17_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = BC000Y17_n231MedicamentoFormaFarm[0] ;
         A268RecetaMedicaConcentracion = BC000Y17_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = BC000Y17_n268RecetaMedicaConcentracion[0] ;
         A269RecetaMedicaCantidad = BC000Y17_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = BC000Y17_n269RecetaMedicaCantidad[0] ;
         A273RecetaMedicaAtencion = BC000Y17_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = BC000Y17_n273RecetaMedicaAtencion[0] ;
         A270RecetaMedicaArchivo = BC000Y17_A270RecetaMedicaArchivo[0] ;
         n270RecetaMedicaArchivo = BC000Y17_n270RecetaMedicaArchivo[0] ;
         A272RecetaMedicaFlag = BC000Y17_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = BC000Y17_n272RecetaMedicaFlag[0] ;
         A332RecetaIndicaciones = BC000Y17_A332RecetaIndicaciones[0] ;
         A271RecetaArchivoTipo = BC000Y17_A271RecetaArchivoTipo[0] ;
         A270RecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         A267RecetaMedicaNombreArchivo = BC000Y17_A267RecetaMedicaNombreArchivo[0] ;
         n267RecetaMedicaNombreArchivo = BC000Y17_n267RecetaMedicaNombreArchivo[0] ;
         A270RecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         A19CitaId = BC000Y17_A19CitaId[0] ;
         A42MedicamentoId = BC000Y17_A42MedicamentoId[0] ;
         n42MedicamentoId = BC000Y17_n42MedicamentoId[0] ;
      }
      Gx_mode = sMode43 ;
   }

   public void scanKeyEnd0Y43( )
   {
      pr_default.close(15);
   }

   public void afterConfirm0Y43( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Y43( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Y43( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Y43( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Y43( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Y43( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Y43( )
   {
   }

   public void send_integrity_lvl_hashes0Y43( )
   {
   }

   public void addRow0Y43( )
   {
      VarsToRow43( bcRecetaMedica) ;
   }

   public void readRow0Y43( )
   {
      RowToVars43( bcRecetaMedica, 1) ;
   }

   public void initializeNonKey0Y43( )
   {
      A19CitaId = 0 ;
      A42MedicamentoId = (short)(0) ;
      n42MedicamentoId = false ;
      A229MedicamentoCodigo = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      n231MedicamentoFormaFarm = false ;
      A268RecetaMedicaConcentracion = "" ;
      n268RecetaMedicaConcentracion = false ;
      A269RecetaMedicaCantidad = (short)(0) ;
      n269RecetaMedicaCantidad = false ;
      A273RecetaMedicaAtencion = "" ;
      n273RecetaMedicaAtencion = false ;
      A270RecetaMedicaArchivo = "" ;
      n270RecetaMedicaArchivo = false ;
      A272RecetaMedicaFlag = (byte)(0) ;
      n272RecetaMedicaFlag = false ;
      A332RecetaIndicaciones = "" ;
      A271RecetaArchivoTipo = "" ;
      A267RecetaMedicaNombreArchivo = "" ;
      n267RecetaMedicaNombreArchivo = false ;
      Z268RecetaMedicaConcentracion = "" ;
      Z269RecetaMedicaCantidad = (short)(0) ;
      Z273RecetaMedicaAtencion = "" ;
      Z272RecetaMedicaFlag = (byte)(0) ;
      Z332RecetaIndicaciones = "" ;
      Z19CitaId = 0 ;
      Z42MedicamentoId = (short)(0) ;
   }

   public void initAll0Y43( )
   {
      A50RecetaMedicaId = (short)(0) ;
      initializeNonKey0Y43( ) ;
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

   public void VarsToRow43( com.projectthani.SdtRecetaMedica obj43 )
   {
      obj43.setgxTv_SdtRecetaMedica_Mode( Gx_mode );
      obj43.setgxTv_SdtRecetaMedica_Citaid( A19CitaId );
      obj43.setgxTv_SdtRecetaMedica_Medicamentoid( A42MedicamentoId );
      obj43.setgxTv_SdtRecetaMedica_Medicamentocodigo( A229MedicamentoCodigo );
      obj43.setgxTv_SdtRecetaMedica_Medicamentonombre( A230MedicamentoNombre );
      obj43.setgxTv_SdtRecetaMedica_Medicamentoformafarm( A231MedicamentoFormaFarm );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaconcentracion( A268RecetaMedicaConcentracion );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicacantidad( A269RecetaMedicaCantidad );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaatencion( A273RecetaMedicaAtencion );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaarchivo( A270RecetaMedicaArchivo );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaflag( A272RecetaMedicaFlag );
      obj43.setgxTv_SdtRecetaMedica_Recetaindicaciones( A332RecetaIndicaciones );
      obj43.setgxTv_SdtRecetaMedica_Recetaarchivotipo( A271RecetaArchivoTipo );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo( A267RecetaMedicaNombreArchivo );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaid( A50RecetaMedicaId );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaid_Z( Z50RecetaMedicaId );
      obj43.setgxTv_SdtRecetaMedica_Citaid_Z( Z19CitaId );
      obj43.setgxTv_SdtRecetaMedica_Medicamentoid_Z( Z42MedicamentoId );
      obj43.setgxTv_SdtRecetaMedica_Medicamentocodigo_Z( Z229MedicamentoCodigo );
      obj43.setgxTv_SdtRecetaMedica_Medicamentonombre_Z( Z230MedicamentoNombre );
      obj43.setgxTv_SdtRecetaMedica_Medicamentoformafarm_Z( Z231MedicamentoFormaFarm );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z( Z268RecetaMedicaConcentracion );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicacantidad_Z( Z269RecetaMedicaCantidad );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaatencion_Z( Z273RecetaMedicaAtencion );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z( Z267RecetaMedicaNombreArchivo );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaflag_Z( Z272RecetaMedicaFlag );
      obj43.setgxTv_SdtRecetaMedica_Recetaindicaciones_Z( Z332RecetaIndicaciones );
      obj43.setgxTv_SdtRecetaMedica_Recetaarchivotipo_Z( Z271RecetaArchivoTipo );
      obj43.setgxTv_SdtRecetaMedica_Medicamentoid_N( (byte)((byte)((n42MedicamentoId)?1:0)) );
      obj43.setgxTv_SdtRecetaMedica_Medicamentoformafarm_N( (byte)((byte)((n231MedicamentoFormaFarm)?1:0)) );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaconcentracion_N( (byte)((byte)((n268RecetaMedicaConcentracion)?1:0)) );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicacantidad_N( (byte)((byte)((n269RecetaMedicaCantidad)?1:0)) );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaatencion_N( (byte)((byte)((n273RecetaMedicaAtencion)?1:0)) );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaarchivo_N( (byte)((byte)((n270RecetaMedicaArchivo)?1:0)) );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N( (byte)((byte)((n267RecetaMedicaNombreArchivo)?1:0)) );
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaflag_N( (byte)((byte)((n272RecetaMedicaFlag)?1:0)) );
      obj43.setgxTv_SdtRecetaMedica_Mode( Gx_mode );
   }

   public void KeyVarsToRow43( com.projectthani.SdtRecetaMedica obj43 )
   {
      obj43.setgxTv_SdtRecetaMedica_Recetamedicaid( A50RecetaMedicaId );
   }

   public void RowToVars43( com.projectthani.SdtRecetaMedica obj43 ,
                            int forceLoad )
   {
      Gx_mode = obj43.getgxTv_SdtRecetaMedica_Mode() ;
      A19CitaId = obj43.getgxTv_SdtRecetaMedica_Citaid() ;
      A42MedicamentoId = obj43.getgxTv_SdtRecetaMedica_Medicamentoid() ;
      n42MedicamentoId = false ;
      A229MedicamentoCodigo = obj43.getgxTv_SdtRecetaMedica_Medicamentocodigo() ;
      A230MedicamentoNombre = obj43.getgxTv_SdtRecetaMedica_Medicamentonombre() ;
      A231MedicamentoFormaFarm = obj43.getgxTv_SdtRecetaMedica_Medicamentoformafarm() ;
      n231MedicamentoFormaFarm = false ;
      A268RecetaMedicaConcentracion = obj43.getgxTv_SdtRecetaMedica_Recetamedicaconcentracion() ;
      n268RecetaMedicaConcentracion = false ;
      A269RecetaMedicaCantidad = obj43.getgxTv_SdtRecetaMedica_Recetamedicacantidad() ;
      n269RecetaMedicaCantidad = false ;
      A273RecetaMedicaAtencion = obj43.getgxTv_SdtRecetaMedica_Recetamedicaatencion() ;
      n273RecetaMedicaAtencion = false ;
      A270RecetaMedicaArchivo = obj43.getgxTv_SdtRecetaMedica_Recetamedicaarchivo() ;
      n270RecetaMedicaArchivo = false ;
      A272RecetaMedicaFlag = obj43.getgxTv_SdtRecetaMedica_Recetamedicaflag() ;
      n272RecetaMedicaFlag = false ;
      A332RecetaIndicaciones = obj43.getgxTv_SdtRecetaMedica_Recetaindicaciones() ;
      A271RecetaArchivoTipo = ((GXutil.strcmp("", obj43.getgxTv_SdtRecetaMedica_Recetaarchivotipo())==0) ? com.genexus.util.GXFile.getgxFileext( A270RecetaMedicaArchivo) : obj43.getgxTv_SdtRecetaMedica_Recetaarchivotipo()) ;
      A267RecetaMedicaNombreArchivo = ((GXutil.strcmp("", obj43.getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo())==0) ? com.genexus.util.GXFile.getgxFilename( A270RecetaMedicaArchivo) : obj43.getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo()) ;
      n267RecetaMedicaNombreArchivo = false ;
      A50RecetaMedicaId = obj43.getgxTv_SdtRecetaMedica_Recetamedicaid() ;
      Z50RecetaMedicaId = obj43.getgxTv_SdtRecetaMedica_Recetamedicaid_Z() ;
      Z19CitaId = obj43.getgxTv_SdtRecetaMedica_Citaid_Z() ;
      Z42MedicamentoId = obj43.getgxTv_SdtRecetaMedica_Medicamentoid_Z() ;
      Z229MedicamentoCodigo = obj43.getgxTv_SdtRecetaMedica_Medicamentocodigo_Z() ;
      Z230MedicamentoNombre = obj43.getgxTv_SdtRecetaMedica_Medicamentonombre_Z() ;
      Z231MedicamentoFormaFarm = obj43.getgxTv_SdtRecetaMedica_Medicamentoformafarm_Z() ;
      Z268RecetaMedicaConcentracion = obj43.getgxTv_SdtRecetaMedica_Recetamedicaconcentracion_Z() ;
      Z269RecetaMedicaCantidad = obj43.getgxTv_SdtRecetaMedica_Recetamedicacantidad_Z() ;
      Z273RecetaMedicaAtencion = obj43.getgxTv_SdtRecetaMedica_Recetamedicaatencion_Z() ;
      Z267RecetaMedicaNombreArchivo = obj43.getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_Z() ;
      Z272RecetaMedicaFlag = obj43.getgxTv_SdtRecetaMedica_Recetamedicaflag_Z() ;
      Z332RecetaIndicaciones = obj43.getgxTv_SdtRecetaMedica_Recetaindicaciones_Z() ;
      Z271RecetaArchivoTipo = obj43.getgxTv_SdtRecetaMedica_Recetaarchivotipo_Z() ;
      n42MedicamentoId = (boolean)((obj43.getgxTv_SdtRecetaMedica_Medicamentoid_N()==0)?false:true) ;
      n231MedicamentoFormaFarm = (boolean)((obj43.getgxTv_SdtRecetaMedica_Medicamentoformafarm_N()==0)?false:true) ;
      n268RecetaMedicaConcentracion = (boolean)((obj43.getgxTv_SdtRecetaMedica_Recetamedicaconcentracion_N()==0)?false:true) ;
      n269RecetaMedicaCantidad = (boolean)((obj43.getgxTv_SdtRecetaMedica_Recetamedicacantidad_N()==0)?false:true) ;
      n273RecetaMedicaAtencion = (boolean)((obj43.getgxTv_SdtRecetaMedica_Recetamedicaatencion_N()==0)?false:true) ;
      n270RecetaMedicaArchivo = (boolean)((obj43.getgxTv_SdtRecetaMedica_Recetamedicaarchivo_N()==0)?false:true) ;
      n267RecetaMedicaNombreArchivo = (boolean)((obj43.getgxTv_SdtRecetaMedica_Recetamedicanombrearchivo_N()==0)?false:true) ;
      n272RecetaMedicaFlag = (boolean)((obj43.getgxTv_SdtRecetaMedica_Recetamedicaflag_N()==0)?false:true) ;
      Gx_mode = obj43.getgxTv_SdtRecetaMedica_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A50RecetaMedicaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0Y43( ) ;
      scanKeyStart0Y43( ) ;
      if ( RcdFound43 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z50RecetaMedicaId = A50RecetaMedicaId ;
      }
      zm0Y43( -3) ;
      onLoadActions0Y43( ) ;
      addRow0Y43( ) ;
      scanKeyEnd0Y43( ) ;
      if ( RcdFound43 == 0 )
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
      RowToVars43( bcRecetaMedica, 0) ;
      scanKeyStart0Y43( ) ;
      if ( RcdFound43 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z50RecetaMedicaId = A50RecetaMedicaId ;
      }
      zm0Y43( -3) ;
      onLoadActions0Y43( ) ;
      addRow0Y43( ) ;
      scanKeyEnd0Y43( ) ;
      if ( RcdFound43 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Y43( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0Y43( ) ;
      }
      else
      {
         if ( RcdFound43 == 1 )
         {
            if ( A50RecetaMedicaId != Z50RecetaMedicaId )
            {
               A50RecetaMedicaId = Z50RecetaMedicaId ;
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
               update0Y43( ) ;
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
               if ( A50RecetaMedicaId != Z50RecetaMedicaId )
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
                     insert0Y43( ) ;
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
                     insert0Y43( ) ;
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
      RowToVars43( bcRecetaMedica, 1) ;
      saveImpl( ) ;
      VarsToRow43( bcRecetaMedica) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars43( bcRecetaMedica, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Y43( ) ;
      afterTrn( ) ;
      VarsToRow43( bcRecetaMedica) ;
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
         com.projectthani.SdtRecetaMedica auxBC = new com.projectthani.SdtRecetaMedica( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A50RecetaMedicaId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcRecetaMedica);
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
      RowToVars43( bcRecetaMedica, 1) ;
      updateImpl( ) ;
      VarsToRow43( bcRecetaMedica) ;
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
      RowToVars43( bcRecetaMedica, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Y43( ) ;
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
      VarsToRow43( bcRecetaMedica) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars43( bcRecetaMedica, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0Y43( ) ;
      if ( RcdFound43 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A50RecetaMedicaId != Z50RecetaMedicaId )
         {
            A50RecetaMedicaId = Z50RecetaMedicaId ;
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
         if ( A50RecetaMedicaId != Z50RecetaMedicaId )
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
      pr_default.close(2);
      pr_default.close(14);
      pr_default.close(3);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "recetamedica_bc");
      VarsToRow43( bcRecetaMedica) ;
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
      Gx_mode = bcRecetaMedica.getgxTv_SdtRecetaMedica_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcRecetaMedica.setgxTv_SdtRecetaMedica_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtRecetaMedica sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcRecetaMedica )
      {
         bcRecetaMedica = sdt ;
         if ( GXutil.strcmp(bcRecetaMedica.getgxTv_SdtRecetaMedica_Mode(), "") == 0 )
         {
            bcRecetaMedica.setgxTv_SdtRecetaMedica_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow43( bcRecetaMedica) ;
         }
         else
         {
            RowToVars43( bcRecetaMedica, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcRecetaMedica.getgxTv_SdtRecetaMedica_Mode(), "") == 0 )
         {
            bcRecetaMedica.setgxTv_SdtRecetaMedica_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars43( bcRecetaMedica, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtRecetaMedica getRecetaMedica_BC( )
   {
      return bcRecetaMedica ;
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
      AV24Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z268RecetaMedicaConcentracion = "" ;
      A268RecetaMedicaConcentracion = "" ;
      Z273RecetaMedicaAtencion = "" ;
      A273RecetaMedicaAtencion = "" ;
      Z332RecetaIndicaciones = "" ;
      A332RecetaIndicaciones = "" ;
      Z229MedicamentoCodigo = "" ;
      A229MedicamentoCodigo = "" ;
      Z230MedicamentoNombre = "" ;
      A230MedicamentoNombre = "" ;
      Z231MedicamentoFormaFarm = "" ;
      A231MedicamentoFormaFarm = "" ;
      Z270RecetaMedicaArchivo = "" ;
      A270RecetaMedicaArchivo = "" ;
      Z271RecetaArchivoTipo = "" ;
      A271RecetaArchivoTipo = "" ;
      Z267RecetaMedicaNombreArchivo = "" ;
      A267RecetaMedicaNombreArchivo = "" ;
      BC000Y6_A50RecetaMedicaId = new short[1] ;
      BC000Y6_A229MedicamentoCodigo = new String[] {""} ;
      BC000Y6_A230MedicamentoNombre = new String[] {""} ;
      BC000Y6_A231MedicamentoFormaFarm = new String[] {""} ;
      BC000Y6_n231MedicamentoFormaFarm = new boolean[] {false} ;
      BC000Y6_A268RecetaMedicaConcentracion = new String[] {""} ;
      BC000Y6_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      BC000Y6_A269RecetaMedicaCantidad = new short[1] ;
      BC000Y6_n269RecetaMedicaCantidad = new boolean[] {false} ;
      BC000Y6_A273RecetaMedicaAtencion = new String[] {""} ;
      BC000Y6_n273RecetaMedicaAtencion = new boolean[] {false} ;
      BC000Y6_A270RecetaMedicaArchivo = new String[] {""} ;
      BC000Y6_n270RecetaMedicaArchivo = new boolean[] {false} ;
      BC000Y6_A272RecetaMedicaFlag = new byte[1] ;
      BC000Y6_n272RecetaMedicaFlag = new boolean[] {false} ;
      BC000Y6_A332RecetaIndicaciones = new String[] {""} ;
      BC000Y6_A271RecetaArchivoTipo = new String[] {""} ;
      BC000Y6_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      BC000Y6_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      BC000Y6_A19CitaId = new int[1] ;
      BC000Y6_A42MedicamentoId = new short[1] ;
      BC000Y6_n42MedicamentoId = new boolean[] {false} ;
      A270RecetaMedicaArchivo_Filetype = "" ;
      A270RecetaMedicaArchivo_Filename = "" ;
      BC000Y7_A19CitaId = new int[1] ;
      BC000Y8_A229MedicamentoCodigo = new String[] {""} ;
      BC000Y8_A230MedicamentoNombre = new String[] {""} ;
      BC000Y8_A231MedicamentoFormaFarm = new String[] {""} ;
      BC000Y8_n231MedicamentoFormaFarm = new boolean[] {false} ;
      BC000Y9_A50RecetaMedicaId = new short[1] ;
      BC000Y10_A50RecetaMedicaId = new short[1] ;
      BC000Y10_A268RecetaMedicaConcentracion = new String[] {""} ;
      BC000Y10_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      BC000Y10_A269RecetaMedicaCantidad = new short[1] ;
      BC000Y10_n269RecetaMedicaCantidad = new boolean[] {false} ;
      BC000Y10_A273RecetaMedicaAtencion = new String[] {""} ;
      BC000Y10_n273RecetaMedicaAtencion = new boolean[] {false} ;
      BC000Y10_A270RecetaMedicaArchivo = new String[] {""} ;
      BC000Y10_n270RecetaMedicaArchivo = new boolean[] {false} ;
      BC000Y10_A272RecetaMedicaFlag = new byte[1] ;
      BC000Y10_n272RecetaMedicaFlag = new boolean[] {false} ;
      BC000Y10_A332RecetaIndicaciones = new String[] {""} ;
      BC000Y10_A271RecetaArchivoTipo = new String[] {""} ;
      BC000Y10_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      BC000Y10_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      BC000Y10_A19CitaId = new int[1] ;
      BC000Y10_A42MedicamentoId = new short[1] ;
      BC000Y10_n42MedicamentoId = new boolean[] {false} ;
      sMode43 = "" ;
      BC000Y11_A50RecetaMedicaId = new short[1] ;
      BC000Y11_A268RecetaMedicaConcentracion = new String[] {""} ;
      BC000Y11_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      BC000Y11_A269RecetaMedicaCantidad = new short[1] ;
      BC000Y11_n269RecetaMedicaCantidad = new boolean[] {false} ;
      BC000Y11_A273RecetaMedicaAtencion = new String[] {""} ;
      BC000Y11_n273RecetaMedicaAtencion = new boolean[] {false} ;
      BC000Y11_A270RecetaMedicaArchivo = new String[] {""} ;
      BC000Y11_n270RecetaMedicaArchivo = new boolean[] {false} ;
      BC000Y11_A272RecetaMedicaFlag = new byte[1] ;
      BC000Y11_n272RecetaMedicaFlag = new boolean[] {false} ;
      BC000Y11_A332RecetaIndicaciones = new String[] {""} ;
      BC000Y11_A271RecetaArchivoTipo = new String[] {""} ;
      BC000Y11_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      BC000Y11_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      BC000Y11_A19CitaId = new int[1] ;
      BC000Y11_A42MedicamentoId = new short[1] ;
      BC000Y11_n42MedicamentoId = new boolean[] {false} ;
      BC000Y12_A50RecetaMedicaId = new short[1] ;
      BC000Y16_A229MedicamentoCodigo = new String[] {""} ;
      BC000Y16_A230MedicamentoNombre = new String[] {""} ;
      BC000Y16_A231MedicamentoFormaFarm = new String[] {""} ;
      BC000Y16_n231MedicamentoFormaFarm = new boolean[] {false} ;
      BC000Y17_A50RecetaMedicaId = new short[1] ;
      BC000Y17_A229MedicamentoCodigo = new String[] {""} ;
      BC000Y17_A230MedicamentoNombre = new String[] {""} ;
      BC000Y17_A231MedicamentoFormaFarm = new String[] {""} ;
      BC000Y17_n231MedicamentoFormaFarm = new boolean[] {false} ;
      BC000Y17_A268RecetaMedicaConcentracion = new String[] {""} ;
      BC000Y17_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      BC000Y17_A269RecetaMedicaCantidad = new short[1] ;
      BC000Y17_n269RecetaMedicaCantidad = new boolean[] {false} ;
      BC000Y17_A273RecetaMedicaAtencion = new String[] {""} ;
      BC000Y17_n273RecetaMedicaAtencion = new boolean[] {false} ;
      BC000Y17_A270RecetaMedicaArchivo = new String[] {""} ;
      BC000Y17_n270RecetaMedicaArchivo = new boolean[] {false} ;
      BC000Y17_A272RecetaMedicaFlag = new byte[1] ;
      BC000Y17_n272RecetaMedicaFlag = new boolean[] {false} ;
      BC000Y17_A332RecetaIndicaciones = new String[] {""} ;
      BC000Y17_A271RecetaArchivoTipo = new String[] {""} ;
      BC000Y17_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      BC000Y17_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      BC000Y17_A19CitaId = new int[1] ;
      BC000Y17_A42MedicamentoId = new short[1] ;
      BC000Y17_n42MedicamentoId = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.recetamedica_bc__default(),
         new Object[] {
             new Object[] {
            BC000Y2_A50RecetaMedicaId, BC000Y2_A268RecetaMedicaConcentracion, BC000Y2_n268RecetaMedicaConcentracion, BC000Y2_A269RecetaMedicaCantidad, BC000Y2_n269RecetaMedicaCantidad, BC000Y2_A273RecetaMedicaAtencion, BC000Y2_n273RecetaMedicaAtencion, BC000Y2_A270RecetaMedicaArchivo, BC000Y2_n270RecetaMedicaArchivo, BC000Y2_A272RecetaMedicaFlag,
            BC000Y2_n272RecetaMedicaFlag, BC000Y2_A332RecetaIndicaciones, BC000Y2_A271RecetaArchivoTipo, BC000Y2_A267RecetaMedicaNombreArchivo, BC000Y2_n267RecetaMedicaNombreArchivo, BC000Y2_A19CitaId, BC000Y2_A42MedicamentoId, BC000Y2_n42MedicamentoId
            }
            , new Object[] {
            BC000Y3_A50RecetaMedicaId, BC000Y3_A268RecetaMedicaConcentracion, BC000Y3_n268RecetaMedicaConcentracion, BC000Y3_A269RecetaMedicaCantidad, BC000Y3_n269RecetaMedicaCantidad, BC000Y3_A273RecetaMedicaAtencion, BC000Y3_n273RecetaMedicaAtencion, BC000Y3_A270RecetaMedicaArchivo, BC000Y3_n270RecetaMedicaArchivo, BC000Y3_A272RecetaMedicaFlag,
            BC000Y3_n272RecetaMedicaFlag, BC000Y3_A332RecetaIndicaciones, BC000Y3_A271RecetaArchivoTipo, BC000Y3_A267RecetaMedicaNombreArchivo, BC000Y3_n267RecetaMedicaNombreArchivo, BC000Y3_A19CitaId, BC000Y3_A42MedicamentoId, BC000Y3_n42MedicamentoId
            }
            , new Object[] {
            BC000Y4_A19CitaId
            }
            , new Object[] {
            BC000Y5_A229MedicamentoCodigo, BC000Y5_A230MedicamentoNombre, BC000Y5_A231MedicamentoFormaFarm, BC000Y5_n231MedicamentoFormaFarm
            }
            , new Object[] {
            BC000Y6_A50RecetaMedicaId, BC000Y6_A229MedicamentoCodigo, BC000Y6_A230MedicamentoNombre, BC000Y6_A231MedicamentoFormaFarm, BC000Y6_n231MedicamentoFormaFarm, BC000Y6_A268RecetaMedicaConcentracion, BC000Y6_n268RecetaMedicaConcentracion, BC000Y6_A269RecetaMedicaCantidad, BC000Y6_n269RecetaMedicaCantidad, BC000Y6_A273RecetaMedicaAtencion,
            BC000Y6_n273RecetaMedicaAtencion, BC000Y6_A270RecetaMedicaArchivo, BC000Y6_n270RecetaMedicaArchivo, BC000Y6_A272RecetaMedicaFlag, BC000Y6_n272RecetaMedicaFlag, BC000Y6_A332RecetaIndicaciones, BC000Y6_A271RecetaArchivoTipo, BC000Y6_A267RecetaMedicaNombreArchivo, BC000Y6_n267RecetaMedicaNombreArchivo, BC000Y6_A19CitaId,
            BC000Y6_A42MedicamentoId, BC000Y6_n42MedicamentoId
            }
            , new Object[] {
            BC000Y7_A19CitaId
            }
            , new Object[] {
            BC000Y8_A229MedicamentoCodigo, BC000Y8_A230MedicamentoNombre, BC000Y8_A231MedicamentoFormaFarm, BC000Y8_n231MedicamentoFormaFarm
            }
            , new Object[] {
            BC000Y9_A50RecetaMedicaId
            }
            , new Object[] {
            BC000Y10_A50RecetaMedicaId, BC000Y10_A268RecetaMedicaConcentracion, BC000Y10_n268RecetaMedicaConcentracion, BC000Y10_A269RecetaMedicaCantidad, BC000Y10_n269RecetaMedicaCantidad, BC000Y10_A273RecetaMedicaAtencion, BC000Y10_n273RecetaMedicaAtencion, BC000Y10_A270RecetaMedicaArchivo, BC000Y10_n270RecetaMedicaArchivo, BC000Y10_A272RecetaMedicaFlag,
            BC000Y10_n272RecetaMedicaFlag, BC000Y10_A332RecetaIndicaciones, BC000Y10_A271RecetaArchivoTipo, BC000Y10_A267RecetaMedicaNombreArchivo, BC000Y10_n267RecetaMedicaNombreArchivo, BC000Y10_A19CitaId, BC000Y10_A42MedicamentoId, BC000Y10_n42MedicamentoId
            }
            , new Object[] {
            BC000Y11_A50RecetaMedicaId, BC000Y11_A268RecetaMedicaConcentracion, BC000Y11_n268RecetaMedicaConcentracion, BC000Y11_A269RecetaMedicaCantidad, BC000Y11_n269RecetaMedicaCantidad, BC000Y11_A273RecetaMedicaAtencion, BC000Y11_n273RecetaMedicaAtencion, BC000Y11_A270RecetaMedicaArchivo, BC000Y11_n270RecetaMedicaArchivo, BC000Y11_A272RecetaMedicaFlag,
            BC000Y11_n272RecetaMedicaFlag, BC000Y11_A332RecetaIndicaciones, BC000Y11_A271RecetaArchivoTipo, BC000Y11_A267RecetaMedicaNombreArchivo, BC000Y11_n267RecetaMedicaNombreArchivo, BC000Y11_A19CitaId, BC000Y11_A42MedicamentoId, BC000Y11_n42MedicamentoId
            }
            , new Object[] {
            BC000Y12_A50RecetaMedicaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000Y16_A229MedicamentoCodigo, BC000Y16_A230MedicamentoNombre, BC000Y16_A231MedicamentoFormaFarm, BC000Y16_n231MedicamentoFormaFarm
            }
            , new Object[] {
            BC000Y17_A50RecetaMedicaId, BC000Y17_A229MedicamentoCodigo, BC000Y17_A230MedicamentoNombre, BC000Y17_A231MedicamentoFormaFarm, BC000Y17_n231MedicamentoFormaFarm, BC000Y17_A268RecetaMedicaConcentracion, BC000Y17_n268RecetaMedicaConcentracion, BC000Y17_A269RecetaMedicaCantidad, BC000Y17_n269RecetaMedicaCantidad, BC000Y17_A273RecetaMedicaAtencion,
            BC000Y17_n273RecetaMedicaAtencion, BC000Y17_A270RecetaMedicaArchivo, BC000Y17_n270RecetaMedicaArchivo, BC000Y17_A272RecetaMedicaFlag, BC000Y17_n272RecetaMedicaFlag, BC000Y17_A332RecetaIndicaciones, BC000Y17_A271RecetaArchivoTipo, BC000Y17_A267RecetaMedicaNombreArchivo, BC000Y17_n267RecetaMedicaNombreArchivo, BC000Y17_A19CitaId,
            BC000Y17_A42MedicamentoId, BC000Y17_n42MedicamentoId
            }
         }
      );
      AV24Pgmname = "RecetaMedica_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120Y2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z272RecetaMedicaFlag ;
   private byte A272RecetaMedicaFlag ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z50RecetaMedicaId ;
   private short A50RecetaMedicaId ;
   private short AV13Insert_MedicamentoId ;
   private short Z269RecetaMedicaCantidad ;
   private short A269RecetaMedicaCantidad ;
   private short Z42MedicamentoId ;
   private short A42MedicamentoId ;
   private short RcdFound43 ;
   private short nIsDirty_43 ;
   private int trnEnded ;
   private int AV25GXV1 ;
   private int AV12Insert_CitaId ;
   private int GX_JID ;
   private int Z19CitaId ;
   private int A19CitaId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV24Pgmname ;
   private String A270RecetaMedicaArchivo_Filetype ;
   private String A270RecetaMedicaArchivo_Filename ;
   private String sMode43 ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n231MedicamentoFormaFarm ;
   private boolean n268RecetaMedicaConcentracion ;
   private boolean n269RecetaMedicaCantidad ;
   private boolean n273RecetaMedicaAtencion ;
   private boolean n270RecetaMedicaArchivo ;
   private boolean n272RecetaMedicaFlag ;
   private boolean n267RecetaMedicaNombreArchivo ;
   private boolean n42MedicamentoId ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z270RecetaMedicaArchivo ;
   private String A270RecetaMedicaArchivo ;
   private String Z268RecetaMedicaConcentracion ;
   private String A268RecetaMedicaConcentracion ;
   private String Z273RecetaMedicaAtencion ;
   private String A273RecetaMedicaAtencion ;
   private String Z332RecetaIndicaciones ;
   private String A332RecetaIndicaciones ;
   private String Z229MedicamentoCodigo ;
   private String A229MedicamentoCodigo ;
   private String Z230MedicamentoNombre ;
   private String A230MedicamentoNombre ;
   private String Z231MedicamentoFormaFarm ;
   private String A231MedicamentoFormaFarm ;
   private String Z271RecetaArchivoTipo ;
   private String A271RecetaArchivoTipo ;
   private String Z267RecetaMedicaNombreArchivo ;
   private String A267RecetaMedicaNombreArchivo ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtRecetaMedica bcRecetaMedica ;
   private IDataStoreProvider pr_default ;
   private short[] BC000Y6_A50RecetaMedicaId ;
   private String[] BC000Y6_A229MedicamentoCodigo ;
   private String[] BC000Y6_A230MedicamentoNombre ;
   private String[] BC000Y6_A231MedicamentoFormaFarm ;
   private boolean[] BC000Y6_n231MedicamentoFormaFarm ;
   private String[] BC000Y6_A268RecetaMedicaConcentracion ;
   private boolean[] BC000Y6_n268RecetaMedicaConcentracion ;
   private short[] BC000Y6_A269RecetaMedicaCantidad ;
   private boolean[] BC000Y6_n269RecetaMedicaCantidad ;
   private String[] BC000Y6_A273RecetaMedicaAtencion ;
   private boolean[] BC000Y6_n273RecetaMedicaAtencion ;
   private String[] BC000Y6_A270RecetaMedicaArchivo ;
   private boolean[] BC000Y6_n270RecetaMedicaArchivo ;
   private byte[] BC000Y6_A272RecetaMedicaFlag ;
   private boolean[] BC000Y6_n272RecetaMedicaFlag ;
   private String[] BC000Y6_A332RecetaIndicaciones ;
   private String[] BC000Y6_A271RecetaArchivoTipo ;
   private String[] BC000Y6_A267RecetaMedicaNombreArchivo ;
   private boolean[] BC000Y6_n267RecetaMedicaNombreArchivo ;
   private int[] BC000Y6_A19CitaId ;
   private short[] BC000Y6_A42MedicamentoId ;
   private boolean[] BC000Y6_n42MedicamentoId ;
   private int[] BC000Y7_A19CitaId ;
   private String[] BC000Y8_A229MedicamentoCodigo ;
   private String[] BC000Y8_A230MedicamentoNombre ;
   private String[] BC000Y8_A231MedicamentoFormaFarm ;
   private boolean[] BC000Y8_n231MedicamentoFormaFarm ;
   private short[] BC000Y9_A50RecetaMedicaId ;
   private short[] BC000Y10_A50RecetaMedicaId ;
   private String[] BC000Y10_A268RecetaMedicaConcentracion ;
   private boolean[] BC000Y10_n268RecetaMedicaConcentracion ;
   private short[] BC000Y10_A269RecetaMedicaCantidad ;
   private boolean[] BC000Y10_n269RecetaMedicaCantidad ;
   private String[] BC000Y10_A273RecetaMedicaAtencion ;
   private boolean[] BC000Y10_n273RecetaMedicaAtencion ;
   private String[] BC000Y10_A270RecetaMedicaArchivo ;
   private boolean[] BC000Y10_n270RecetaMedicaArchivo ;
   private byte[] BC000Y10_A272RecetaMedicaFlag ;
   private boolean[] BC000Y10_n272RecetaMedicaFlag ;
   private String[] BC000Y10_A332RecetaIndicaciones ;
   private String[] BC000Y10_A271RecetaArchivoTipo ;
   private String[] BC000Y10_A267RecetaMedicaNombreArchivo ;
   private boolean[] BC000Y10_n267RecetaMedicaNombreArchivo ;
   private int[] BC000Y10_A19CitaId ;
   private short[] BC000Y10_A42MedicamentoId ;
   private boolean[] BC000Y10_n42MedicamentoId ;
   private short[] BC000Y11_A50RecetaMedicaId ;
   private String[] BC000Y11_A268RecetaMedicaConcentracion ;
   private boolean[] BC000Y11_n268RecetaMedicaConcentracion ;
   private short[] BC000Y11_A269RecetaMedicaCantidad ;
   private boolean[] BC000Y11_n269RecetaMedicaCantidad ;
   private String[] BC000Y11_A273RecetaMedicaAtencion ;
   private boolean[] BC000Y11_n273RecetaMedicaAtencion ;
   private String[] BC000Y11_A270RecetaMedicaArchivo ;
   private boolean[] BC000Y11_n270RecetaMedicaArchivo ;
   private byte[] BC000Y11_A272RecetaMedicaFlag ;
   private boolean[] BC000Y11_n272RecetaMedicaFlag ;
   private String[] BC000Y11_A332RecetaIndicaciones ;
   private String[] BC000Y11_A271RecetaArchivoTipo ;
   private String[] BC000Y11_A267RecetaMedicaNombreArchivo ;
   private boolean[] BC000Y11_n267RecetaMedicaNombreArchivo ;
   private int[] BC000Y11_A19CitaId ;
   private short[] BC000Y11_A42MedicamentoId ;
   private boolean[] BC000Y11_n42MedicamentoId ;
   private short[] BC000Y12_A50RecetaMedicaId ;
   private String[] BC000Y16_A229MedicamentoCodigo ;
   private String[] BC000Y16_A230MedicamentoNombre ;
   private String[] BC000Y16_A231MedicamentoFormaFarm ;
   private boolean[] BC000Y16_n231MedicamentoFormaFarm ;
   private short[] BC000Y17_A50RecetaMedicaId ;
   private String[] BC000Y17_A229MedicamentoCodigo ;
   private String[] BC000Y17_A230MedicamentoNombre ;
   private String[] BC000Y17_A231MedicamentoFormaFarm ;
   private boolean[] BC000Y17_n231MedicamentoFormaFarm ;
   private String[] BC000Y17_A268RecetaMedicaConcentracion ;
   private boolean[] BC000Y17_n268RecetaMedicaConcentracion ;
   private short[] BC000Y17_A269RecetaMedicaCantidad ;
   private boolean[] BC000Y17_n269RecetaMedicaCantidad ;
   private String[] BC000Y17_A273RecetaMedicaAtencion ;
   private boolean[] BC000Y17_n273RecetaMedicaAtencion ;
   private String[] BC000Y17_A270RecetaMedicaArchivo ;
   private boolean[] BC000Y17_n270RecetaMedicaArchivo ;
   private byte[] BC000Y17_A272RecetaMedicaFlag ;
   private boolean[] BC000Y17_n272RecetaMedicaFlag ;
   private String[] BC000Y17_A332RecetaIndicaciones ;
   private String[] BC000Y17_A271RecetaArchivoTipo ;
   private String[] BC000Y17_A267RecetaMedicaNombreArchivo ;
   private boolean[] BC000Y17_n267RecetaMedicaNombreArchivo ;
   private int[] BC000Y17_A19CitaId ;
   private short[] BC000Y17_A42MedicamentoId ;
   private boolean[] BC000Y17_n42MedicamentoId ;
   private short[] BC000Y2_A50RecetaMedicaId ;
   private String[] BC000Y2_A268RecetaMedicaConcentracion ;
   private short[] BC000Y2_A269RecetaMedicaCantidad ;
   private String[] BC000Y2_A273RecetaMedicaAtencion ;
   private String[] BC000Y2_A270RecetaMedicaArchivo ;
   private byte[] BC000Y2_A272RecetaMedicaFlag ;
   private String[] BC000Y2_A332RecetaIndicaciones ;
   private String[] BC000Y2_A271RecetaArchivoTipo ;
   private String[] BC000Y2_A267RecetaMedicaNombreArchivo ;
   private int[] BC000Y2_A19CitaId ;
   private short[] BC000Y2_A42MedicamentoId ;
   private short[] BC000Y3_A50RecetaMedicaId ;
   private String[] BC000Y3_A268RecetaMedicaConcentracion ;
   private short[] BC000Y3_A269RecetaMedicaCantidad ;
   private String[] BC000Y3_A273RecetaMedicaAtencion ;
   private String[] BC000Y3_A270RecetaMedicaArchivo ;
   private byte[] BC000Y3_A272RecetaMedicaFlag ;
   private String[] BC000Y3_A332RecetaIndicaciones ;
   private String[] BC000Y3_A271RecetaArchivoTipo ;
   private String[] BC000Y3_A267RecetaMedicaNombreArchivo ;
   private int[] BC000Y3_A19CitaId ;
   private short[] BC000Y3_A42MedicamentoId ;
   private int[] BC000Y4_A19CitaId ;
   private String[] BC000Y5_A229MedicamentoCodigo ;
   private String[] BC000Y5_A230MedicamentoNombre ;
   private String[] BC000Y5_A231MedicamentoFormaFarm ;
   private boolean[] BC000Y2_n268RecetaMedicaConcentracion ;
   private boolean[] BC000Y2_n269RecetaMedicaCantidad ;
   private boolean[] BC000Y2_n273RecetaMedicaAtencion ;
   private boolean[] BC000Y2_n270RecetaMedicaArchivo ;
   private boolean[] BC000Y2_n272RecetaMedicaFlag ;
   private boolean[] BC000Y2_n267RecetaMedicaNombreArchivo ;
   private boolean[] BC000Y2_n42MedicamentoId ;
   private boolean[] BC000Y3_n268RecetaMedicaConcentracion ;
   private boolean[] BC000Y3_n269RecetaMedicaCantidad ;
   private boolean[] BC000Y3_n273RecetaMedicaAtencion ;
   private boolean[] BC000Y3_n270RecetaMedicaArchivo ;
   private boolean[] BC000Y3_n272RecetaMedicaFlag ;
   private boolean[] BC000Y3_n267RecetaMedicaNombreArchivo ;
   private boolean[] BC000Y3_n42MedicamentoId ;
   private boolean[] BC000Y5_n231MedicamentoFormaFarm ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class recetamedica_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000Y2", "SELECT [RecetaMedicaId], [RecetaMedicaConcentracion], [RecetaMedicaCantidad], [RecetaMedicaAtencion], [RecetaMedicaArchivo], [RecetaMedicaFlag], [RecetaIndicaciones], [RecetaArchivoTipo], [RecetaMedicaNombreArchivo], [CitaId], [MedicamentoId] FROM [RecetaMedica] WITH (UPDLOCK) WHERE [RecetaMedicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y3", "SELECT [RecetaMedicaId], [RecetaMedicaConcentracion], [RecetaMedicaCantidad], [RecetaMedicaAtencion], [RecetaMedicaArchivo], [RecetaMedicaFlag], [RecetaIndicaciones], [RecetaArchivoTipo], [RecetaMedicaNombreArchivo], [CitaId], [MedicamentoId] FROM [RecetaMedica] WHERE [RecetaMedicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y4", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y5", "SELECT [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y6", "SELECT TM1.[RecetaMedicaId], T2.[MedicamentoCodigo], T2.[MedicamentoNombre], T2.[MedicamentoFormaFarm], TM1.[RecetaMedicaConcentracion], TM1.[RecetaMedicaCantidad], TM1.[RecetaMedicaAtencion], TM1.[RecetaMedicaArchivo], TM1.[RecetaMedicaFlag], TM1.[RecetaIndicaciones], TM1.[RecetaArchivoTipo], TM1.[RecetaMedicaNombreArchivo], TM1.[CitaId], TM1.[MedicamentoId] FROM ([RecetaMedica] TM1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = TM1.[MedicamentoId]) WHERE TM1.[RecetaMedicaId] = ? ORDER BY TM1.[RecetaMedicaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y7", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y8", "SELECT [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y9", "SELECT [RecetaMedicaId] FROM [RecetaMedica] WHERE [RecetaMedicaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y10", "SELECT [RecetaMedicaId], [RecetaMedicaConcentracion], [RecetaMedicaCantidad], [RecetaMedicaAtencion], [RecetaMedicaArchivo], [RecetaMedicaFlag], [RecetaIndicaciones], [RecetaArchivoTipo], [RecetaMedicaNombreArchivo], [CitaId], [MedicamentoId] FROM [RecetaMedica] WHERE [RecetaMedicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y11", "SELECT [RecetaMedicaId], [RecetaMedicaConcentracion], [RecetaMedicaCantidad], [RecetaMedicaAtencion], [RecetaMedicaArchivo], [RecetaMedicaFlag], [RecetaIndicaciones], [RecetaArchivoTipo], [RecetaMedicaNombreArchivo], [CitaId], [MedicamentoId] FROM [RecetaMedica] WITH (UPDLOCK) WHERE [RecetaMedicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y12", "INSERT INTO [RecetaMedica]([RecetaMedicaConcentracion], [RecetaMedicaCantidad], [RecetaMedicaAtencion], [RecetaMedicaArchivo], [RecetaMedicaFlag], [RecetaIndicaciones], [RecetaArchivoTipo], [RecetaMedicaNombreArchivo], [CitaId], [MedicamentoId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000Y13", "UPDATE [RecetaMedica] SET [RecetaMedicaConcentracion]=?, [RecetaMedicaCantidad]=?, [RecetaMedicaAtencion]=?, [RecetaMedicaFlag]=?, [RecetaIndicaciones]=?, [RecetaArchivoTipo]=?, [RecetaMedicaNombreArchivo]=?, [CitaId]=?, [MedicamentoId]=?  WHERE [RecetaMedicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000Y14", "UPDATE [RecetaMedica] SET [RecetaMedicaArchivo]=?  WHERE [RecetaMedicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000Y15", "DELETE FROM [RecetaMedica]  WHERE [RecetaMedicaId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000Y16", "SELECT [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y17", "SELECT TM1.[RecetaMedicaId], T2.[MedicamentoCodigo], T2.[MedicamentoNombre], T2.[MedicamentoFormaFarm], TM1.[RecetaMedicaConcentracion], TM1.[RecetaMedicaCantidad], TM1.[RecetaMedicaAtencion], TM1.[RecetaMedicaArchivo], TM1.[RecetaMedicaFlag], TM1.[RecetaIndicaciones], TM1.[RecetaArchivoTipo], TM1.[RecetaMedicaNombreArchivo], TM1.[CitaId], TM1.[MedicamentoId] FROM ([RecetaMedica] TM1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = TM1.[MedicamentoId]) WHERE TM1.[RecetaMedicaId] = ? ORDER BY TM1.[RecetaMedicaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getBLOBFile(5, rslt.getVarchar(8), rslt.getVarchar(9));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(7);
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((short[]) buf[16])[0] = rslt.getShort(11);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getBLOBFile(5, rslt.getVarchar(8), rslt.getVarchar(9));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(7);
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((short[]) buf[16])[0] = rslt.getShort(11);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getBLOBFile(8, rslt.getVarchar(11), rslt.getVarchar(12));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               ((String[]) buf[17])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(13);
               ((short[]) buf[20])[0] = rslt.getShort(14);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getBLOBFile(5, rslt.getVarchar(8), rslt.getVarchar(9));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(7);
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((short[]) buf[16])[0] = rslt.getShort(11);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getBLOBFile(5, rslt.getVarchar(8), rslt.getVarchar(9));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(7);
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((short[]) buf[16])[0] = rslt.getShort(11);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getBLOBFile(8, rslt.getVarchar(11), rslt.getVarchar(12));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               ((String[]) buf[17])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(13);
               ((short[]) buf[20])[0] = rslt.getShort(14);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 40);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(3, (String)parms[5], 40);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(4, (String)parms[7]);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(5, ((Number) parms[9]).byteValue());
               }
               stmt.setVarchar(6, (String)parms[10], 300, false);
               stmt.setVarchar(7, (String)parms[11], 30, false);
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[13], 100);
               }
               stmt.setInt(9, ((Number) parms[14]).intValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[16]).shortValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 40);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(3, (String)parms[5], 40);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(4, ((Number) parms[7]).byteValue());
               }
               stmt.setVarchar(5, (String)parms[8], 300, false);
               stmt.setVarchar(6, (String)parms[9], 30, false);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[11], 100);
               }
               stmt.setInt(8, ((Number) parms[12]).intValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(9, ((Number) parms[14]).shortValue());
               }
               stmt.setShort(10, ((Number) parms[15]).shortValue());
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1]);
               }
               stmt.setShort(2, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

