package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class especialidad_bc extends GXWebPanel implements IGxSilentTrn
{
   public especialidad_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public especialidad_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( especialidad_bc.class ));
   }

   public especialidad_bc( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0M30( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0M30( ) ;
      standaloneModal( ) ;
      addRow0M30( ) ;
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
         e110M2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z32EspecialidadId = A32EspecialidadId ;
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

   public void confirm_0M0( )
   {
      beforeValidate0M30( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0M30( ) ;
         }
         else
         {
            checkExtendedTable0M30( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0M30( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode30 = Gx_mode ;
         confirm_0M31( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode30 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode30 ;
      }
   }

   public void confirm_0M31( )
   {
      nGXsfl_31_idx = 0 ;
      while ( nGXsfl_31_idx < bcEspecialidad.getgxTv_SdtEspecialidad_Sede().size() )
      {
         readRow0M31( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound31 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_31 != 0 ) )
         {
            getKey0M31( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound31 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0M31( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0M31( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0M31( 5) ;
                        zm0M31( 6) ;
                     }
                     closeExtendedTableCursors0M31( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound31 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0M31( ) ;
                     load0M31( ) ;
                     beforeValidate0M31( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0M31( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_31 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0M31( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0M31( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0M31( 5) ;
                              zm0M31( 6) ;
                           }
                           closeExtendedTableCursors0M31( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow31( ((com.projectthani.SdtEspecialidad_Sede)bcEspecialidad.getgxTv_SdtEspecialidad_Sede().elementAt(-1+nGXsfl_31_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e120M2( )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad_Insert", GXv_boolean3) ;
         especialidad_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad_Update", GXv_boolean3) ;
         especialidad_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad_Delete", GXv_boolean3) ;
         especialidad_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV21Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
   }

   public void e110M2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0M30( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z71EspecialidadNombre = A71EspecialidadNombre ;
         Z154EspecialidadDescripcion = A154EspecialidadDescripcion ;
         Z140EspecialidadCodigo = A140EspecialidadCodigo ;
         Z156EspecialidadEstado = A156EspecialidadEstado ;
      }
      if ( GX_JID == -3 )
      {
         Z32EspecialidadId = A32EspecialidadId ;
         Z71EspecialidadNombre = A71EspecialidadNombre ;
         Z154EspecialidadDescripcion = A154EspecialidadDescripcion ;
         Z140EspecialidadCodigo = A140EspecialidadCodigo ;
         Z155EspecialidadFoto = A155EspecialidadFoto ;
         Z40000EspecialidadFoto_GXI = A40000EspecialidadFoto_GXI ;
         Z156EspecialidadEstado = A156EspecialidadEstado ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0M30( )
   {
      /* Using cursor BC000M8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A71EspecialidadNombre = BC000M8_A71EspecialidadNombre[0] ;
         A154EspecialidadDescripcion = BC000M8_A154EspecialidadDescripcion[0] ;
         A140EspecialidadCodigo = BC000M8_A140EspecialidadCodigo[0] ;
         A155EspecialidadFoto = BC000M8_A155EspecialidadFoto[0] ;
         A40000EspecialidadFoto_GXI = BC000M8_A40000EspecialidadFoto_GXI[0] ;
         A156EspecialidadEstado = BC000M8_A156EspecialidadEstado[0] ;
         zm0M30( -3) ;
      }
      pr_default.close(6);
      onLoadActions0M30( ) ;
   }

   public void onLoadActions0M30( )
   {
      AV21Pgmname = "Especialidad_BC" ;
   }

   public void checkExtendedTable0M30( )
   {
      nIsDirty_30 = (short)(0) ;
      standaloneModal( ) ;
      AV21Pgmname = "Especialidad_BC" ;
      if ( ! ( ( GXutil.strcmp(A156EspecialidadEstado, "A") == 0 ) || ( GXutil.strcmp(A156EspecialidadEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Especialidad Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0M30( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0M30( )
   {
      /* Using cursor BC000M9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound30 = (short)(1) ;
      }
      else
      {
         RcdFound30 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000M10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0M30( 3) ;
         RcdFound30 = (short)(1) ;
         A32EspecialidadId = BC000M10_A32EspecialidadId[0] ;
         A71EspecialidadNombre = BC000M10_A71EspecialidadNombre[0] ;
         A154EspecialidadDescripcion = BC000M10_A154EspecialidadDescripcion[0] ;
         A140EspecialidadCodigo = BC000M10_A140EspecialidadCodigo[0] ;
         A155EspecialidadFoto = BC000M10_A155EspecialidadFoto[0] ;
         A40000EspecialidadFoto_GXI = BC000M10_A40000EspecialidadFoto_GXI[0] ;
         A156EspecialidadEstado = BC000M10_A156EspecialidadEstado[0] ;
         Z32EspecialidadId = A32EspecialidadId ;
         sMode30 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0M30( ) ;
         if ( AnyError == 1 )
         {
            RcdFound30 = (short)(0) ;
            initializeNonKey0M30( ) ;
         }
         Gx_mode = sMode30 ;
      }
      else
      {
         RcdFound30 = (short)(0) ;
         initializeNonKey0M30( ) ;
         sMode30 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode30 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0M30( ) ;
      if ( RcdFound30 == 0 )
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
      confirm_0M0( ) ;
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

   public void checkOptimisticConcurrency0M30( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000M11 */
         pr_default.execute(9, new Object[] {Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Especialidad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z71EspecialidadNombre, BC000M11_A71EspecialidadNombre[0]) != 0 ) || ( GXutil.strcmp(Z154EspecialidadDescripcion, BC000M11_A154EspecialidadDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z140EspecialidadCodigo, BC000M11_A140EspecialidadCodigo[0]) != 0 ) || ( GXutil.strcmp(Z156EspecialidadEstado, BC000M11_A156EspecialidadEstado[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Especialidad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0M30( )
   {
      beforeValidate0M30( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0M30( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0M30( 0) ;
         checkOptimisticConcurrency0M30( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0M30( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0M30( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000M12 */
                  pr_default.execute(10, new Object[] {A71EspecialidadNombre, A154EspecialidadDescripcion, A140EspecialidadCodigo, A155EspecialidadFoto, A40000EspecialidadFoto_GXI, A156EspecialidadEstado});
                  A32EspecialidadId = BC000M12_A32EspecialidadId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Especialidad");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0M30( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                        }
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
            load0M30( ) ;
         }
         endLevel0M30( ) ;
      }
      closeExtendedTableCursors0M30( ) ;
   }

   public void update0M30( )
   {
      beforeValidate0M30( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0M30( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0M30( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0M30( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0M30( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000M13 */
                  pr_default.execute(11, new Object[] {A71EspecialidadNombre, A154EspecialidadDescripcion, A140EspecialidadCodigo, A156EspecialidadEstado, Short.valueOf(A32EspecialidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Especialidad");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Especialidad"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0M30( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0M30( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
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
         }
         endLevel0M30( ) ;
      }
      closeExtendedTableCursors0M30( ) ;
   }

   public void deferredUpdate0M30( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000M14 */
         pr_default.execute(12, new Object[] {A155EspecialidadFoto, A40000EspecialidadFoto_GXI, Short.valueOf(A32EspecialidadId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Especialidad");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0M30( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0M30( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0M30( ) ;
         afterConfirm0M30( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0M30( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart0M31( ) ;
               while ( RcdFound31 != 0 )
               {
                  getByPrimaryKey0M31( ) ;
                  delete0M31( ) ;
                  scanKeyNext0M31( ) ;
               }
               scanKeyEnd0M31( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000M15 */
                  pr_default.execute(13, new Object[] {Short.valueOf(A32EspecialidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Especialidad");
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
      }
      sMode30 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0M30( ) ;
      Gx_mode = sMode30 ;
   }

   public void onDeleteControls0M30( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV21Pgmname = "Especialidad_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000M16 */
         pr_default.execute(14, new Object[] {Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Especialidad"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
   }

   public void processNestedLevel0M31( )
   {
      nGXsfl_31_idx = 0 ;
      while ( nGXsfl_31_idx < bcEspecialidad.getgxTv_SdtEspecialidad_Sede().size() )
      {
         readRow0M31( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound31 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_31 != 0 ) )
         {
            standaloneNotModal0M31( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0M31( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0M31( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0M31( ) ;
               }
            }
         }
         KeyVarsToRow31( ((com.projectthani.SdtEspecialidad_Sede)bcEspecialidad.getgxTv_SdtEspecialidad_Sede().elementAt(-1+nGXsfl_31_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_31_idx = 0 ;
         while ( nGXsfl_31_idx < bcEspecialidad.getgxTv_SdtEspecialidad_Sede().size() )
         {
            readRow0M31( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound31 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcEspecialidad.getgxTv_SdtEspecialidad_Sede().removeElement(nGXsfl_31_idx);
               nGXsfl_31_idx = (int)(nGXsfl_31_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0M31( ) ;
               VarsToRow31( ((com.projectthani.SdtEspecialidad_Sede)bcEspecialidad.getgxTv_SdtEspecialidad_Sede().elementAt(-1+nGXsfl_31_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0M31( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_31 = (short)(0) ;
      nIsMod_31 = (short)(0) ;
      Gxremove31 = (byte)(0) ;
   }

   public void processLevel0M30( )
   {
      /* Save parent mode. */
      sMode30 = Gx_mode ;
      processNestedLevel0M31( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode30 ;
      /* ' Update level parameters */
   }

   public void endLevel0M30( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0M30( ) ;
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

   public void scanKeyStart0M30( )
   {
      /* Scan By routine */
      /* Using cursor BC000M17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A32EspecialidadId)});
      RcdFound30 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A32EspecialidadId = BC000M17_A32EspecialidadId[0] ;
         A71EspecialidadNombre = BC000M17_A71EspecialidadNombre[0] ;
         A154EspecialidadDescripcion = BC000M17_A154EspecialidadDescripcion[0] ;
         A140EspecialidadCodigo = BC000M17_A140EspecialidadCodigo[0] ;
         A155EspecialidadFoto = BC000M17_A155EspecialidadFoto[0] ;
         A40000EspecialidadFoto_GXI = BC000M17_A40000EspecialidadFoto_GXI[0] ;
         A156EspecialidadEstado = BC000M17_A156EspecialidadEstado[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0M30( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound30 = (short)(0) ;
      scanKeyLoad0M30( ) ;
   }

   public void scanKeyLoad0M30( )
   {
      sMode30 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A32EspecialidadId = BC000M17_A32EspecialidadId[0] ;
         A71EspecialidadNombre = BC000M17_A71EspecialidadNombre[0] ;
         A154EspecialidadDescripcion = BC000M17_A154EspecialidadDescripcion[0] ;
         A140EspecialidadCodigo = BC000M17_A140EspecialidadCodigo[0] ;
         A155EspecialidadFoto = BC000M17_A155EspecialidadFoto[0] ;
         A40000EspecialidadFoto_GXI = BC000M17_A40000EspecialidadFoto_GXI[0] ;
         A156EspecialidadEstado = BC000M17_A156EspecialidadEstado[0] ;
      }
      Gx_mode = sMode30 ;
   }

   public void scanKeyEnd0M30( )
   {
      pr_default.close(15);
   }

   public void afterConfirm0M30( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0M30( )
   {
      /* Before Insert Rules */
      if ( new com.projectthani.prcvalidarcodigoespecialidad(remoteHandle, context).executeUdp( A140EspecialidadCodigo) )
      {
         httpContext.GX_msglist.addItem("El código de especialidad ya existe", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void beforeUpdate0M30( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0M30( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0M30( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0M30( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0M30( )
   {
   }

   public void zm0M31( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z160SedeCostoConsulta = A160SedeCostoConsulta ;
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z157SGEspecialidadSedeNombre = A157SGEspecialidadSedeNombre ;
         Z158SGEspecialidadSedeClinicaid = A158SGEspecialidadSedeClinicaid ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z159SGEspecialidadSedeClinicaNombre = A159SGEspecialidadSedeClinicaNombre ;
      }
      if ( GX_JID == -4 )
      {
         Z32EspecialidadId = A32EspecialidadId ;
         Z160SedeCostoConsulta = A160SedeCostoConsulta ;
         Z38SGEspecialidadSedeId = A38SGEspecialidadSedeId ;
         Z157SGEspecialidadSedeNombre = A157SGEspecialidadSedeNombre ;
         Z158SGEspecialidadSedeClinicaid = A158SGEspecialidadSedeClinicaid ;
         Z159SGEspecialidadSedeClinicaNombre = A159SGEspecialidadSedeClinicaNombre ;
      }
   }

   public void standaloneNotModal0M31( )
   {
   }

   public void standaloneModal0M31( )
   {
   }

   public void load0M31( )
   {
      /* Using cursor BC000M18 */
      pr_default.execute(16, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A157SGEspecialidadSedeNombre = BC000M18_A157SGEspecialidadSedeNombre[0] ;
         A159SGEspecialidadSedeClinicaNombre = BC000M18_A159SGEspecialidadSedeClinicaNombre[0] ;
         A160SedeCostoConsulta = BC000M18_A160SedeCostoConsulta[0] ;
         A158SGEspecialidadSedeClinicaid = BC000M18_A158SGEspecialidadSedeClinicaid[0] ;
         zm0M31( -4) ;
      }
      pr_default.close(16);
      onLoadActions0M31( ) ;
   }

   public void onLoadActions0M31( )
   {
   }

   public void checkExtendedTable0M31( )
   {
      nIsDirty_31 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0M31( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000M19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGEspecialidad Sede'.", "ForeignKeyNotFound", 1, "SGESPECIALIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A157SGEspecialidadSedeNombre = BC000M19_A157SGEspecialidadSedeNombre[0] ;
      A158SGEspecialidadSedeClinicaid = BC000M19_A158SGEspecialidadSedeClinicaid[0] ;
      pr_default.close(17);
      /* Using cursor BC000M20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A158SGEspecialidadSedeClinicaid)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGEspecialidad Sede'.", "ForeignKeyNotFound", 1, "SGESPECIALIDADSEDECLINICAID");
         AnyError = (short)(1) ;
      }
      A159SGEspecialidadSedeClinicaNombre = BC000M20_A159SGEspecialidadSedeClinicaNombre[0] ;
      pr_default.close(18);
   }

   public void closeExtendedTableCursors0M31( )
   {
      pr_default.close(17);
      pr_default.close(18);
   }

   public void enableDisable0M31( )
   {
   }

   public void getKey0M31( )
   {
      /* Using cursor BC000M21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound31 = (short)(1) ;
      }
      else
      {
         RcdFound31 = (short)(0) ;
      }
      pr_default.close(19);
   }

   public void getByPrimaryKey0M31( )
   {
      /* Using cursor BC000M22 */
      pr_default.execute(20, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(20) != 101) )
      {
         zm0M31( 4) ;
         RcdFound31 = (short)(1) ;
         initializeNonKey0M31( ) ;
         A160SedeCostoConsulta = BC000M22_A160SedeCostoConsulta[0] ;
         A38SGEspecialidadSedeId = BC000M22_A38SGEspecialidadSedeId[0] ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z38SGEspecialidadSedeId = A38SGEspecialidadSedeId ;
         sMode31 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0M31( ) ;
         load0M31( ) ;
         Gx_mode = sMode31 ;
      }
      else
      {
         RcdFound31 = (short)(0) ;
         initializeNonKey0M31( ) ;
         sMode31 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0M31( ) ;
         Gx_mode = sMode31 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0M31( ) ;
      }
      pr_default.close(20);
   }

   public void checkOptimisticConcurrency0M31( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000M23 */
         pr_default.execute(21, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
         if ( (pr_default.getStatus(21) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EspecialidadSede"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(21) == 101) || ( DecimalUtil.compareTo(Z160SedeCostoConsulta, BC000M23_A160SedeCostoConsulta[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"EspecialidadSede"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0M31( )
   {
      beforeValidate0M31( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0M31( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0M31( 0) ;
         checkOptimisticConcurrency0M31( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0M31( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0M31( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000M24 */
                  pr_default.execute(22, new Object[] {Short.valueOf(A32EspecialidadId), A160SedeCostoConsulta, Short.valueOf(A38SGEspecialidadSedeId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("EspecialidadSede");
                  if ( (pr_default.getStatus(22) == 1) )
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
            load0M31( ) ;
         }
         endLevel0M31( ) ;
      }
      closeExtendedTableCursors0M31( ) ;
   }

   public void update0M31( )
   {
      beforeValidate0M31( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0M31( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0M31( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0M31( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0M31( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000M25 */
                  pr_default.execute(23, new Object[] {A160SedeCostoConsulta, Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("EspecialidadSede");
                  if ( (pr_default.getStatus(23) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EspecialidadSede"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0M31( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0M31( ) ;
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
         endLevel0M31( ) ;
      }
      closeExtendedTableCursors0M31( ) ;
   }

   public void deferredUpdate0M31( )
   {
   }

   public void delete0M31( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0M31( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0M31( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0M31( ) ;
         afterConfirm0M31( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0M31( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000M26 */
               pr_default.execute(24, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("EspecialidadSede");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode31 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0M31( ) ;
      Gx_mode = sMode31 ;
   }

   public void onDeleteControls0M31( )
   {
      standaloneModal0M31( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000M27 */
         pr_default.execute(25, new Object[] {Short.valueOf(A38SGEspecialidadSedeId)});
         A157SGEspecialidadSedeNombre = BC000M27_A157SGEspecialidadSedeNombre[0] ;
         A158SGEspecialidadSedeClinicaid = BC000M27_A158SGEspecialidadSedeClinicaid[0] ;
         pr_default.close(25);
         /* Using cursor BC000M28 */
         pr_default.execute(26, new Object[] {Short.valueOf(A158SGEspecialidadSedeClinicaid)});
         A159SGEspecialidadSedeClinicaNombre = BC000M28_A159SGEspecialidadSedeClinicaNombre[0] ;
         pr_default.close(26);
      }
   }

   public void endLevel0M31( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(21);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0M31( )
   {
      /* Scan By routine */
      /* Using cursor BC000M29 */
      pr_default.execute(27, new Object[] {Short.valueOf(A32EspecialidadId)});
      RcdFound31 = (short)(0) ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A157SGEspecialidadSedeNombre = BC000M29_A157SGEspecialidadSedeNombre[0] ;
         A159SGEspecialidadSedeClinicaNombre = BC000M29_A159SGEspecialidadSedeClinicaNombre[0] ;
         A160SedeCostoConsulta = BC000M29_A160SedeCostoConsulta[0] ;
         A38SGEspecialidadSedeId = BC000M29_A38SGEspecialidadSedeId[0] ;
         A158SGEspecialidadSedeClinicaid = BC000M29_A158SGEspecialidadSedeClinicaid[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0M31( )
   {
      /* Scan next routine */
      pr_default.readNext(27);
      RcdFound31 = (short)(0) ;
      scanKeyLoad0M31( ) ;
   }

   public void scanKeyLoad0M31( )
   {
      sMode31 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A157SGEspecialidadSedeNombre = BC000M29_A157SGEspecialidadSedeNombre[0] ;
         A159SGEspecialidadSedeClinicaNombre = BC000M29_A159SGEspecialidadSedeClinicaNombre[0] ;
         A160SedeCostoConsulta = BC000M29_A160SedeCostoConsulta[0] ;
         A38SGEspecialidadSedeId = BC000M29_A38SGEspecialidadSedeId[0] ;
         A158SGEspecialidadSedeClinicaid = BC000M29_A158SGEspecialidadSedeClinicaid[0] ;
      }
      Gx_mode = sMode31 ;
   }

   public void scanKeyEnd0M31( )
   {
      pr_default.close(27);
   }

   public void afterConfirm0M31( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0M31( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0M31( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0M31( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0M31( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0M31( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0M31( )
   {
   }

   public void send_integrity_lvl_hashes0M31( )
   {
   }

   public void send_integrity_lvl_hashes0M30( )
   {
   }

   public void addRow0M30( )
   {
      VarsToRow30( bcEspecialidad) ;
   }

   public void readRow0M30( )
   {
      RowToVars30( bcEspecialidad, 1) ;
   }

   public void addRow0M31( )
   {
      com.projectthani.SdtEspecialidad_Sede obj31;
      obj31 = new com.projectthani.SdtEspecialidad_Sede(remoteHandle);
      VarsToRow31( obj31) ;
      bcEspecialidad.getgxTv_SdtEspecialidad_Sede().add(obj31, 0);
      obj31.setgxTv_SdtEspecialidad_Sede_Mode( "UPD" );
      obj31.setgxTv_SdtEspecialidad_Sede_Modified( (short)(0) );
   }

   public void readRow0M31( )
   {
      nGXsfl_31_idx = (int)(nGXsfl_31_idx+1) ;
      RowToVars31( ((com.projectthani.SdtEspecialidad_Sede)bcEspecialidad.getgxTv_SdtEspecialidad_Sede().elementAt(-1+nGXsfl_31_idx)), 1) ;
   }

   public void initializeNonKey0M30( )
   {
      A71EspecialidadNombre = "" ;
      A154EspecialidadDescripcion = "" ;
      A140EspecialidadCodigo = "" ;
      A155EspecialidadFoto = "" ;
      A40000EspecialidadFoto_GXI = "" ;
      A156EspecialidadEstado = "" ;
      Z71EspecialidadNombre = "" ;
      Z154EspecialidadDescripcion = "" ;
      Z140EspecialidadCodigo = "" ;
      Z156EspecialidadEstado = "" ;
   }

   public void initAll0M30( )
   {
      A32EspecialidadId = (short)(0) ;
      initializeNonKey0M30( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0M31( )
   {
      A157SGEspecialidadSedeNombre = "" ;
      A158SGEspecialidadSedeClinicaid = (short)(0) ;
      A159SGEspecialidadSedeClinicaNombre = "" ;
      A160SedeCostoConsulta = DecimalUtil.ZERO ;
      Z160SedeCostoConsulta = DecimalUtil.ZERO ;
   }

   public void initAll0M31( )
   {
      A38SGEspecialidadSedeId = (short)(0) ;
      initializeNonKey0M31( ) ;
   }

   public void standaloneModalInsert0M31( )
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

   public void VarsToRow30( com.projectthani.SdtEspecialidad obj30 )
   {
      obj30.setgxTv_SdtEspecialidad_Mode( Gx_mode );
      obj30.setgxTv_SdtEspecialidad_Especialidadnombre( A71EspecialidadNombre );
      obj30.setgxTv_SdtEspecialidad_Especialidaddescripcion( A154EspecialidadDescripcion );
      obj30.setgxTv_SdtEspecialidad_Especialidadcodigo( A140EspecialidadCodigo );
      obj30.setgxTv_SdtEspecialidad_Especialidadfoto( A155EspecialidadFoto );
      obj30.setgxTv_SdtEspecialidad_Especialidadfoto_gxi( A40000EspecialidadFoto_GXI );
      obj30.setgxTv_SdtEspecialidad_Especialidadestado( A156EspecialidadEstado );
      obj30.setgxTv_SdtEspecialidad_Especialidadid( A32EspecialidadId );
      obj30.setgxTv_SdtEspecialidad_Especialidadid_Z( Z32EspecialidadId );
      obj30.setgxTv_SdtEspecialidad_Especialidadnombre_Z( Z71EspecialidadNombre );
      obj30.setgxTv_SdtEspecialidad_Especialidaddescripcion_Z( Z154EspecialidadDescripcion );
      obj30.setgxTv_SdtEspecialidad_Especialidadcodigo_Z( Z140EspecialidadCodigo );
      obj30.setgxTv_SdtEspecialidad_Especialidadestado_Z( Z156EspecialidadEstado );
      obj30.setgxTv_SdtEspecialidad_Especialidadfoto_gxi_Z( Z40000EspecialidadFoto_GXI );
      obj30.setgxTv_SdtEspecialidad_Mode( Gx_mode );
   }

   public void KeyVarsToRow30( com.projectthani.SdtEspecialidad obj30 )
   {
      obj30.setgxTv_SdtEspecialidad_Especialidadid( A32EspecialidadId );
   }

   public void RowToVars30( com.projectthani.SdtEspecialidad obj30 ,
                            int forceLoad )
   {
      Gx_mode = obj30.getgxTv_SdtEspecialidad_Mode() ;
      A71EspecialidadNombre = obj30.getgxTv_SdtEspecialidad_Especialidadnombre() ;
      A154EspecialidadDescripcion = obj30.getgxTv_SdtEspecialidad_Especialidaddescripcion() ;
      A140EspecialidadCodigo = obj30.getgxTv_SdtEspecialidad_Especialidadcodigo() ;
      A155EspecialidadFoto = obj30.getgxTv_SdtEspecialidad_Especialidadfoto() ;
      A40000EspecialidadFoto_GXI = obj30.getgxTv_SdtEspecialidad_Especialidadfoto_gxi() ;
      A156EspecialidadEstado = obj30.getgxTv_SdtEspecialidad_Especialidadestado() ;
      A32EspecialidadId = obj30.getgxTv_SdtEspecialidad_Especialidadid() ;
      Z32EspecialidadId = obj30.getgxTv_SdtEspecialidad_Especialidadid_Z() ;
      Z71EspecialidadNombre = obj30.getgxTv_SdtEspecialidad_Especialidadnombre_Z() ;
      Z154EspecialidadDescripcion = obj30.getgxTv_SdtEspecialidad_Especialidaddescripcion_Z() ;
      Z140EspecialidadCodigo = obj30.getgxTv_SdtEspecialidad_Especialidadcodigo_Z() ;
      Z156EspecialidadEstado = obj30.getgxTv_SdtEspecialidad_Especialidadestado_Z() ;
      Z40000EspecialidadFoto_GXI = obj30.getgxTv_SdtEspecialidad_Especialidadfoto_gxi_Z() ;
      Gx_mode = obj30.getgxTv_SdtEspecialidad_Mode() ;
   }

   public void VarsToRow31( com.projectthani.SdtEspecialidad_Sede obj31 )
   {
      obj31.setgxTv_SdtEspecialidad_Sede_Mode( Gx_mode );
      obj31.setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre( A157SGEspecialidadSedeNombre );
      obj31.setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid( A158SGEspecialidadSedeClinicaid );
      obj31.setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre( A159SGEspecialidadSedeClinicaNombre );
      obj31.setgxTv_SdtEspecialidad_Sede_Sedecostoconsulta( A160SedeCostoConsulta );
      obj31.setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid( A38SGEspecialidadSedeId );
      obj31.setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z( Z38SGEspecialidadSedeId );
      obj31.setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z( Z157SGEspecialidadSedeNombre );
      obj31.setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z( Z158SGEspecialidadSedeClinicaid );
      obj31.setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z( Z159SGEspecialidadSedeClinicaNombre );
      obj31.setgxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z( Z160SedeCostoConsulta );
      obj31.setgxTv_SdtEspecialidad_Sede_Modified( nIsMod_31 );
   }

   public void KeyVarsToRow31( com.projectthani.SdtEspecialidad_Sede obj31 )
   {
      obj31.setgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid( A38SGEspecialidadSedeId );
   }

   public void RowToVars31( com.projectthani.SdtEspecialidad_Sede obj31 ,
                            int forceLoad )
   {
      Gx_mode = obj31.getgxTv_SdtEspecialidad_Sede_Mode() ;
      A157SGEspecialidadSedeNombre = obj31.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre() ;
      A158SGEspecialidadSedeClinicaid = obj31.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid() ;
      A159SGEspecialidadSedeClinicaNombre = obj31.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre() ;
      A160SedeCostoConsulta = obj31.getgxTv_SdtEspecialidad_Sede_Sedecostoconsulta() ;
      A38SGEspecialidadSedeId = obj31.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid() ;
      Z38SGEspecialidadSedeId = obj31.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeid_Z() ;
      Z157SGEspecialidadSedeNombre = obj31.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedenombre_Z() ;
      Z158SGEspecialidadSedeClinicaid = obj31.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicaid_Z() ;
      Z159SGEspecialidadSedeClinicaNombre = obj31.getgxTv_SdtEspecialidad_Sede_Sgespecialidadsedeclinicanombre_Z() ;
      Z160SedeCostoConsulta = obj31.getgxTv_SdtEspecialidad_Sede_Sedecostoconsulta_Z() ;
      nIsMod_31 = obj31.getgxTv_SdtEspecialidad_Sede_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A32EspecialidadId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0M30( ) ;
      scanKeyStart0M30( ) ;
      if ( RcdFound30 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z32EspecialidadId = A32EspecialidadId ;
      }
      zm0M30( -3) ;
      onLoadActions0M30( ) ;
      addRow0M30( ) ;
      bcEspecialidad.getgxTv_SdtEspecialidad_Sede().clearCollection();
      if ( RcdFound30 == 1 )
      {
         scanKeyStart0M31( ) ;
         nGXsfl_31_idx = 1 ;
         while ( RcdFound31 != 0 )
         {
            Z32EspecialidadId = A32EspecialidadId ;
            Z38SGEspecialidadSedeId = A38SGEspecialidadSedeId ;
            zm0M31( -4) ;
            onLoadActions0M31( ) ;
            nRcdExists_31 = (short)(1) ;
            nIsMod_31 = (short)(0) ;
            addRow0M31( ) ;
            nGXsfl_31_idx = (int)(nGXsfl_31_idx+1) ;
            scanKeyNext0M31( ) ;
         }
         scanKeyEnd0M31( ) ;
      }
      scanKeyEnd0M30( ) ;
      if ( RcdFound30 == 0 )
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
      RowToVars30( bcEspecialidad, 0) ;
      scanKeyStart0M30( ) ;
      if ( RcdFound30 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z32EspecialidadId = A32EspecialidadId ;
      }
      zm0M30( -3) ;
      onLoadActions0M30( ) ;
      addRow0M30( ) ;
      bcEspecialidad.getgxTv_SdtEspecialidad_Sede().clearCollection();
      if ( RcdFound30 == 1 )
      {
         scanKeyStart0M31( ) ;
         nGXsfl_31_idx = 1 ;
         while ( RcdFound31 != 0 )
         {
            Z32EspecialidadId = A32EspecialidadId ;
            Z38SGEspecialidadSedeId = A38SGEspecialidadSedeId ;
            zm0M31( -4) ;
            onLoadActions0M31( ) ;
            nRcdExists_31 = (short)(1) ;
            nIsMod_31 = (short)(0) ;
            addRow0M31( ) ;
            nGXsfl_31_idx = (int)(nGXsfl_31_idx+1) ;
            scanKeyNext0M31( ) ;
         }
         scanKeyEnd0M31( ) ;
      }
      scanKeyEnd0M30( ) ;
      if ( RcdFound30 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0M30( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0M30( ) ;
      }
      else
      {
         if ( RcdFound30 == 1 )
         {
            if ( A32EspecialidadId != Z32EspecialidadId )
            {
               A32EspecialidadId = Z32EspecialidadId ;
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
               update0M30( ) ;
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
               if ( A32EspecialidadId != Z32EspecialidadId )
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
                     insert0M30( ) ;
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
                     insert0M30( ) ;
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
      RowToVars30( bcEspecialidad, 1) ;
      saveImpl( ) ;
      VarsToRow30( bcEspecialidad) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars30( bcEspecialidad, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0M30( ) ;
      afterTrn( ) ;
      VarsToRow30( bcEspecialidad) ;
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
         com.projectthani.SdtEspecialidad auxBC = new com.projectthani.SdtEspecialidad( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A32EspecialidadId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEspecialidad);
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
      RowToVars30( bcEspecialidad, 1) ;
      updateImpl( ) ;
      VarsToRow30( bcEspecialidad) ;
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
      RowToVars30( bcEspecialidad, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0M30( ) ;
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
      VarsToRow30( bcEspecialidad) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars30( bcEspecialidad, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0M30( ) ;
      if ( RcdFound30 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A32EspecialidadId != Z32EspecialidadId )
         {
            A32EspecialidadId = Z32EspecialidadId ;
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
         if ( A32EspecialidadId != Z32EspecialidadId )
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
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(1);
      pr_default.close(0);
      pr_default.close(25);
      pr_default.close(2);
      pr_default.close(26);
      pr_default.close(3);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "especialidad_bc");
      VarsToRow30( bcEspecialidad) ;
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
      Gx_mode = bcEspecialidad.getgxTv_SdtEspecialidad_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEspecialidad.setgxTv_SdtEspecialidad_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtEspecialidad sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEspecialidad )
      {
         bcEspecialidad = sdt ;
         if ( GXutil.strcmp(bcEspecialidad.getgxTv_SdtEspecialidad_Mode(), "") == 0 )
         {
            bcEspecialidad.setgxTv_SdtEspecialidad_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow30( bcEspecialidad) ;
         }
         else
         {
            RowToVars30( bcEspecialidad, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEspecialidad.getgxTv_SdtEspecialidad_Mode(), "") == 0 )
         {
            bcEspecialidad.setgxTv_SdtEspecialidad_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars30( bcEspecialidad, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEspecialidad getEspecialidad_BC( )
   {
      return bcEspecialidad ;
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
      sMode30 = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV21Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      Z71EspecialidadNombre = "" ;
      A71EspecialidadNombre = "" ;
      Z154EspecialidadDescripcion = "" ;
      A154EspecialidadDescripcion = "" ;
      Z140EspecialidadCodigo = "" ;
      A140EspecialidadCodigo = "" ;
      Z156EspecialidadEstado = "" ;
      A156EspecialidadEstado = "" ;
      Z155EspecialidadFoto = "" ;
      A155EspecialidadFoto = "" ;
      Z40000EspecialidadFoto_GXI = "" ;
      A40000EspecialidadFoto_GXI = "" ;
      BC000M8_A32EspecialidadId = new short[1] ;
      BC000M8_A71EspecialidadNombre = new String[] {""} ;
      BC000M8_A154EspecialidadDescripcion = new String[] {""} ;
      BC000M8_A140EspecialidadCodigo = new String[] {""} ;
      BC000M8_A155EspecialidadFoto = new String[] {""} ;
      BC000M8_A40000EspecialidadFoto_GXI = new String[] {""} ;
      BC000M8_A156EspecialidadEstado = new String[] {""} ;
      BC000M9_A32EspecialidadId = new short[1] ;
      BC000M10_A32EspecialidadId = new short[1] ;
      BC000M10_A71EspecialidadNombre = new String[] {""} ;
      BC000M10_A154EspecialidadDescripcion = new String[] {""} ;
      BC000M10_A140EspecialidadCodigo = new String[] {""} ;
      BC000M10_A155EspecialidadFoto = new String[] {""} ;
      BC000M10_A40000EspecialidadFoto_GXI = new String[] {""} ;
      BC000M10_A156EspecialidadEstado = new String[] {""} ;
      BC000M11_A32EspecialidadId = new short[1] ;
      BC000M11_A71EspecialidadNombre = new String[] {""} ;
      BC000M11_A154EspecialidadDescripcion = new String[] {""} ;
      BC000M11_A140EspecialidadCodigo = new String[] {""} ;
      BC000M11_A155EspecialidadFoto = new String[] {""} ;
      BC000M11_A40000EspecialidadFoto_GXI = new String[] {""} ;
      BC000M11_A156EspecialidadEstado = new String[] {""} ;
      BC000M12_A32EspecialidadId = new short[1] ;
      BC000M16_A31ProfesionalId = new int[1] ;
      BC000M16_A32EspecialidadId = new short[1] ;
      BC000M17_A32EspecialidadId = new short[1] ;
      BC000M17_A71EspecialidadNombre = new String[] {""} ;
      BC000M17_A154EspecialidadDescripcion = new String[] {""} ;
      BC000M17_A140EspecialidadCodigo = new String[] {""} ;
      BC000M17_A155EspecialidadFoto = new String[] {""} ;
      BC000M17_A40000EspecialidadFoto_GXI = new String[] {""} ;
      BC000M17_A156EspecialidadEstado = new String[] {""} ;
      Z160SedeCostoConsulta = DecimalUtil.ZERO ;
      A160SedeCostoConsulta = DecimalUtil.ZERO ;
      Z157SGEspecialidadSedeNombre = "" ;
      A157SGEspecialidadSedeNombre = "" ;
      Z159SGEspecialidadSedeClinicaNombre = "" ;
      A159SGEspecialidadSedeClinicaNombre = "" ;
      BC000M18_A32EspecialidadId = new short[1] ;
      BC000M18_A157SGEspecialidadSedeNombre = new String[] {""} ;
      BC000M18_A159SGEspecialidadSedeClinicaNombre = new String[] {""} ;
      BC000M18_A160SedeCostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000M18_A38SGEspecialidadSedeId = new short[1] ;
      BC000M18_A158SGEspecialidadSedeClinicaid = new short[1] ;
      BC000M19_A157SGEspecialidadSedeNombre = new String[] {""} ;
      BC000M19_A158SGEspecialidadSedeClinicaid = new short[1] ;
      BC000M20_A159SGEspecialidadSedeClinicaNombre = new String[] {""} ;
      BC000M21_A32EspecialidadId = new short[1] ;
      BC000M21_A38SGEspecialidadSedeId = new short[1] ;
      BC000M22_A32EspecialidadId = new short[1] ;
      BC000M22_A160SedeCostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000M22_A38SGEspecialidadSedeId = new short[1] ;
      sMode31 = "" ;
      BC000M23_A32EspecialidadId = new short[1] ;
      BC000M23_A160SedeCostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000M23_A38SGEspecialidadSedeId = new short[1] ;
      BC000M27_A157SGEspecialidadSedeNombre = new String[] {""} ;
      BC000M27_A158SGEspecialidadSedeClinicaid = new short[1] ;
      BC000M28_A159SGEspecialidadSedeClinicaNombre = new String[] {""} ;
      BC000M29_A32EspecialidadId = new short[1] ;
      BC000M29_A157SGEspecialidadSedeNombre = new String[] {""} ;
      BC000M29_A159SGEspecialidadSedeClinicaNombre = new String[] {""} ;
      BC000M29_A160SedeCostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000M29_A38SGEspecialidadSedeId = new short[1] ;
      BC000M29_A158SGEspecialidadSedeClinicaid = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.especialidad_bc__default(),
         new Object[] {
             new Object[] {
            BC000M2_A32EspecialidadId, BC000M2_A160SedeCostoConsulta, BC000M2_A38SGEspecialidadSedeId
            }
            , new Object[] {
            BC000M3_A32EspecialidadId, BC000M3_A160SedeCostoConsulta, BC000M3_A38SGEspecialidadSedeId
            }
            , new Object[] {
            BC000M4_A157SGEspecialidadSedeNombre, BC000M4_A158SGEspecialidadSedeClinicaid
            }
            , new Object[] {
            BC000M5_A159SGEspecialidadSedeClinicaNombre
            }
            , new Object[] {
            BC000M6_A32EspecialidadId, BC000M6_A71EspecialidadNombre, BC000M6_A154EspecialidadDescripcion, BC000M6_A140EspecialidadCodigo, BC000M6_A155EspecialidadFoto, BC000M6_A40000EspecialidadFoto_GXI, BC000M6_A156EspecialidadEstado
            }
            , new Object[] {
            BC000M7_A32EspecialidadId, BC000M7_A71EspecialidadNombre, BC000M7_A154EspecialidadDescripcion, BC000M7_A140EspecialidadCodigo, BC000M7_A155EspecialidadFoto, BC000M7_A40000EspecialidadFoto_GXI, BC000M7_A156EspecialidadEstado
            }
            , new Object[] {
            BC000M8_A32EspecialidadId, BC000M8_A71EspecialidadNombre, BC000M8_A154EspecialidadDescripcion, BC000M8_A140EspecialidadCodigo, BC000M8_A155EspecialidadFoto, BC000M8_A40000EspecialidadFoto_GXI, BC000M8_A156EspecialidadEstado
            }
            , new Object[] {
            BC000M9_A32EspecialidadId
            }
            , new Object[] {
            BC000M10_A32EspecialidadId, BC000M10_A71EspecialidadNombre, BC000M10_A154EspecialidadDescripcion, BC000M10_A140EspecialidadCodigo, BC000M10_A155EspecialidadFoto, BC000M10_A40000EspecialidadFoto_GXI, BC000M10_A156EspecialidadEstado
            }
            , new Object[] {
            BC000M11_A32EspecialidadId, BC000M11_A71EspecialidadNombre, BC000M11_A154EspecialidadDescripcion, BC000M11_A140EspecialidadCodigo, BC000M11_A155EspecialidadFoto, BC000M11_A40000EspecialidadFoto_GXI, BC000M11_A156EspecialidadEstado
            }
            , new Object[] {
            BC000M12_A32EspecialidadId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000M16_A31ProfesionalId, BC000M16_A32EspecialidadId
            }
            , new Object[] {
            BC000M17_A32EspecialidadId, BC000M17_A71EspecialidadNombre, BC000M17_A154EspecialidadDescripcion, BC000M17_A140EspecialidadCodigo, BC000M17_A155EspecialidadFoto, BC000M17_A40000EspecialidadFoto_GXI, BC000M17_A156EspecialidadEstado
            }
            , new Object[] {
            BC000M18_A32EspecialidadId, BC000M18_A157SGEspecialidadSedeNombre, BC000M18_A159SGEspecialidadSedeClinicaNombre, BC000M18_A160SedeCostoConsulta, BC000M18_A38SGEspecialidadSedeId, BC000M18_A158SGEspecialidadSedeClinicaid
            }
            , new Object[] {
            BC000M19_A157SGEspecialidadSedeNombre, BC000M19_A158SGEspecialidadSedeClinicaid
            }
            , new Object[] {
            BC000M20_A159SGEspecialidadSedeClinicaNombre
            }
            , new Object[] {
            BC000M21_A32EspecialidadId, BC000M21_A38SGEspecialidadSedeId
            }
            , new Object[] {
            BC000M22_A32EspecialidadId, BC000M22_A160SedeCostoConsulta, BC000M22_A38SGEspecialidadSedeId
            }
            , new Object[] {
            BC000M23_A32EspecialidadId, BC000M23_A160SedeCostoConsulta, BC000M23_A38SGEspecialidadSedeId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000M27_A157SGEspecialidadSedeNombre, BC000M27_A158SGEspecialidadSedeClinicaid
            }
            , new Object[] {
            BC000M28_A159SGEspecialidadSedeClinicaNombre
            }
            , new Object[] {
            BC000M29_A32EspecialidadId, BC000M29_A157SGEspecialidadSedeNombre, BC000M29_A159SGEspecialidadSedeClinicaNombre, BC000M29_A160SedeCostoConsulta, BC000M29_A38SGEspecialidadSedeId, BC000M29_A158SGEspecialidadSedeClinicaid
            }
         }
      );
      AV21Pgmname = "Especialidad_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120M2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gxremove31 ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z32EspecialidadId ;
   private short A32EspecialidadId ;
   private short nIsMod_31 ;
   private short RcdFound31 ;
   private short RcdFound30 ;
   private short nIsDirty_30 ;
   private short nRcdExists_31 ;
   private short Z158SGEspecialidadSedeClinicaid ;
   private short A158SGEspecialidadSedeClinicaid ;
   private short Z38SGEspecialidadSedeId ;
   private short A38SGEspecialidadSedeId ;
   private short nIsDirty_31 ;
   private int trnEnded ;
   private int nGXsfl_31_idx=1 ;
   private int GX_JID ;
   private java.math.BigDecimal Z160SedeCostoConsulta ;
   private java.math.BigDecimal A160SedeCostoConsulta ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode30 ;
   private String AV21Pgmname ;
   private String Z156EspecialidadEstado ;
   private String A156EspecialidadEstado ;
   private String sMode31 ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean mustCommit ;
   private String Z71EspecialidadNombre ;
   private String A71EspecialidadNombre ;
   private String Z154EspecialidadDescripcion ;
   private String A154EspecialidadDescripcion ;
   private String Z140EspecialidadCodigo ;
   private String A140EspecialidadCodigo ;
   private String Z40000EspecialidadFoto_GXI ;
   private String A40000EspecialidadFoto_GXI ;
   private String Z157SGEspecialidadSedeNombre ;
   private String A157SGEspecialidadSedeNombre ;
   private String Z159SGEspecialidadSedeClinicaNombre ;
   private String A159SGEspecialidadSedeClinicaNombre ;
   private String Z155EspecialidadFoto ;
   private String A155EspecialidadFoto ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtEspecialidad bcEspecialidad ;
   private IDataStoreProvider pr_default ;
   private short[] BC000M8_A32EspecialidadId ;
   private String[] BC000M8_A71EspecialidadNombre ;
   private String[] BC000M8_A154EspecialidadDescripcion ;
   private String[] BC000M8_A140EspecialidadCodigo ;
   private String[] BC000M8_A155EspecialidadFoto ;
   private String[] BC000M8_A40000EspecialidadFoto_GXI ;
   private String[] BC000M8_A156EspecialidadEstado ;
   private short[] BC000M9_A32EspecialidadId ;
   private short[] BC000M10_A32EspecialidadId ;
   private String[] BC000M10_A71EspecialidadNombre ;
   private String[] BC000M10_A154EspecialidadDescripcion ;
   private String[] BC000M10_A140EspecialidadCodigo ;
   private String[] BC000M10_A155EspecialidadFoto ;
   private String[] BC000M10_A40000EspecialidadFoto_GXI ;
   private String[] BC000M10_A156EspecialidadEstado ;
   private short[] BC000M11_A32EspecialidadId ;
   private String[] BC000M11_A71EspecialidadNombre ;
   private String[] BC000M11_A154EspecialidadDescripcion ;
   private String[] BC000M11_A140EspecialidadCodigo ;
   private String[] BC000M11_A155EspecialidadFoto ;
   private String[] BC000M11_A40000EspecialidadFoto_GXI ;
   private String[] BC000M11_A156EspecialidadEstado ;
   private short[] BC000M12_A32EspecialidadId ;
   private int[] BC000M16_A31ProfesionalId ;
   private short[] BC000M16_A32EspecialidadId ;
   private short[] BC000M17_A32EspecialidadId ;
   private String[] BC000M17_A71EspecialidadNombre ;
   private String[] BC000M17_A154EspecialidadDescripcion ;
   private String[] BC000M17_A140EspecialidadCodigo ;
   private String[] BC000M17_A155EspecialidadFoto ;
   private String[] BC000M17_A40000EspecialidadFoto_GXI ;
   private String[] BC000M17_A156EspecialidadEstado ;
   private short[] BC000M18_A32EspecialidadId ;
   private String[] BC000M18_A157SGEspecialidadSedeNombre ;
   private String[] BC000M18_A159SGEspecialidadSedeClinicaNombre ;
   private java.math.BigDecimal[] BC000M18_A160SedeCostoConsulta ;
   private short[] BC000M18_A38SGEspecialidadSedeId ;
   private short[] BC000M18_A158SGEspecialidadSedeClinicaid ;
   private String[] BC000M19_A157SGEspecialidadSedeNombre ;
   private short[] BC000M19_A158SGEspecialidadSedeClinicaid ;
   private String[] BC000M20_A159SGEspecialidadSedeClinicaNombre ;
   private short[] BC000M21_A32EspecialidadId ;
   private short[] BC000M21_A38SGEspecialidadSedeId ;
   private short[] BC000M22_A32EspecialidadId ;
   private java.math.BigDecimal[] BC000M22_A160SedeCostoConsulta ;
   private short[] BC000M22_A38SGEspecialidadSedeId ;
   private short[] BC000M23_A32EspecialidadId ;
   private java.math.BigDecimal[] BC000M23_A160SedeCostoConsulta ;
   private short[] BC000M23_A38SGEspecialidadSedeId ;
   private String[] BC000M27_A157SGEspecialidadSedeNombre ;
   private short[] BC000M27_A158SGEspecialidadSedeClinicaid ;
   private String[] BC000M28_A159SGEspecialidadSedeClinicaNombre ;
   private short[] BC000M29_A32EspecialidadId ;
   private String[] BC000M29_A157SGEspecialidadSedeNombre ;
   private String[] BC000M29_A159SGEspecialidadSedeClinicaNombre ;
   private java.math.BigDecimal[] BC000M29_A160SedeCostoConsulta ;
   private short[] BC000M29_A38SGEspecialidadSedeId ;
   private short[] BC000M29_A158SGEspecialidadSedeClinicaid ;
   private short[] BC000M2_A32EspecialidadId ;
   private java.math.BigDecimal[] BC000M2_A160SedeCostoConsulta ;
   private short[] BC000M2_A38SGEspecialidadSedeId ;
   private short[] BC000M3_A32EspecialidadId ;
   private java.math.BigDecimal[] BC000M3_A160SedeCostoConsulta ;
   private short[] BC000M3_A38SGEspecialidadSedeId ;
   private String[] BC000M4_A157SGEspecialidadSedeNombre ;
   private short[] BC000M4_A158SGEspecialidadSedeClinicaid ;
   private String[] BC000M5_A159SGEspecialidadSedeClinicaNombre ;
   private short[] BC000M6_A32EspecialidadId ;
   private String[] BC000M6_A71EspecialidadNombre ;
   private String[] BC000M6_A154EspecialidadDescripcion ;
   private String[] BC000M6_A140EspecialidadCodigo ;
   private String[] BC000M6_A155EspecialidadFoto ;
   private String[] BC000M6_A40000EspecialidadFoto_GXI ;
   private String[] BC000M6_A156EspecialidadEstado ;
   private short[] BC000M7_A32EspecialidadId ;
   private String[] BC000M7_A71EspecialidadNombre ;
   private String[] BC000M7_A154EspecialidadDescripcion ;
   private String[] BC000M7_A140EspecialidadCodigo ;
   private String[] BC000M7_A155EspecialidadFoto ;
   private String[] BC000M7_A40000EspecialidadFoto_GXI ;
   private String[] BC000M7_A156EspecialidadEstado ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
}

final  class especialidad_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000M2", "SELECT [EspecialidadId], [SedeCostoConsulta], [SGEspecialidadSedeId] AS SGEspecialidadSedeId FROM [EspecialidadSede] WITH (UPDLOCK) WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M3", "SELECT [EspecialidadId], [SedeCostoConsulta], [SGEspecialidadSedeId] AS SGEspecialidadSedeId FROM [EspecialidadSede] WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M4", "SELECT [SedeNombre] AS SGEspecialidadSedeNombre, [ClinicaId] AS SGEspecialidadSedeClinicaid FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M5", "SELECT [ClinicaNombreComercial] AS SGEspecialidadSedeClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M6", "SELECT [EspecialidadId], [EspecialidadNombre], [EspecialidadDescripcion], [EspecialidadCodigo], [EspecialidadFoto], [EspecialidadFoto_GXI], [EspecialidadEstado] FROM [Especialidad] WITH (UPDLOCK) WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M7", "SELECT [EspecialidadId], [EspecialidadNombre], [EspecialidadDescripcion], [EspecialidadCodigo], [EspecialidadFoto], [EspecialidadFoto_GXI], [EspecialidadEstado] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M8", "SELECT TM1.[EspecialidadId], TM1.[EspecialidadNombre], TM1.[EspecialidadDescripcion], TM1.[EspecialidadCodigo], TM1.[EspecialidadFoto], TM1.[EspecialidadFoto_GXI], TM1.[EspecialidadEstado] FROM [Especialidad] TM1 WHERE TM1.[EspecialidadId] = ? ORDER BY TM1.[EspecialidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M9", "SELECT [EspecialidadId] FROM [Especialidad] WHERE [EspecialidadId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M10", "SELECT [EspecialidadId], [EspecialidadNombre], [EspecialidadDescripcion], [EspecialidadCodigo], [EspecialidadFoto], [EspecialidadFoto_GXI], [EspecialidadEstado] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M11", "SELECT [EspecialidadId], [EspecialidadNombre], [EspecialidadDescripcion], [EspecialidadCodigo], [EspecialidadFoto], [EspecialidadFoto_GXI], [EspecialidadEstado] FROM [Especialidad] WITH (UPDLOCK) WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M12", "INSERT INTO [Especialidad]([EspecialidadNombre], [EspecialidadDescripcion], [EspecialidadCodigo], [EspecialidadFoto], [EspecialidadFoto_GXI], [EspecialidadEstado]) VALUES(?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000M13", "UPDATE [Especialidad] SET [EspecialidadNombre]=?, [EspecialidadDescripcion]=?, [EspecialidadCodigo]=?, [EspecialidadEstado]=?  WHERE [EspecialidadId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000M14", "UPDATE [Especialidad] SET [EspecialidadFoto]=?, [EspecialidadFoto_GXI]=?  WHERE [EspecialidadId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000M15", "DELETE FROM [Especialidad]  WHERE [EspecialidadId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000M16", "SELECT TOP 1 [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000M17", "SELECT TM1.[EspecialidadId], TM1.[EspecialidadNombre], TM1.[EspecialidadDescripcion], TM1.[EspecialidadCodigo], TM1.[EspecialidadFoto], TM1.[EspecialidadFoto_GXI], TM1.[EspecialidadEstado] FROM [Especialidad] TM1 WHERE TM1.[EspecialidadId] = ? ORDER BY TM1.[EspecialidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M18", "SELECT T1.[EspecialidadId], T2.[SedeNombre] AS SGEspecialidadSedeNombre, T3.[ClinicaNombreComercial] AS SGEspecialidadSedeClinicaNombre, T1.[SedeCostoConsulta], T1.[SGEspecialidadSedeId] AS SGEspecialidadSedeId, T2.[ClinicaId] AS SGEspecialidadSedeClinicaid FROM (([EspecialidadSede] T1 INNER JOIN [Sede] T2 ON T2.[SedeId] = T1.[SGEspecialidadSedeId]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T2.[ClinicaId]) WHERE T1.[EspecialidadId] = ? and T1.[SGEspecialidadSedeId] = ? ORDER BY T1.[EspecialidadId], T1.[SGEspecialidadSedeId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M19", "SELECT [SedeNombre] AS SGEspecialidadSedeNombre, [ClinicaId] AS SGEspecialidadSedeClinicaid FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M20", "SELECT [ClinicaNombreComercial] AS SGEspecialidadSedeClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M21", "SELECT [EspecialidadId], [SGEspecialidadSedeId] AS SGEspecialidadSedeId FROM [EspecialidadSede] WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M22", "SELECT [EspecialidadId], [SedeCostoConsulta], [SGEspecialidadSedeId] AS SGEspecialidadSedeId FROM [EspecialidadSede] WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M23", "SELECT [EspecialidadId], [SedeCostoConsulta], [SGEspecialidadSedeId] AS SGEspecialidadSedeId FROM [EspecialidadSede] WITH (UPDLOCK) WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000M24", "INSERT INTO [EspecialidadSede]([EspecialidadId], [SedeCostoConsulta], [SGEspecialidadSedeId]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000M25", "UPDATE [EspecialidadSede] SET [SedeCostoConsulta]=?  WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000M26", "DELETE FROM [EspecialidadSede]  WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000M27", "SELECT [SedeNombre] AS SGEspecialidadSedeNombre, [ClinicaId] AS SGEspecialidadSedeClinicaid FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M28", "SELECT [ClinicaNombreComercial] AS SGEspecialidadSedeClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000M29", "SELECT T1.[EspecialidadId], T2.[SedeNombre] AS SGEspecialidadSedeNombre, T3.[ClinicaNombreComercial] AS SGEspecialidadSedeClinicaNombre, T1.[SedeCostoConsulta], T1.[SGEspecialidadSedeId] AS SGEspecialidadSedeId, T2.[ClinicaId] AS SGEspecialidadSedeClinicaid FROM (([EspecialidadSede] T1 INNER JOIN [Sede] T2 ON T2.[SedeId] = T1.[SGEspecialidadSedeId]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T2.[ClinicaId]) WHERE T1.[EspecialidadId] = ? ORDER BY T1.[EspecialidadId], T1.[SGEspecialidadSedeId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 27 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setVarchar(3, (String)parms[2], 4, false);
               stmt.setBLOBFile(4, (String)parms[3], true);
               stmt.setGXDbFileURI(5, (String)parms[4], (String)parms[3], 2048,"Especialidad","EspecialidadFoto");
               stmt.setString(6, (String)parms[5], 1);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setVarchar(3, (String)parms[2], 4, false);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 12 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Especialidad","EspecialidadFoto");
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 23 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 24 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

