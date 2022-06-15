package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secuser_bc extends GXWebPanel implements IGxSilentTrn
{
   public secuser_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secuser_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secuser_bc.class ));
   }

   public secuser_bc( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow056( ) ;
      standaloneNotModal( ) ;
      initializeNonKey056( ) ;
      standaloneModal( ) ;
      addRow056( ) ;
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
         e11052 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z6SecUserId = A6SecUserId ;
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

   public void confirm_050( )
   {
      beforeValidate056( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls056( ) ;
         }
         else
         {
            checkExtendedTable056( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors056( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12052( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV15WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV15WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Insert", GXv_boolean3) ;
         secuser_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Update", GXv_boolean3) ;
         secuser_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Delete", GXv_boolean3) ;
         secuser_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
   }

   public void e11052( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm056( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z14SecUserName = A14SecUserName ;
         Z15SecUserPassword = A15SecUserPassword ;
         Z122SecUserEmail = A122SecUserEmail ;
         Z211SecUserEstadoR = A211SecUserEstadoR ;
      }
      if ( GX_JID == -4 )
      {
         Z6SecUserId = A6SecUserId ;
         Z14SecUserName = A14SecUserName ;
         Z15SecUserPassword = A15SecUserPassword ;
         Z122SecUserEmail = A122SecUserEmail ;
         Z211SecUserEstadoR = A211SecUserEstadoR ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (GXutil.strcmp("", A211SecUserEstadoR)==0) && ( Gx_BScreen == 0 ) )
      {
         A211SecUserEstadoR = "A" ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load056( )
   {
      /* Using cursor BC00054 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound6 = (short)(1) ;
         A14SecUserName = BC00054_A14SecUserName[0] ;
         A15SecUserPassword = BC00054_A15SecUserPassword[0] ;
         A122SecUserEmail = BC00054_A122SecUserEmail[0] ;
         A211SecUserEstadoR = BC00054_A211SecUserEstadoR[0] ;
         zm056( -4) ;
      }
      pr_default.close(2);
      onLoadActions056( ) ;
   }

   public void onLoadActions056( )
   {
      AV16Pgmname = "WWPBaseObjects.SecUser_BC" ;
   }

   public void checkExtendedTable056( )
   {
      nIsDirty_6 = (short)(0) ;
      standaloneModal( ) ;
      AV16Pgmname = "WWPBaseObjects.SecUser_BC" ;
      if ( ! ( GxRegex.IsMatch(A122SecUserEmail,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Sec User Email no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A211SecUserEstadoR, "A") == 0 ) || ( GXutil.strcmp(A211SecUserEstadoR, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sec User Estado R fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors056( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey056( )
   {
      /* Using cursor BC00055 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound6 = (short)(1) ;
      }
      else
      {
         RcdFound6 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00056 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm056( 4) ;
         RcdFound6 = (short)(1) ;
         A6SecUserId = BC00056_A6SecUserId[0] ;
         n6SecUserId = BC00056_n6SecUserId[0] ;
         A14SecUserName = BC00056_A14SecUserName[0] ;
         A15SecUserPassword = BC00056_A15SecUserPassword[0] ;
         A122SecUserEmail = BC00056_A122SecUserEmail[0] ;
         A211SecUserEstadoR = BC00056_A211SecUserEstadoR[0] ;
         Z6SecUserId = A6SecUserId ;
         sMode6 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load056( ) ;
         if ( AnyError == 1 )
         {
            RcdFound6 = (short)(0) ;
            initializeNonKey056( ) ;
         }
         Gx_mode = sMode6 ;
      }
      else
      {
         RcdFound6 = (short)(0) ;
         initializeNonKey056( ) ;
         sMode6 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode6 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey056( ) ;
      if ( RcdFound6 == 0 )
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
      confirm_050( ) ;
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

   public void checkOptimisticConcurrency056( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00057 */
         pr_default.execute(5, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecUser"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z14SecUserName, BC00057_A14SecUserName[0]) != 0 ) || ( GXutil.strcmp(Z15SecUserPassword, BC00057_A15SecUserPassword[0]) != 0 ) || ( GXutil.strcmp(Z122SecUserEmail, BC00057_A122SecUserEmail[0]) != 0 ) || ( GXutil.strcmp(Z211SecUserEstadoR, BC00057_A211SecUserEstadoR[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecUser"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert056( )
   {
      beforeValidate056( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable056( ) ;
      }
      if ( AnyError == 0 )
      {
         zm056( 0) ;
         checkOptimisticConcurrency056( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm056( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert056( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00058 */
                  pr_default.execute(6, new Object[] {A14SecUserName, A15SecUserPassword, A122SecUserEmail, A211SecUserEstadoR});
                  A6SecUserId = BC00058_A6SecUserId[0] ;
                  n6SecUserId = BC00058_n6SecUserId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
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
            load056( ) ;
         }
         endLevel056( ) ;
      }
      closeExtendedTableCursors056( ) ;
   }

   public void update056( )
   {
      beforeValidate056( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable056( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency056( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm056( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate056( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00059 */
                  pr_default.execute(7, new Object[] {A14SecUserName, A15SecUserPassword, A122SecUserEmail, A211SecUserEstadoR, Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecUser"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate056( ) ;
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
         endLevel056( ) ;
      }
      closeExtendedTableCursors056( ) ;
   }

   public void deferredUpdate056( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate056( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency056( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls056( ) ;
         afterConfirm056( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete056( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000510 */
               pr_default.execute(8, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
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
      sMode6 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel056( ) ;
      Gx_mode = sMode6 ;
   }

   public void onDeleteControls056( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV16Pgmname = "WWPBaseObjects.SecUser_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000511 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Paciente"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
         /* Using cursor BC000512 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
         /* Using cursor BC000513 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Laboratorio Usuarios"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor BC000514 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Usuarios"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor BC000515 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sec User Role"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel056( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete056( ) ;
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

   public void scanKeyStart056( )
   {
      /* Scan By routine */
      /* Using cursor BC000516 */
      pr_default.execute(14, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      RcdFound6 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound6 = (short)(1) ;
         A6SecUserId = BC000516_A6SecUserId[0] ;
         n6SecUserId = BC000516_n6SecUserId[0] ;
         A14SecUserName = BC000516_A14SecUserName[0] ;
         A15SecUserPassword = BC000516_A15SecUserPassword[0] ;
         A122SecUserEmail = BC000516_A122SecUserEmail[0] ;
         A211SecUserEstadoR = BC000516_A211SecUserEstadoR[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext056( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound6 = (short)(0) ;
      scanKeyLoad056( ) ;
   }

   public void scanKeyLoad056( )
   {
      sMode6 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound6 = (short)(1) ;
         A6SecUserId = BC000516_A6SecUserId[0] ;
         n6SecUserId = BC000516_n6SecUserId[0] ;
         A14SecUserName = BC000516_A14SecUserName[0] ;
         A15SecUserPassword = BC000516_A15SecUserPassword[0] ;
         A122SecUserEmail = BC000516_A122SecUserEmail[0] ;
         A211SecUserEstadoR = BC000516_A211SecUserEstadoR[0] ;
      }
      Gx_mode = sMode6 ;
   }

   public void scanKeyEnd056( )
   {
      pr_default.close(14);
   }

   public void afterConfirm056( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert056( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate056( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete056( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete056( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate056( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes056( )
   {
   }

   public void send_integrity_lvl_hashes056( )
   {
   }

   public void addRow056( )
   {
      VarsToRow6( bcwwpbaseobjects_SecUser) ;
   }

   public void readRow056( )
   {
      RowToVars6( bcwwpbaseobjects_SecUser, 1) ;
   }

   public void initializeNonKey056( )
   {
      A14SecUserName = "" ;
      A15SecUserPassword = "" ;
      A122SecUserEmail = "" ;
      A211SecUserEstadoR = "A" ;
      Z14SecUserName = "" ;
      Z15SecUserPassword = "" ;
      Z122SecUserEmail = "" ;
      Z211SecUserEstadoR = "" ;
   }

   public void initAll056( )
   {
      A6SecUserId = (short)(0) ;
      n6SecUserId = false ;
      initializeNonKey056( ) ;
   }

   public void standaloneModalInsert( )
   {
      A211SecUserEstadoR = i211SecUserEstadoR ;
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

   public void VarsToRow6( com.projectthani.wwpbaseobjects.SdtSecUser obj6 )
   {
      obj6.setgxTv_SdtSecUser_Mode( Gx_mode );
      obj6.setgxTv_SdtSecUser_Secusername( A14SecUserName );
      obj6.setgxTv_SdtSecUser_Secuserpassword( A15SecUserPassword );
      obj6.setgxTv_SdtSecUser_Secuseremail( A122SecUserEmail );
      obj6.setgxTv_SdtSecUser_Secuserestador( A211SecUserEstadoR );
      obj6.setgxTv_SdtSecUser_Secuserid( A6SecUserId );
      obj6.setgxTv_SdtSecUser_Secuserid_Z( Z6SecUserId );
      obj6.setgxTv_SdtSecUser_Secusername_Z( Z14SecUserName );
      obj6.setgxTv_SdtSecUser_Secuserpassword_Z( Z15SecUserPassword );
      obj6.setgxTv_SdtSecUser_Secuseremail_Z( Z122SecUserEmail );
      obj6.setgxTv_SdtSecUser_Secuserestador_Z( Z211SecUserEstadoR );
      obj6.setgxTv_SdtSecUser_Secuserid_N( (byte)((byte)((n6SecUserId)?1:0)) );
      obj6.setgxTv_SdtSecUser_Mode( Gx_mode );
   }

   public void KeyVarsToRow6( com.projectthani.wwpbaseobjects.SdtSecUser obj6 )
   {
      obj6.setgxTv_SdtSecUser_Secuserid( A6SecUserId );
   }

   public void RowToVars6( com.projectthani.wwpbaseobjects.SdtSecUser obj6 ,
                           int forceLoad )
   {
      Gx_mode = obj6.getgxTv_SdtSecUser_Mode() ;
      A14SecUserName = obj6.getgxTv_SdtSecUser_Secusername() ;
      A15SecUserPassword = obj6.getgxTv_SdtSecUser_Secuserpassword() ;
      A122SecUserEmail = obj6.getgxTv_SdtSecUser_Secuseremail() ;
      A211SecUserEstadoR = obj6.getgxTv_SdtSecUser_Secuserestador() ;
      A6SecUserId = obj6.getgxTv_SdtSecUser_Secuserid() ;
      n6SecUserId = false ;
      Z6SecUserId = obj6.getgxTv_SdtSecUser_Secuserid_Z() ;
      Z14SecUserName = obj6.getgxTv_SdtSecUser_Secusername_Z() ;
      Z15SecUserPassword = obj6.getgxTv_SdtSecUser_Secuserpassword_Z() ;
      Z122SecUserEmail = obj6.getgxTv_SdtSecUser_Secuseremail_Z() ;
      Z211SecUserEstadoR = obj6.getgxTv_SdtSecUser_Secuserestador_Z() ;
      n6SecUserId = (boolean)((obj6.getgxTv_SdtSecUser_Secuserid_N()==0)?false:true) ;
      Gx_mode = obj6.getgxTv_SdtSecUser_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A6SecUserId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      n6SecUserId = false ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey056( ) ;
      scanKeyStart056( ) ;
      if ( RcdFound6 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z6SecUserId = A6SecUserId ;
      }
      zm056( -4) ;
      onLoadActions056( ) ;
      addRow056( ) ;
      scanKeyEnd056( ) ;
      if ( RcdFound6 == 0 )
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
      RowToVars6( bcwwpbaseobjects_SecUser, 0) ;
      scanKeyStart056( ) ;
      if ( RcdFound6 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z6SecUserId = A6SecUserId ;
      }
      zm056( -4) ;
      onLoadActions056( ) ;
      addRow056( ) ;
      scanKeyEnd056( ) ;
      if ( RcdFound6 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey056( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert056( ) ;
      }
      else
      {
         if ( RcdFound6 == 1 )
         {
            if ( A6SecUserId != Z6SecUserId )
            {
               A6SecUserId = Z6SecUserId ;
               n6SecUserId = false ;
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
               update056( ) ;
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
               if ( A6SecUserId != Z6SecUserId )
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
                     insert056( ) ;
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
                     insert056( ) ;
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
      RowToVars6( bcwwpbaseobjects_SecUser, 1) ;
      saveImpl( ) ;
      VarsToRow6( bcwwpbaseobjects_SecUser) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars6( bcwwpbaseobjects_SecUser, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert056( ) ;
      afterTrn( ) ;
      VarsToRow6( bcwwpbaseobjects_SecUser) ;
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
         com.projectthani.wwpbaseobjects.SdtSecUser auxBC = new com.projectthani.wwpbaseobjects.SdtSecUser( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A6SecUserId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_SecUser);
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
      RowToVars6( bcwwpbaseobjects_SecUser, 1) ;
      updateImpl( ) ;
      VarsToRow6( bcwwpbaseobjects_SecUser) ;
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
      RowToVars6( bcwwpbaseobjects_SecUser, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert056( ) ;
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
      VarsToRow6( bcwwpbaseobjects_SecUser) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars6( bcwwpbaseobjects_SecUser, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey056( ) ;
      if ( RcdFound6 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A6SecUserId != Z6SecUserId )
         {
            A6SecUserId = Z6SecUserId ;
            n6SecUserId = false ;
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
         if ( A6SecUserId != Z6SecUserId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secuser_bc");
      VarsToRow6( bcwwpbaseobjects_SecUser) ;
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
      Gx_mode = bcwwpbaseobjects_SecUser.getgxTv_SdtSecUser_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_SecUser.setgxTv_SdtSecUser_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.wwpbaseobjects.SdtSecUser sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_SecUser )
      {
         bcwwpbaseobjects_SecUser = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_SecUser.getgxTv_SdtSecUser_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecUser.setgxTv_SdtSecUser_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow6( bcwwpbaseobjects_SecUser) ;
         }
         else
         {
            RowToVars6( bcwwpbaseobjects_SecUser, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_SecUser.getgxTv_SdtSecUser_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecUser.setgxTv_SdtSecUser_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars6( bcwwpbaseobjects_SecUser, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtSecUser getSecUser_BC( )
   {
      return bcwwpbaseobjects_SecUser ;
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
      AV15WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV16Pgmname = "" ;
      AV11TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      Z14SecUserName = "" ;
      A14SecUserName = "" ;
      Z15SecUserPassword = "" ;
      A15SecUserPassword = "" ;
      Z122SecUserEmail = "" ;
      A122SecUserEmail = "" ;
      Z211SecUserEstadoR = "" ;
      A211SecUserEstadoR = "" ;
      BC00054_A6SecUserId = new short[1] ;
      BC00054_n6SecUserId = new boolean[] {false} ;
      BC00054_A14SecUserName = new String[] {""} ;
      BC00054_A15SecUserPassword = new String[] {""} ;
      BC00054_A122SecUserEmail = new String[] {""} ;
      BC00054_A211SecUserEstadoR = new String[] {""} ;
      BC00055_A6SecUserId = new short[1] ;
      BC00055_n6SecUserId = new boolean[] {false} ;
      BC00056_A6SecUserId = new short[1] ;
      BC00056_n6SecUserId = new boolean[] {false} ;
      BC00056_A14SecUserName = new String[] {""} ;
      BC00056_A15SecUserPassword = new String[] {""} ;
      BC00056_A122SecUserEmail = new String[] {""} ;
      BC00056_A211SecUserEstadoR = new String[] {""} ;
      sMode6 = "" ;
      BC00057_A6SecUserId = new short[1] ;
      BC00057_n6SecUserId = new boolean[] {false} ;
      BC00057_A14SecUserName = new String[] {""} ;
      BC00057_A15SecUserPassword = new String[] {""} ;
      BC00057_A122SecUserEmail = new String[] {""} ;
      BC00057_A211SecUserEstadoR = new String[] {""} ;
      BC00058_A6SecUserId = new short[1] ;
      BC00058_n6SecUserId = new boolean[] {false} ;
      BC000511_A20PacienteId = new int[1] ;
      BC000512_A31ProfesionalId = new int[1] ;
      BC000513_A40LaboratorioId = new short[1] ;
      BC000513_A6SecUserId = new short[1] ;
      BC000513_n6SecUserId = new boolean[] {false} ;
      BC000514_A36DrogueriaId = new short[1] ;
      BC000514_A6SecUserId = new short[1] ;
      BC000514_n6SecUserId = new boolean[] {false} ;
      BC000515_A6SecUserId = new short[1] ;
      BC000515_n6SecUserId = new boolean[] {false} ;
      BC000515_A4SecRoleId = new short[1] ;
      BC000516_A6SecUserId = new short[1] ;
      BC000516_n6SecUserId = new boolean[] {false} ;
      BC000516_A14SecUserName = new String[] {""} ;
      BC000516_A15SecUserPassword = new String[] {""} ;
      BC000516_A122SecUserEmail = new String[] {""} ;
      BC000516_A211SecUserEstadoR = new String[] {""} ;
      i211SecUserEstadoR = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secuser_bc__default(),
         new Object[] {
             new Object[] {
            BC00052_A6SecUserId, BC00052_A14SecUserName, BC00052_A15SecUserPassword, BC00052_A122SecUserEmail, BC00052_A211SecUserEstadoR
            }
            , new Object[] {
            BC00053_A6SecUserId, BC00053_A14SecUserName, BC00053_A15SecUserPassword, BC00053_A122SecUserEmail, BC00053_A211SecUserEstadoR
            }
            , new Object[] {
            BC00054_A6SecUserId, BC00054_A14SecUserName, BC00054_A15SecUserPassword, BC00054_A122SecUserEmail, BC00054_A211SecUserEstadoR
            }
            , new Object[] {
            BC00055_A6SecUserId
            }
            , new Object[] {
            BC00056_A6SecUserId, BC00056_A14SecUserName, BC00056_A15SecUserPassword, BC00056_A122SecUserEmail, BC00056_A211SecUserEstadoR
            }
            , new Object[] {
            BC00057_A6SecUserId, BC00057_A14SecUserName, BC00057_A15SecUserPassword, BC00057_A122SecUserEmail, BC00057_A211SecUserEstadoR
            }
            , new Object[] {
            BC00058_A6SecUserId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000511_A20PacienteId
            }
            , new Object[] {
            BC000512_A31ProfesionalId
            }
            , new Object[] {
            BC000513_A40LaboratorioId, BC000513_A6SecUserId
            }
            , new Object[] {
            BC000514_A36DrogueriaId, BC000514_A6SecUserId
            }
            , new Object[] {
            BC000515_A6SecUserId, BC000515_A4SecRoleId
            }
            , new Object[] {
            BC000516_A6SecUserId, BC000516_A14SecUserName, BC000516_A15SecUserPassword, BC000516_A122SecUserEmail, BC000516_A211SecUserEstadoR
            }
         }
      );
      Z211SecUserEstadoR = "A" ;
      A211SecUserEstadoR = "A" ;
      i211SecUserEstadoR = "A" ;
      AV16Pgmname = "WWPBaseObjects.SecUser_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12052 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z6SecUserId ;
   private short A6SecUserId ;
   private short RcdFound6 ;
   private short nIsDirty_6 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV16Pgmname ;
   private String Z211SecUserEstadoR ;
   private String A211SecUserEstadoR ;
   private String sMode6 ;
   private String i211SecUserEstadoR ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n6SecUserId ;
   private boolean mustCommit ;
   private String Z14SecUserName ;
   private String A14SecUserName ;
   private String Z15SecUserPassword ;
   private String A15SecUserPassword ;
   private String Z122SecUserEmail ;
   private String A122SecUserEmail ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.projectthani.wwpbaseobjects.SdtSecUser bcwwpbaseobjects_SecUser ;
   private IDataStoreProvider pr_default ;
   private short[] BC00054_A6SecUserId ;
   private boolean[] BC00054_n6SecUserId ;
   private String[] BC00054_A14SecUserName ;
   private String[] BC00054_A15SecUserPassword ;
   private String[] BC00054_A122SecUserEmail ;
   private String[] BC00054_A211SecUserEstadoR ;
   private short[] BC00055_A6SecUserId ;
   private boolean[] BC00055_n6SecUserId ;
   private short[] BC00056_A6SecUserId ;
   private boolean[] BC00056_n6SecUserId ;
   private String[] BC00056_A14SecUserName ;
   private String[] BC00056_A15SecUserPassword ;
   private String[] BC00056_A122SecUserEmail ;
   private String[] BC00056_A211SecUserEstadoR ;
   private short[] BC00057_A6SecUserId ;
   private boolean[] BC00057_n6SecUserId ;
   private String[] BC00057_A14SecUserName ;
   private String[] BC00057_A15SecUserPassword ;
   private String[] BC00057_A122SecUserEmail ;
   private String[] BC00057_A211SecUserEstadoR ;
   private short[] BC00058_A6SecUserId ;
   private boolean[] BC00058_n6SecUserId ;
   private int[] BC000511_A20PacienteId ;
   private int[] BC000512_A31ProfesionalId ;
   private short[] BC000513_A40LaboratorioId ;
   private short[] BC000513_A6SecUserId ;
   private boolean[] BC000513_n6SecUserId ;
   private short[] BC000514_A36DrogueriaId ;
   private short[] BC000514_A6SecUserId ;
   private boolean[] BC000514_n6SecUserId ;
   private short[] BC000515_A6SecUserId ;
   private boolean[] BC000515_n6SecUserId ;
   private short[] BC000515_A4SecRoleId ;
   private short[] BC000516_A6SecUserId ;
   private boolean[] BC000516_n6SecUserId ;
   private String[] BC000516_A14SecUserName ;
   private String[] BC000516_A15SecUserPassword ;
   private String[] BC000516_A122SecUserEmail ;
   private String[] BC000516_A211SecUserEstadoR ;
   private short[] BC00052_A6SecUserId ;
   private String[] BC00052_A14SecUserName ;
   private String[] BC00052_A15SecUserPassword ;
   private String[] BC00052_A122SecUserEmail ;
   private String[] BC00052_A211SecUserEstadoR ;
   private short[] BC00053_A6SecUserId ;
   private String[] BC00053_A14SecUserName ;
   private String[] BC00053_A15SecUserPassword ;
   private String[] BC00053_A122SecUserEmail ;
   private String[] BC00053_A211SecUserEstadoR ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV15WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class secuser_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00052", "SELECT [SecUserId], [SecUserName], [SecUserPassword], [SecUserEmail], [SecUserEstadoR] FROM [SecUser] WITH (UPDLOCK) WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00053", "SELECT [SecUserId], [SecUserName], [SecUserPassword], [SecUserEmail], [SecUserEstadoR] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00054", "SELECT TM1.[SecUserId], TM1.[SecUserName], TM1.[SecUserPassword], TM1.[SecUserEmail], TM1.[SecUserEstadoR] FROM [SecUser] TM1 WHERE TM1.[SecUserId] = ? ORDER BY TM1.[SecUserId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00055", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00056", "SELECT [SecUserId], [SecUserName], [SecUserPassword], [SecUserEmail], [SecUserEstadoR] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00057", "SELECT [SecUserId], [SecUserName], [SecUserPassword], [SecUserEmail], [SecUserEstadoR] FROM [SecUser] WITH (UPDLOCK) WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00058", "INSERT INTO [SecUser]([SecUserName], [SecUserPassword], [SecUserEmail], [SecUserEstadoR]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC00059", "UPDATE [SecUser] SET [SecUserName]=?, [SecUserPassword]=?, [SecUserEmail]=?, [SecUserEstadoR]=?  WHERE [SecUserId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000510", "DELETE FROM [SecUser]  WHERE [SecUserId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000511", "SELECT TOP 1 [PacienteId] FROM [Paciente] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000512", "SELECT TOP 1 [ProfesionalId] FROM [Profesional] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000513", "SELECT TOP 1 [LaboratorioId], [SecUserId] FROM [LaboratorioLaboratorioUsuarios] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000514", "SELECT TOP 1 [DrogueriaId], [SecUserId] FROM [DrogueriaUsuarios] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000515", "SELECT TOP 1 [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000516", "SELECT TM1.[SecUserId], TM1.[SecUserName], TM1.[SecUserPassword], TM1.[SecUserEmail], TM1.[SecUserEstadoR] FROM [SecUser] TM1 WHERE TM1.[SecUserId] = ? ORDER BY TM1.[SecUserId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
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
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setString(4, (String)parms[3], 1);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[5]).shortValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
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
      }
   }

}

