package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pais_bc extends GXWebPanel implements IGxSilentTrn
{
   public pais_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pais_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pais_bc.class ));
   }

   public pais_bc( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0U39( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0U39( ) ;
      standaloneModal( ) ;
      addRow0U39( ) ;
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
         e110U2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z43PaisId = A43PaisId ;
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

   public void confirm_0U0( )
   {
      beforeValidate0U39( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0U39( ) ;
         }
         else
         {
            checkExtendedTable0U39( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0U39( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120U2( )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais_Insert", GXv_boolean3) ;
         pais_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais_Update", GXv_boolean3) ;
         pais_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais_Delete", GXv_boolean3) ;
         pais_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
   }

   public void e110U2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0U39( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z184PaisDescripcion = A184PaisDescripcion ;
         Z259PaisEstado = A259PaisEstado ;
      }
      if ( GX_JID == -2 )
      {
         Z43PaisId = A43PaisId ;
         Z184PaisDescripcion = A184PaisDescripcion ;
         Z259PaisEstado = A259PaisEstado ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0U39( )
   {
      /* Using cursor BC000U4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A184PaisDescripcion = BC000U4_A184PaisDescripcion[0] ;
         A259PaisEstado = BC000U4_A259PaisEstado[0] ;
         zm0U39( -2) ;
      }
      pr_default.close(2);
      onLoadActions0U39( ) ;
   }

   public void onLoadActions0U39( )
   {
      AV13Pgmname = "Pais_BC" ;
   }

   public void checkExtendedTable0U39( )
   {
      nIsDirty_39 = (short)(0) ;
      standaloneModal( ) ;
      AV13Pgmname = "Pais_BC" ;
      if ( ! ( ( GXutil.strcmp(A259PaisEstado, "A") == 0 ) || ( GXutil.strcmp(A259PaisEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pais Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0U39( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0U39( )
   {
      /* Using cursor BC000U5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound39 = (short)(1) ;
      }
      else
      {
         RcdFound39 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000U6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0U39( 2) ;
         RcdFound39 = (short)(1) ;
         A43PaisId = BC000U6_A43PaisId[0] ;
         A184PaisDescripcion = BC000U6_A184PaisDescripcion[0] ;
         A259PaisEstado = BC000U6_A259PaisEstado[0] ;
         Z43PaisId = A43PaisId ;
         sMode39 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0U39( ) ;
         if ( AnyError == 1 )
         {
            RcdFound39 = (short)(0) ;
            initializeNonKey0U39( ) ;
         }
         Gx_mode = sMode39 ;
      }
      else
      {
         RcdFound39 = (short)(0) ;
         initializeNonKey0U39( ) ;
         sMode39 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode39 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0U39( ) ;
      if ( RcdFound39 == 0 )
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
      confirm_0U0( ) ;
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

   public void checkOptimisticConcurrency0U39( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000U7 */
         pr_default.execute(5, new Object[] {Short.valueOf(A43PaisId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pais"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z184PaisDescripcion, BC000U7_A184PaisDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z259PaisEstado, BC000U7_A259PaisEstado[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Pais"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0U39( )
   {
      beforeValidate0U39( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0U39( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0U39( 0) ;
         checkOptimisticConcurrency0U39( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0U39( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0U39( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000U8 */
                  pr_default.execute(6, new Object[] {A184PaisDescripcion, A259PaisEstado});
                  A43PaisId = BC000U8_A43PaisId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
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
            load0U39( ) ;
         }
         endLevel0U39( ) ;
      }
      closeExtendedTableCursors0U39( ) ;
   }

   public void update0U39( )
   {
      beforeValidate0U39( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0U39( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0U39( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0U39( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0U39( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000U9 */
                  pr_default.execute(7, new Object[] {A184PaisDescripcion, A259PaisEstado, Short.valueOf(A43PaisId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pais"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0U39( ) ;
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
         endLevel0U39( ) ;
      }
      closeExtendedTableCursors0U39( ) ;
   }

   public void deferredUpdate0U39( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0U39( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0U39( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0U39( ) ;
         afterConfirm0U39( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0U39( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000U10 */
               pr_default.execute(8, new Object[] {Short.valueOf(A43PaisId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
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
      sMode39 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0U39( ) ;
      Gx_mode = sMode39 ;
   }

   public void onDeleteControls0U39( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "Pais_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000U11 */
         pr_default.execute(9, new Object[] {Short.valueOf(A43PaisId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Paciente"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
         /* Using cursor BC000U12 */
         pr_default.execute(10, new Object[] {Short.valueOf(A43PaisId)});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
      }
   }

   public void endLevel0U39( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0U39( ) ;
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

   public void scanKeyStart0U39( )
   {
      /* Scan By routine */
      /* Using cursor BC000U13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A43PaisId)});
      RcdFound39 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A43PaisId = BC000U13_A43PaisId[0] ;
         A184PaisDescripcion = BC000U13_A184PaisDescripcion[0] ;
         A259PaisEstado = BC000U13_A259PaisEstado[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0U39( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound39 = (short)(0) ;
      scanKeyLoad0U39( ) ;
   }

   public void scanKeyLoad0U39( )
   {
      sMode39 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A43PaisId = BC000U13_A43PaisId[0] ;
         A184PaisDescripcion = BC000U13_A184PaisDescripcion[0] ;
         A259PaisEstado = BC000U13_A259PaisEstado[0] ;
      }
      Gx_mode = sMode39 ;
   }

   public void scanKeyEnd0U39( )
   {
      pr_default.close(11);
   }

   public void afterConfirm0U39( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0U39( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0U39( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0U39( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0U39( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0U39( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0U39( )
   {
   }

   public void send_integrity_lvl_hashes0U39( )
   {
   }

   public void addRow0U39( )
   {
      VarsToRow39( bcPais) ;
   }

   public void readRow0U39( )
   {
      RowToVars39( bcPais, 1) ;
   }

   public void initializeNonKey0U39( )
   {
      A184PaisDescripcion = "" ;
      A259PaisEstado = "" ;
      Z184PaisDescripcion = "" ;
      Z259PaisEstado = "" ;
   }

   public void initAll0U39( )
   {
      A43PaisId = (short)(0) ;
      initializeNonKey0U39( ) ;
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

   public void VarsToRow39( com.projectthani.SdtPais obj39 )
   {
      obj39.setgxTv_SdtPais_Mode( Gx_mode );
      obj39.setgxTv_SdtPais_Paisdescripcion( A184PaisDescripcion );
      obj39.setgxTv_SdtPais_Paisestado( A259PaisEstado );
      obj39.setgxTv_SdtPais_Paisid( A43PaisId );
      obj39.setgxTv_SdtPais_Paisid_Z( Z43PaisId );
      obj39.setgxTv_SdtPais_Paisdescripcion_Z( Z184PaisDescripcion );
      obj39.setgxTv_SdtPais_Paisestado_Z( Z259PaisEstado );
      obj39.setgxTv_SdtPais_Mode( Gx_mode );
   }

   public void KeyVarsToRow39( com.projectthani.SdtPais obj39 )
   {
      obj39.setgxTv_SdtPais_Paisid( A43PaisId );
   }

   public void RowToVars39( com.projectthani.SdtPais obj39 ,
                            int forceLoad )
   {
      Gx_mode = obj39.getgxTv_SdtPais_Mode() ;
      A184PaisDescripcion = obj39.getgxTv_SdtPais_Paisdescripcion() ;
      A259PaisEstado = obj39.getgxTv_SdtPais_Paisestado() ;
      A43PaisId = obj39.getgxTv_SdtPais_Paisid() ;
      Z43PaisId = obj39.getgxTv_SdtPais_Paisid_Z() ;
      Z184PaisDescripcion = obj39.getgxTv_SdtPais_Paisdescripcion_Z() ;
      Z259PaisEstado = obj39.getgxTv_SdtPais_Paisestado_Z() ;
      Gx_mode = obj39.getgxTv_SdtPais_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A43PaisId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0U39( ) ;
      scanKeyStart0U39( ) ;
      if ( RcdFound39 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z43PaisId = A43PaisId ;
      }
      zm0U39( -2) ;
      onLoadActions0U39( ) ;
      addRow0U39( ) ;
      scanKeyEnd0U39( ) ;
      if ( RcdFound39 == 0 )
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
      RowToVars39( bcPais, 0) ;
      scanKeyStart0U39( ) ;
      if ( RcdFound39 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z43PaisId = A43PaisId ;
      }
      zm0U39( -2) ;
      onLoadActions0U39( ) ;
      addRow0U39( ) ;
      scanKeyEnd0U39( ) ;
      if ( RcdFound39 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0U39( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0U39( ) ;
      }
      else
      {
         if ( RcdFound39 == 1 )
         {
            if ( A43PaisId != Z43PaisId )
            {
               A43PaisId = Z43PaisId ;
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
               update0U39( ) ;
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
               if ( A43PaisId != Z43PaisId )
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
                     insert0U39( ) ;
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
                     insert0U39( ) ;
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
      RowToVars39( bcPais, 1) ;
      saveImpl( ) ;
      VarsToRow39( bcPais) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars39( bcPais, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0U39( ) ;
      afterTrn( ) ;
      VarsToRow39( bcPais) ;
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
         com.projectthani.SdtPais auxBC = new com.projectthani.SdtPais( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A43PaisId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcPais);
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
      RowToVars39( bcPais, 1) ;
      updateImpl( ) ;
      VarsToRow39( bcPais) ;
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
      RowToVars39( bcPais, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0U39( ) ;
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
      VarsToRow39( bcPais) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars39( bcPais, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0U39( ) ;
      if ( RcdFound39 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A43PaisId != Z43PaisId )
         {
            A43PaisId = Z43PaisId ;
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
         if ( A43PaisId != Z43PaisId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "pais_bc");
      VarsToRow39( bcPais) ;
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
      Gx_mode = bcPais.getgxTv_SdtPais_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcPais.setgxTv_SdtPais_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtPais sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcPais )
      {
         bcPais = sdt ;
         if ( GXutil.strcmp(bcPais.getgxTv_SdtPais_Mode(), "") == 0 )
         {
            bcPais.setgxTv_SdtPais_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow39( bcPais) ;
         }
         else
         {
            RowToVars39( bcPais, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcPais.getgxTv_SdtPais_Mode(), "") == 0 )
         {
            bcPais.setgxTv_SdtPais_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars39( bcPais, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtPais getPais_BC( )
   {
      return bcPais ;
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
      AV13Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      Z184PaisDescripcion = "" ;
      A184PaisDescripcion = "" ;
      Z259PaisEstado = "" ;
      A259PaisEstado = "" ;
      BC000U4_A43PaisId = new short[1] ;
      BC000U4_A184PaisDescripcion = new String[] {""} ;
      BC000U4_A259PaisEstado = new String[] {""} ;
      BC000U5_A43PaisId = new short[1] ;
      BC000U6_A43PaisId = new short[1] ;
      BC000U6_A184PaisDescripcion = new String[] {""} ;
      BC000U6_A259PaisEstado = new String[] {""} ;
      sMode39 = "" ;
      BC000U7_A43PaisId = new short[1] ;
      BC000U7_A184PaisDescripcion = new String[] {""} ;
      BC000U7_A259PaisEstado = new String[] {""} ;
      BC000U8_A43PaisId = new short[1] ;
      BC000U11_A20PacienteId = new int[1] ;
      BC000U12_A31ProfesionalId = new int[1] ;
      BC000U13_A43PaisId = new short[1] ;
      BC000U13_A184PaisDescripcion = new String[] {""} ;
      BC000U13_A259PaisEstado = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pais_bc__default(),
         new Object[] {
             new Object[] {
            BC000U2_A43PaisId, BC000U2_A184PaisDescripcion, BC000U2_A259PaisEstado
            }
            , new Object[] {
            BC000U3_A43PaisId, BC000U3_A184PaisDescripcion, BC000U3_A259PaisEstado
            }
            , new Object[] {
            BC000U4_A43PaisId, BC000U4_A184PaisDescripcion, BC000U4_A259PaisEstado
            }
            , new Object[] {
            BC000U5_A43PaisId
            }
            , new Object[] {
            BC000U6_A43PaisId, BC000U6_A184PaisDescripcion, BC000U6_A259PaisEstado
            }
            , new Object[] {
            BC000U7_A43PaisId, BC000U7_A184PaisDescripcion, BC000U7_A259PaisEstado
            }
            , new Object[] {
            BC000U8_A43PaisId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000U11_A20PacienteId
            }
            , new Object[] {
            BC000U12_A31ProfesionalId
            }
            , new Object[] {
            BC000U13_A43PaisId, BC000U13_A184PaisDescripcion, BC000U13_A259PaisEstado
            }
         }
      );
      AV13Pgmname = "Pais_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120U2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z43PaisId ;
   private short A43PaisId ;
   private short RcdFound39 ;
   private short nIsDirty_39 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV13Pgmname ;
   private String Z259PaisEstado ;
   private String A259PaisEstado ;
   private String sMode39 ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean mustCommit ;
   private String Z184PaisDescripcion ;
   private String A184PaisDescripcion ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtPais bcPais ;
   private IDataStoreProvider pr_default ;
   private short[] BC000U4_A43PaisId ;
   private String[] BC000U4_A184PaisDescripcion ;
   private String[] BC000U4_A259PaisEstado ;
   private short[] BC000U5_A43PaisId ;
   private short[] BC000U6_A43PaisId ;
   private String[] BC000U6_A184PaisDescripcion ;
   private String[] BC000U6_A259PaisEstado ;
   private short[] BC000U7_A43PaisId ;
   private String[] BC000U7_A184PaisDescripcion ;
   private String[] BC000U7_A259PaisEstado ;
   private short[] BC000U8_A43PaisId ;
   private int[] BC000U11_A20PacienteId ;
   private int[] BC000U12_A31ProfesionalId ;
   private short[] BC000U13_A43PaisId ;
   private String[] BC000U13_A184PaisDescripcion ;
   private String[] BC000U13_A259PaisEstado ;
   private short[] BC000U2_A43PaisId ;
   private String[] BC000U2_A184PaisDescripcion ;
   private String[] BC000U2_A259PaisEstado ;
   private short[] BC000U3_A43PaisId ;
   private String[] BC000U3_A184PaisDescripcion ;
   private String[] BC000U3_A259PaisEstado ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
}

final  class pais_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000U2", "SELECT [PaisId], [PaisDescripcion], [PaisEstado] FROM [Pais] WITH (UPDLOCK) WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U3", "SELECT [PaisId], [PaisDescripcion], [PaisEstado] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U4", "SELECT TM1.[PaisId], TM1.[PaisDescripcion], TM1.[PaisEstado] FROM [Pais] TM1 WHERE TM1.[PaisId] = ? ORDER BY TM1.[PaisId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U5", "SELECT [PaisId] FROM [Pais] WHERE [PaisId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U6", "SELECT [PaisId], [PaisDescripcion], [PaisEstado] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U7", "SELECT [PaisId], [PaisDescripcion], [PaisEstado] FROM [Pais] WITH (UPDLOCK) WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U8", "INSERT INTO [Pais]([PaisDescripcion], [PaisEstado]) VALUES(?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000U9", "UPDATE [Pais] SET [PaisDescripcion]=?, [PaisEstado]=?  WHERE [PaisId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000U10", "DELETE FROM [Pais]  WHERE [PaisId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000U11", "SELECT TOP 1 [PacienteId] FROM [Paciente] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000U12", "SELECT TOP 1 [ProfesionalId] FROM [Profesional] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000U13", "SELECT TM1.[PaisId], TM1.[PaisDescripcion], TM1.[PaisEstado] FROM [Pais] TM1 WHERE TM1.[PaisId] = ? ORDER BY TM1.[PaisId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setString(2, (String)parms[1], 1);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setString(2, (String)parms[1], 1);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

