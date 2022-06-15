package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secuserrole_bc extends GXWebPanel implements IGxSilentTrn
{
   public secuserrole_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secuserrole_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secuserrole_bc.class ));
   }

   public secuserrole_bc( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow067( ) ;
      standaloneNotModal( ) ;
      initializeNonKey067( ) ;
      standaloneModal( ) ;
      addRow067( ) ;
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z6SecUserId = A6SecUserId ;
            Z4SecRoleId = A4SecRoleId ;
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

   public void confirm_060( )
   {
      beforeValidate067( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls067( ) ;
         }
         else
         {
            checkExtendedTable067( ) ;
            if ( AnyError == 0 )
            {
               zm067( 2) ;
               zm067( 3) ;
            }
            closeExtendedTableCursors067( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm067( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z14SecUserName = A14SecUserName ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z13SecRoleName = A13SecRoleName ;
         Z12SecRoleDescription = A12SecRoleDescription ;
      }
      if ( GX_JID == -1 )
      {
         Z6SecUserId = A6SecUserId ;
         Z4SecRoleId = A4SecRoleId ;
         Z14SecUserName = A14SecUserName ;
         Z13SecRoleName = A13SecRoleName ;
         Z12SecRoleDescription = A12SecRoleDescription ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load067( )
   {
      /* Using cursor BC00066 */
      pr_default.execute(4, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A14SecUserName = BC00066_A14SecUserName[0] ;
         A13SecRoleName = BC00066_A13SecRoleName[0] ;
         A12SecRoleDescription = BC00066_A12SecRoleDescription[0] ;
         zm067( -1) ;
      }
      pr_default.close(4);
      onLoadActions067( ) ;
   }

   public void onLoadActions067( )
   {
   }

   public void checkExtendedTable067( )
   {
      nIsDirty_7 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC00067 */
      pr_default.execute(5, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
      }
      A14SecUserName = BC00067_A14SecUserName[0] ;
      pr_default.close(5);
      /* Using cursor BC00068 */
      pr_default.execute(6, new Object[] {Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
      }
      A13SecRoleName = BC00068_A13SecRoleName[0] ;
      A12SecRoleDescription = BC00068_A12SecRoleDescription[0] ;
      pr_default.close(6);
   }

   public void closeExtendedTableCursors067( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey067( )
   {
      /* Using cursor BC00069 */
      pr_default.execute(7, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound7 = (short)(1) ;
      }
      else
      {
         RcdFound7 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000610 */
      pr_default.execute(8, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm067( 1) ;
         RcdFound7 = (short)(1) ;
         A6SecUserId = BC000610_A6SecUserId[0] ;
         A4SecRoleId = BC000610_A4SecRoleId[0] ;
         Z6SecUserId = A6SecUserId ;
         Z4SecRoleId = A4SecRoleId ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load067( ) ;
         if ( AnyError == 1 )
         {
            RcdFound7 = (short)(0) ;
            initializeNonKey067( ) ;
         }
         Gx_mode = sMode7 ;
      }
      else
      {
         RcdFound7 = (short)(0) ;
         initializeNonKey067( ) ;
         sMode7 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode7 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey067( ) ;
      if ( RcdFound7 == 0 )
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
      confirm_060( ) ;
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

   public void checkOptimisticConcurrency067( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000611 */
         pr_default.execute(9, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecUserRole"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecUserRole"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert067( )
   {
      beforeValidate067( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable067( ) ;
      }
      if ( AnyError == 0 )
      {
         zm067( 0) ;
         checkOptimisticConcurrency067( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm067( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert067( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000612 */
                  pr_default.execute(10, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUserRole");
                  if ( (pr_default.getStatus(10) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
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
            load067( ) ;
         }
         endLevel067( ) ;
      }
      closeExtendedTableCursors067( ) ;
   }

   public void update067( )
   {
      beforeValidate067( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable067( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency067( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm067( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate067( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table [SecUserRole] */
                  deferredUpdate067( ) ;
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
         endLevel067( ) ;
      }
      closeExtendedTableCursors067( ) ;
   }

   public void deferredUpdate067( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate067( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency067( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls067( ) ;
         afterConfirm067( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete067( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000613 */
               pr_default.execute(11, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUserRole");
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
      sMode7 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel067( ) ;
      Gx_mode = sMode7 ;
   }

   public void onDeleteControls067( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000614 */
         pr_default.execute(12, new Object[] {Short.valueOf(A6SecUserId)});
         A14SecUserName = BC000614_A14SecUserName[0] ;
         pr_default.close(12);
         /* Using cursor BC000615 */
         pr_default.execute(13, new Object[] {Short.valueOf(A4SecRoleId)});
         A13SecRoleName = BC000615_A13SecRoleName[0] ;
         A12SecRoleDescription = BC000615_A12SecRoleDescription[0] ;
         pr_default.close(13);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000616 */
         pr_default.execute(14, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Log Accesos"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
   }

   public void endLevel067( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete067( ) ;
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

   public void scanKeyStart067( )
   {
      /* Using cursor BC000617 */
      pr_default.execute(15, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
      RcdFound7 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A14SecUserName = BC000617_A14SecUserName[0] ;
         A13SecRoleName = BC000617_A13SecRoleName[0] ;
         A12SecRoleDescription = BC000617_A12SecRoleDescription[0] ;
         A6SecUserId = BC000617_A6SecUserId[0] ;
         A4SecRoleId = BC000617_A4SecRoleId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext067( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound7 = (short)(0) ;
      scanKeyLoad067( ) ;
   }

   public void scanKeyLoad067( )
   {
      sMode7 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound7 = (short)(1) ;
         A14SecUserName = BC000617_A14SecUserName[0] ;
         A13SecRoleName = BC000617_A13SecRoleName[0] ;
         A12SecRoleDescription = BC000617_A12SecRoleDescription[0] ;
         A6SecUserId = BC000617_A6SecUserId[0] ;
         A4SecRoleId = BC000617_A4SecRoleId[0] ;
      }
      Gx_mode = sMode7 ;
   }

   public void scanKeyEnd067( )
   {
      pr_default.close(15);
   }

   public void afterConfirm067( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert067( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate067( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete067( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete067( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate067( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes067( )
   {
   }

   public void send_integrity_lvl_hashes067( )
   {
   }

   public void addRow067( )
   {
      VarsToRow7( bcwwpbaseobjects_SecUserRole) ;
   }

   public void readRow067( )
   {
      RowToVars7( bcwwpbaseobjects_SecUserRole, 1) ;
   }

   public void initializeNonKey067( )
   {
      A14SecUserName = "" ;
      A13SecRoleName = "" ;
      A12SecRoleDescription = "" ;
   }

   public void initAll067( )
   {
      A6SecUserId = (short)(0) ;
      A4SecRoleId = (short)(0) ;
      initializeNonKey067( ) ;
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

   public void VarsToRow7( com.projectthani.wwpbaseobjects.SdtSecUserRole obj7 )
   {
      obj7.setgxTv_SdtSecUserRole_Mode( Gx_mode );
      obj7.setgxTv_SdtSecUserRole_Secusername( A14SecUserName );
      obj7.setgxTv_SdtSecUserRole_Secrolename( A13SecRoleName );
      obj7.setgxTv_SdtSecUserRole_Secroledescription( A12SecRoleDescription );
      obj7.setgxTv_SdtSecUserRole_Secuserid( A6SecUserId );
      obj7.setgxTv_SdtSecUserRole_Secroleid( A4SecRoleId );
      obj7.setgxTv_SdtSecUserRole_Secuserid_Z( Z6SecUserId );
      obj7.setgxTv_SdtSecUserRole_Secroleid_Z( Z4SecRoleId );
      obj7.setgxTv_SdtSecUserRole_Secusername_Z( Z14SecUserName );
      obj7.setgxTv_SdtSecUserRole_Secrolename_Z( Z13SecRoleName );
      obj7.setgxTv_SdtSecUserRole_Secroledescription_Z( Z12SecRoleDescription );
      obj7.setgxTv_SdtSecUserRole_Mode( Gx_mode );
   }

   public void KeyVarsToRow7( com.projectthani.wwpbaseobjects.SdtSecUserRole obj7 )
   {
      obj7.setgxTv_SdtSecUserRole_Secuserid( A6SecUserId );
      obj7.setgxTv_SdtSecUserRole_Secroleid( A4SecRoleId );
   }

   public void RowToVars7( com.projectthani.wwpbaseobjects.SdtSecUserRole obj7 ,
                           int forceLoad )
   {
      Gx_mode = obj7.getgxTv_SdtSecUserRole_Mode() ;
      A14SecUserName = obj7.getgxTv_SdtSecUserRole_Secusername() ;
      A13SecRoleName = obj7.getgxTv_SdtSecUserRole_Secrolename() ;
      A12SecRoleDescription = obj7.getgxTv_SdtSecUserRole_Secroledescription() ;
      A6SecUserId = obj7.getgxTv_SdtSecUserRole_Secuserid() ;
      A4SecRoleId = obj7.getgxTv_SdtSecUserRole_Secroleid() ;
      Z6SecUserId = obj7.getgxTv_SdtSecUserRole_Secuserid_Z() ;
      Z4SecRoleId = obj7.getgxTv_SdtSecUserRole_Secroleid_Z() ;
      Z14SecUserName = obj7.getgxTv_SdtSecUserRole_Secusername_Z() ;
      Z13SecRoleName = obj7.getgxTv_SdtSecUserRole_Secrolename_Z() ;
      Z12SecRoleDescription = obj7.getgxTv_SdtSecUserRole_Secroledescription_Z() ;
      Gx_mode = obj7.getgxTv_SdtSecUserRole_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A6SecUserId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      A4SecRoleId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey067( ) ;
      scanKeyStart067( ) ;
      if ( RcdFound7 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000618 */
         pr_default.execute(16, new Object[] {Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(16) == 101) )
         {
            httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
            AnyError = (short)(1) ;
         }
         A14SecUserName = BC000618_A14SecUserName[0] ;
         pr_default.close(16);
         /* Using cursor BC000619 */
         pr_default.execute(17, new Object[] {Short.valueOf(A4SecRoleId)});
         if ( (pr_default.getStatus(17) == 101) )
         {
            httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
            AnyError = (short)(1) ;
         }
         A13SecRoleName = BC000619_A13SecRoleName[0] ;
         A12SecRoleDescription = BC000619_A12SecRoleDescription[0] ;
         pr_default.close(17);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z6SecUserId = A6SecUserId ;
         Z4SecRoleId = A4SecRoleId ;
      }
      zm067( -1) ;
      onLoadActions067( ) ;
      addRow067( ) ;
      scanKeyEnd067( ) ;
      if ( RcdFound7 == 0 )
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
      RowToVars7( bcwwpbaseobjects_SecUserRole, 0) ;
      scanKeyStart067( ) ;
      if ( RcdFound7 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000620 */
         pr_default.execute(18, new Object[] {Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(18) == 101) )
         {
            httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
            AnyError = (short)(1) ;
         }
         A14SecUserName = BC000620_A14SecUserName[0] ;
         pr_default.close(18);
         /* Using cursor BC000621 */
         pr_default.execute(19, new Object[] {Short.valueOf(A4SecRoleId)});
         if ( (pr_default.getStatus(19) == 101) )
         {
            httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
            AnyError = (short)(1) ;
         }
         A13SecRoleName = BC000621_A13SecRoleName[0] ;
         A12SecRoleDescription = BC000621_A12SecRoleDescription[0] ;
         pr_default.close(19);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z6SecUserId = A6SecUserId ;
         Z4SecRoleId = A4SecRoleId ;
      }
      zm067( -1) ;
      onLoadActions067( ) ;
      addRow067( ) ;
      scanKeyEnd067( ) ;
      if ( RcdFound7 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey067( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert067( ) ;
      }
      else
      {
         if ( RcdFound7 == 1 )
         {
            if ( ( A6SecUserId != Z6SecUserId ) || ( A4SecRoleId != Z4SecRoleId ) )
            {
               A6SecUserId = Z6SecUserId ;
               A4SecRoleId = Z4SecRoleId ;
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
               update067( ) ;
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
               if ( ( A6SecUserId != Z6SecUserId ) || ( A4SecRoleId != Z4SecRoleId ) )
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
                     insert067( ) ;
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
                     insert067( ) ;
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
      RowToVars7( bcwwpbaseobjects_SecUserRole, 1) ;
      saveImpl( ) ;
      VarsToRow7( bcwwpbaseobjects_SecUserRole) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars7( bcwwpbaseobjects_SecUserRole, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert067( ) ;
      afterTrn( ) ;
      VarsToRow7( bcwwpbaseobjects_SecUserRole) ;
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
         com.projectthani.wwpbaseobjects.SdtSecUserRole auxBC = new com.projectthani.wwpbaseobjects.SdtSecUserRole( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A6SecUserId, A4SecRoleId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_SecUserRole);
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
      RowToVars7( bcwwpbaseobjects_SecUserRole, 1) ;
      updateImpl( ) ;
      VarsToRow7( bcwwpbaseobjects_SecUserRole) ;
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
      RowToVars7( bcwwpbaseobjects_SecUserRole, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert067( ) ;
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
      VarsToRow7( bcwwpbaseobjects_SecUserRole) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars7( bcwwpbaseobjects_SecUserRole, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey067( ) ;
      if ( RcdFound7 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A6SecUserId != Z6SecUserId ) || ( A4SecRoleId != Z4SecRoleId ) )
         {
            A6SecUserId = Z6SecUserId ;
            A4SecRoleId = Z4SecRoleId ;
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
         if ( ( A6SecUserId != Z6SecUserId ) || ( A4SecRoleId != Z4SecRoleId ) )
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
      pr_default.close(18);
      pr_default.close(16);
      pr_default.close(12);
      pr_default.close(2);
      pr_default.close(19);
      pr_default.close(17);
      pr_default.close(13);
      pr_default.close(3);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secuserrole_bc");
      VarsToRow7( bcwwpbaseobjects_SecUserRole) ;
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
      Gx_mode = bcwwpbaseobjects_SecUserRole.getgxTv_SdtSecUserRole_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_SecUserRole.setgxTv_SdtSecUserRole_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.wwpbaseobjects.SdtSecUserRole sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_SecUserRole )
      {
         bcwwpbaseobjects_SecUserRole = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_SecUserRole.getgxTv_SdtSecUserRole_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecUserRole.setgxTv_SdtSecUserRole_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow7( bcwwpbaseobjects_SecUserRole) ;
         }
         else
         {
            RowToVars7( bcwwpbaseobjects_SecUserRole, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_SecUserRole.getgxTv_SdtSecUserRole_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecUserRole.setgxTv_SdtSecUserRole_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars7( bcwwpbaseobjects_SecUserRole, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtSecUserRole getSecUserRole_BC( )
   {
      return bcwwpbaseobjects_SecUserRole ;
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
      Z14SecUserName = "" ;
      A14SecUserName = "" ;
      Z13SecRoleName = "" ;
      A13SecRoleName = "" ;
      Z12SecRoleDescription = "" ;
      A12SecRoleDescription = "" ;
      BC00066_A14SecUserName = new String[] {""} ;
      BC00066_A13SecRoleName = new String[] {""} ;
      BC00066_A12SecRoleDescription = new String[] {""} ;
      BC00066_A6SecUserId = new short[1] ;
      BC00066_A4SecRoleId = new short[1] ;
      BC00067_A14SecUserName = new String[] {""} ;
      BC00068_A13SecRoleName = new String[] {""} ;
      BC00068_A12SecRoleDescription = new String[] {""} ;
      BC00069_A6SecUserId = new short[1] ;
      BC00069_A4SecRoleId = new short[1] ;
      BC000610_A6SecUserId = new short[1] ;
      BC000610_A4SecRoleId = new short[1] ;
      sMode7 = "" ;
      BC000611_A6SecUserId = new short[1] ;
      BC000611_A4SecRoleId = new short[1] ;
      BC000614_A14SecUserName = new String[] {""} ;
      BC000615_A13SecRoleName = new String[] {""} ;
      BC000615_A12SecRoleDescription = new String[] {""} ;
      BC000616_A41LogAccesosId = new short[1] ;
      BC000617_A14SecUserName = new String[] {""} ;
      BC000617_A13SecRoleName = new String[] {""} ;
      BC000617_A12SecRoleDescription = new String[] {""} ;
      BC000617_A6SecUserId = new short[1] ;
      BC000617_A4SecRoleId = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000618_A14SecUserName = new String[] {""} ;
      BC000619_A13SecRoleName = new String[] {""} ;
      BC000619_A12SecRoleDescription = new String[] {""} ;
      BC000620_A14SecUserName = new String[] {""} ;
      BC000621_A13SecRoleName = new String[] {""} ;
      BC000621_A12SecRoleDescription = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secuserrole_bc__default(),
         new Object[] {
             new Object[] {
            BC00062_A6SecUserId, BC00062_A4SecRoleId
            }
            , new Object[] {
            BC00063_A6SecUserId, BC00063_A4SecRoleId
            }
            , new Object[] {
            BC00064_A14SecUserName
            }
            , new Object[] {
            BC00065_A13SecRoleName, BC00065_A12SecRoleDescription
            }
            , new Object[] {
            BC00066_A14SecUserName, BC00066_A13SecRoleName, BC00066_A12SecRoleDescription, BC00066_A6SecUserId, BC00066_A4SecRoleId
            }
            , new Object[] {
            BC00067_A14SecUserName
            }
            , new Object[] {
            BC00068_A13SecRoleName, BC00068_A12SecRoleDescription
            }
            , new Object[] {
            BC00069_A6SecUserId, BC00069_A4SecRoleId
            }
            , new Object[] {
            BC000610_A6SecUserId, BC000610_A4SecRoleId
            }
            , new Object[] {
            BC000611_A6SecUserId, BC000611_A4SecRoleId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000614_A14SecUserName
            }
            , new Object[] {
            BC000615_A13SecRoleName, BC000615_A12SecRoleDescription
            }
            , new Object[] {
            BC000616_A41LogAccesosId
            }
            , new Object[] {
            BC000617_A14SecUserName, BC000617_A13SecRoleName, BC000617_A12SecRoleDescription, BC000617_A6SecUserId, BC000617_A4SecRoleId
            }
            , new Object[] {
            BC000618_A14SecUserName
            }
            , new Object[] {
            BC000619_A13SecRoleName, BC000619_A12SecRoleDescription
            }
            , new Object[] {
            BC000620_A14SecUserName
            }
            , new Object[] {
            BC000621_A13SecRoleName, BC000621_A12SecRoleDescription
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z6SecUserId ;
   private short A6SecUserId ;
   private short Z4SecRoleId ;
   private short A4SecRoleId ;
   private short RcdFound7 ;
   private short nIsDirty_7 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode7 ;
   private boolean mustCommit ;
   private String Z14SecUserName ;
   private String A14SecUserName ;
   private String Z13SecRoleName ;
   private String A13SecRoleName ;
   private String Z12SecRoleDescription ;
   private String A12SecRoleDescription ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.wwpbaseobjects.SdtSecUserRole bcwwpbaseobjects_SecUserRole ;
   private IDataStoreProvider pr_default ;
   private String[] BC00066_A14SecUserName ;
   private String[] BC00066_A13SecRoleName ;
   private String[] BC00066_A12SecRoleDescription ;
   private short[] BC00066_A6SecUserId ;
   private short[] BC00066_A4SecRoleId ;
   private String[] BC00067_A14SecUserName ;
   private String[] BC00068_A13SecRoleName ;
   private String[] BC00068_A12SecRoleDescription ;
   private short[] BC00069_A6SecUserId ;
   private short[] BC00069_A4SecRoleId ;
   private short[] BC000610_A6SecUserId ;
   private short[] BC000610_A4SecRoleId ;
   private short[] BC000611_A6SecUserId ;
   private short[] BC000611_A4SecRoleId ;
   private String[] BC000614_A14SecUserName ;
   private String[] BC000615_A13SecRoleName ;
   private String[] BC000615_A12SecRoleDescription ;
   private short[] BC000616_A41LogAccesosId ;
   private String[] BC000617_A14SecUserName ;
   private String[] BC000617_A13SecRoleName ;
   private String[] BC000617_A12SecRoleDescription ;
   private short[] BC000617_A6SecUserId ;
   private short[] BC000617_A4SecRoleId ;
   private String[] BC000618_A14SecUserName ;
   private String[] BC000619_A13SecRoleName ;
   private String[] BC000619_A12SecRoleDescription ;
   private String[] BC000620_A14SecUserName ;
   private String[] BC000621_A13SecRoleName ;
   private String[] BC000621_A12SecRoleDescription ;
   private short[] BC00062_A6SecUserId ;
   private short[] BC00062_A4SecRoleId ;
   private short[] BC00063_A6SecUserId ;
   private short[] BC00063_A4SecRoleId ;
   private String[] BC00064_A14SecUserName ;
   private String[] BC00065_A13SecRoleName ;
   private String[] BC00065_A12SecRoleDescription ;
}

final  class secuserrole_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00062", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WITH (UPDLOCK) WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00063", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00064", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00065", "SELECT [SecRoleName], [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00066", "SELECT T2.[SecUserName], T3.[SecRoleName], T3.[SecRoleDescription], TM1.[SecUserId], TM1.[SecRoleId] FROM (([SecUserRole] TM1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = TM1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = TM1.[SecRoleId]) WHERE TM1.[SecUserId] = ? and TM1.[SecRoleId] = ? ORDER BY TM1.[SecUserId], TM1.[SecRoleId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00067", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00068", "SELECT [SecRoleName], [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00069", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? AND [SecRoleId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000610", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000611", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WITH (UPDLOCK) WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000612", "INSERT INTO [SecUserRole]([SecUserId], [SecRoleId]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000613", "DELETE FROM [SecUserRole]  WHERE [SecUserId] = ? AND [SecRoleId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000614", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000615", "SELECT [SecRoleName], [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000616", "SELECT TOP 1 [LogAccesosId] FROM [LogAccesos] WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000617", "SELECT T2.[SecUserName], T3.[SecRoleName], T3.[SecRoleDescription], TM1.[SecUserId], TM1.[SecRoleId] FROM (([SecUserRole] TM1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = TM1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = TM1.[SecRoleId]) WHERE TM1.[SecUserId] = ? and TM1.[SecRoleId] = ? ORDER BY TM1.[SecUserId], TM1.[SecRoleId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000618", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000619", "SELECT [SecRoleName], [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000620", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000621", "SELECT [SecRoleName], [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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

