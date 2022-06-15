package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class profesional_bc extends GXWebPanel implements IGxSilentTrn
{
   public profesional_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public profesional_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( profesional_bc.class ));
   }

   public profesional_bc( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow089( ) ;
      standaloneNotModal( ) ;
      initializeNonKey089( ) ;
      standaloneModal( ) ;
      addRow089( ) ;
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
            Z31ProfesionalId = A31ProfesionalId ;
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

   public void confirm_080( )
   {
      beforeValidate089( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls089( ) ;
         }
         else
         {
            checkExtendedTable089( ) ;
            if ( AnyError == 0 )
            {
               zm089( 32) ;
               zm089( 33) ;
               zm089( 34) ;
            }
            closeExtendedTableCursors089( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode9 = Gx_mode ;
         confirm_0810( ) ;
         if ( AnyError == 0 )
         {
            confirm_0812( ) ;
            if ( AnyError == 0 )
            {
               confirm_0813( ) ;
               if ( AnyError == 0 )
               {
                  confirm_0814( ) ;
                  if ( AnyError == 0 )
                  {
                     confirm_0815( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Restore parent mode. */
                        Gx_mode = sMode9 ;
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode9 ;
      }
   }

   public void confirm_0815( )
   {
      nGXsfl_15_idx = 0 ;
      while ( nGXsfl_15_idx < bcProfesional.getgxTv_SdtProfesional_Servicios().size() )
      {
         readRow0815( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound15 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_15 != 0 ) )
         {
            getKey0815( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound15 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0815( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0815( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors0815( ) ;
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
               if ( RcdFound15 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0815( ) ;
                     load0815( ) ;
                     beforeValidate0815( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0815( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_15 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0815( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0815( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors0815( ) ;
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
            VarsToRow15( ((com.projectthani.SdtProfesional_Servicios)bcProfesional.getgxTv_SdtProfesional_Servicios().elementAt(-1+nGXsfl_15_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0814( )
   {
      nGXsfl_14_idx = 0 ;
      while ( nGXsfl_14_idx < bcProfesional.getgxTv_SdtProfesional_Premios().size() )
      {
         readRow0814( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound14 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_14 != 0 ) )
         {
            getKey0814( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound14 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0814( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0814( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors0814( ) ;
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
               if ( RcdFound14 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0814( ) ;
                     load0814( ) ;
                     beforeValidate0814( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0814( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_14 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0814( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0814( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors0814( ) ;
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
            VarsToRow14( ((com.projectthani.SdtProfesional_Premios)bcProfesional.getgxTv_SdtProfesional_Premios().elementAt(-1+nGXsfl_14_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0813( )
   {
      nGXsfl_13_idx = 0 ;
      while ( nGXsfl_13_idx < bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().size() )
      {
         readRow0813( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound13 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_13 != 0 ) )
         {
            getKey0813( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound13 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0813( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0813( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors0813( ) ;
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
               if ( RcdFound13 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0813( ) ;
                     load0813( ) ;
                     beforeValidate0813( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0813( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_13 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0813( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0813( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors0813( ) ;
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
            VarsToRow13( ((com.projectthani.SdtProfesional_ExperienciaLaboral)bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().elementAt(-1+nGXsfl_13_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0812( )
   {
      nGXsfl_12_idx = 0 ;
      while ( nGXsfl_12_idx < bcProfesional.getgxTv_SdtProfesional_Educacion().size() )
      {
         readRow0812( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound12 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_12 != 0 ) )
         {
            getKey0812( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound12 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0812( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0812( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors0812( ) ;
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
               if ( RcdFound12 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0812( ) ;
                     load0812( ) ;
                     beforeValidate0812( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0812( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_12 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0812( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0812( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors0812( ) ;
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
            VarsToRow12( ((com.projectthani.SdtProfesional_Educacion)bcProfesional.getgxTv_SdtProfesional_Educacion().elementAt(-1+nGXsfl_12_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0811( )
   {
      nGXsfl_11_idx = 0 ;
      while ( nGXsfl_11_idx < ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().size() )
      {
         readRow0811( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound11 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_11 != 0 ) )
         {
            getKey0811( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound11 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0811( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0811( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0811( 38) ;
                        zm0811( 39) ;
                     }
                     closeExtendedTableCursors0811( ) ;
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
               if ( RcdFound11 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0811( ) ;
                     load0811( ) ;
                     beforeValidate0811( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0811( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_11 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0811( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0811( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0811( 38) ;
                              zm0811( 39) ;
                           }
                           closeExtendedTableCursors0811( ) ;
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
            VarsToRow11( ((com.projectthani.SdtProfesional_Especialidad_Sede)((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().elementAt(-1+nGXsfl_11_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0810( )
   {
      nGXsfl_10_idx = 0 ;
      while ( nGXsfl_10_idx < bcProfesional.getgxTv_SdtProfesional_Especialidad().size() )
      {
         readRow0810( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound10 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_10 != 0 ) )
         {
            getKey0810( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound10 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0810( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0810( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0810( 36) ;
                     }
                     closeExtendedTableCursors0810( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Save parent mode. */
                        sMode10 = Gx_mode ;
                        confirm_0811( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Restore parent mode. */
                           Gx_mode = sMode10 ;
                           IsConfirmed = (short)(1) ;
                        }
                        /* Restore parent mode. */
                        Gx_mode = sMode10 ;
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
               if ( RcdFound10 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0810( ) ;
                     load0810( ) ;
                     beforeValidate0810( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0810( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_10 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0810( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0810( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0810( 36) ;
                           }
                           closeExtendedTableCursors0810( ) ;
                           if ( AnyError == 0 )
                           {
                              /* Save parent mode. */
                              sMode10 = Gx_mode ;
                              confirm_0811( ) ;
                              if ( AnyError == 0 )
                              {
                                 /* Restore parent mode. */
                                 Gx_mode = sMode10 ;
                                 IsConfirmed = (short)(1) ;
                              }
                              /* Restore parent mode. */
                              Gx_mode = sMode10 ;
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
            VarsToRow10( ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e11082( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void zm089( int GX_JID )
   {
      if ( ( GX_JID == 31 ) || ( GX_JID == 0 ) )
      {
         Z173ProfesionalTipoDocumento = A173ProfesionalTipoDocumento ;
         Z174ProfesionalNroDocumento = A174ProfesionalNroDocumento ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z176ProfesionalFechaNacimiento = A176ProfesionalFechaNacimiento ;
         Z177ProfesionalSexo = A177ProfesionalSexo ;
         Z178ProfesionalDescripcion = A178ProfesionalDescripcion ;
         Z179ProfesionalCorreo = A179ProfesionalCorreo ;
         Z88ProfesionalCOP = A88ProfesionalCOP ;
         Z180ProfesionalColorDisponible = A180ProfesionalColorDisponible ;
         Z181ProfesionalColorCita = A181ProfesionalColorCita ;
         Z182ProfesionalTiempoCita = A182ProfesionalTiempoCita ;
         Z183ProfesionalDireccion = A183ProfesionalDireccion ;
         Z190ProfesionalTwitter = A190ProfesionalTwitter ;
         Z191ProfesionalFacebook = A191ProfesionalFacebook ;
         Z192ProfesionalInstagram = A192ProfesionalInstagram ;
         Z193ProfesionalLinkedin = A193ProfesionalLinkedin ;
         Z194ProfesionalTelefono = A194ProfesionalTelefono ;
         Z195ProfesionalFechaRegistro = A195ProfesionalFechaRegistro ;
         Z196ProfesionalTerminosCondiciones = A196ProfesionalTerminosCondiciones ;
         Z197ProfesionalEstadoCuenta = A197ProfesionalEstadoCuenta ;
         Z198ProfesionalEstado = A198ProfesionalEstado ;
         Z43PaisId = A43PaisId ;
         Z44UbigeoCode = A44UbigeoCode ;
         Z6SecUserId = A6SecUserId ;
         Z175ProfesionalNombreCompleto2 = A175ProfesionalNombreCompleto2 ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( ( GX_JID == 32 ) || ( GX_JID == 0 ) )
      {
         Z184PaisDescripcion = A184PaisDescripcion ;
         Z175ProfesionalNombreCompleto2 = A175ProfesionalNombreCompleto2 ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( ( GX_JID == 33 ) || ( GX_JID == 0 ) )
      {
         Z186UbigeoDepartamento = A186UbigeoDepartamento ;
         Z187UbigeoProvincia = A187UbigeoProvincia ;
         Z188UbigeoDistrito = A188UbigeoDistrito ;
         Z175ProfesionalNombreCompleto2 = A175ProfesionalNombreCompleto2 ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( ( GX_JID == 34 ) || ( GX_JID == 0 ) )
      {
         Z175ProfesionalNombreCompleto2 = A175ProfesionalNombreCompleto2 ;
         Z185UbigeoNombre = A185UbigeoNombre ;
      }
      if ( GX_JID == -31 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z173ProfesionalTipoDocumento = A173ProfesionalTipoDocumento ;
         Z174ProfesionalNroDocumento = A174ProfesionalNroDocumento ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z176ProfesionalFechaNacimiento = A176ProfesionalFechaNacimiento ;
         Z177ProfesionalSexo = A177ProfesionalSexo ;
         Z178ProfesionalDescripcion = A178ProfesionalDescripcion ;
         Z179ProfesionalCorreo = A179ProfesionalCorreo ;
         Z88ProfesionalCOP = A88ProfesionalCOP ;
         Z180ProfesionalColorDisponible = A180ProfesionalColorDisponible ;
         Z181ProfesionalColorCita = A181ProfesionalColorCita ;
         Z182ProfesionalTiempoCita = A182ProfesionalTiempoCita ;
         Z183ProfesionalDireccion = A183ProfesionalDireccion ;
         Z189ProfesionalFoto = A189ProfesionalFoto ;
         Z40000ProfesionalFoto_GXI = A40000ProfesionalFoto_GXI ;
         Z190ProfesionalTwitter = A190ProfesionalTwitter ;
         Z191ProfesionalFacebook = A191ProfesionalFacebook ;
         Z192ProfesionalInstagram = A192ProfesionalInstagram ;
         Z193ProfesionalLinkedin = A193ProfesionalLinkedin ;
         Z194ProfesionalTelefono = A194ProfesionalTelefono ;
         Z195ProfesionalFechaRegistro = A195ProfesionalFechaRegistro ;
         Z196ProfesionalTerminosCondiciones = A196ProfesionalTerminosCondiciones ;
         Z197ProfesionalEstadoCuenta = A197ProfesionalEstadoCuenta ;
         Z198ProfesionalEstado = A198ProfesionalEstado ;
         Z43PaisId = A43PaisId ;
         Z44UbigeoCode = A44UbigeoCode ;
         Z6SecUserId = A6SecUserId ;
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
      if ( isIns( )  && (0==A182ProfesionalTiempoCita) && ( Gx_BScreen == 0 ) )
      {
         A182ProfesionalTiempoCita = (byte)(30) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load089( )
   {
      /* Using cursor BC000822 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A173ProfesionalTipoDocumento = BC000822_A173ProfesionalTipoDocumento[0] ;
         A174ProfesionalNroDocumento = BC000822_A174ProfesionalNroDocumento[0] ;
         A85ProfesionalApellidoPaterno = BC000822_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000822_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = BC000822_A84ProfesionalNombres[0] ;
         A176ProfesionalFechaNacimiento = BC000822_A176ProfesionalFechaNacimiento[0] ;
         A177ProfesionalSexo = BC000822_A177ProfesionalSexo[0] ;
         A178ProfesionalDescripcion = BC000822_A178ProfesionalDescripcion[0] ;
         A179ProfesionalCorreo = BC000822_A179ProfesionalCorreo[0] ;
         A88ProfesionalCOP = BC000822_A88ProfesionalCOP[0] ;
         A180ProfesionalColorDisponible = BC000822_A180ProfesionalColorDisponible[0] ;
         A181ProfesionalColorCita = BC000822_A181ProfesionalColorCita[0] ;
         A182ProfesionalTiempoCita = BC000822_A182ProfesionalTiempoCita[0] ;
         A183ProfesionalDireccion = BC000822_A183ProfesionalDireccion[0] ;
         A184PaisDescripcion = BC000822_A184PaisDescripcion[0] ;
         A189ProfesionalFoto = BC000822_A189ProfesionalFoto[0] ;
         A40000ProfesionalFoto_GXI = BC000822_A40000ProfesionalFoto_GXI[0] ;
         A190ProfesionalTwitter = BC000822_A190ProfesionalTwitter[0] ;
         A191ProfesionalFacebook = BC000822_A191ProfesionalFacebook[0] ;
         A192ProfesionalInstagram = BC000822_A192ProfesionalInstagram[0] ;
         A193ProfesionalLinkedin = BC000822_A193ProfesionalLinkedin[0] ;
         A194ProfesionalTelefono = BC000822_A194ProfesionalTelefono[0] ;
         A195ProfesionalFechaRegistro = BC000822_A195ProfesionalFechaRegistro[0] ;
         A196ProfesionalTerminosCondiciones = BC000822_A196ProfesionalTerminosCondiciones[0] ;
         A197ProfesionalEstadoCuenta = BC000822_A197ProfesionalEstadoCuenta[0] ;
         A198ProfesionalEstado = BC000822_A198ProfesionalEstado[0] ;
         A186UbigeoDepartamento = BC000822_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000822_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000822_A188UbigeoDistrito[0] ;
         A43PaisId = BC000822_A43PaisId[0] ;
         A44UbigeoCode = BC000822_A44UbigeoCode[0] ;
         A6SecUserId = BC000822_A6SecUserId[0] ;
         zm089( -31) ;
      }
      pr_default.close(20);
      onLoadActions089( ) ;
   }

   public void onLoadActions089( )
   {
      A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
   }

   public void checkExtendedTable089( )
   {
      nIsDirty_9 = (short)(0) ;
      standaloneModal( ) ;
      if ( ! ( ( GXutil.strcmp(A173ProfesionalTipoDocumento, "1") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "6") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "2") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "4") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "7") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "0") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Tipo Documento fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      nIsDirty_9 = (short)(1) ;
      A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A176ProfesionalFechaNacimiento)) || (( GXutil.resetTime(A176ProfesionalFechaNacimiento).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A176ProfesionalFechaNacimiento), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Fecha Nacimiento fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A177ProfesionalSexo, "M") == 0 ) || ( GXutil.strcmp(A177ProfesionalSexo, "F") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Sexo fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A179ProfesionalCorreo,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Correo no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A182ProfesionalTiempoCita == 30 ) || ( A182ProfesionalTiempoCita == 60 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Tiempo Cita fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000823 */
      pr_default.execute(21, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(21) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Pais'.", "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
      }
      A184PaisDescripcion = BC000823_A184PaisDescripcion[0] ;
      pr_default.close(21);
      /* Using cursor BC000824 */
      pr_default.execute(22, new Object[] {A44UbigeoCode});
      if ( (pr_default.getStatus(22) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
         AnyError = (short)(1) ;
      }
      A186UbigeoDepartamento = BC000824_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = BC000824_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = BC000824_A188UbigeoDistrito[0] ;
      pr_default.close(22);
      nIsDirty_9 = (short)(1) ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      if ( ! ( GxRegex.IsMatch(A190ProfesionalTwitter,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Profesional Twitter no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A191ProfesionalFacebook,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Profesional Facebook no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A192ProfesionalInstagram,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Profesional Instagram no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A193ProfesionalLinkedin,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Profesional Linkedin no coincide con el patrón especificado", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000825 */
      pr_default.execute(23, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
      }
      pr_default.close(23);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A195ProfesionalFechaRegistro)) || (( GXutil.resetTime(A195ProfesionalFechaRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A195ProfesionalFechaRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Fecha Registro fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A197ProfesionalEstadoCuenta, "CV") == 0 ) || ( GXutil.strcmp(A197ProfesionalEstadoCuenta, "CP") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Estado Cuenta fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A198ProfesionalEstado, "A") == 0 ) || ( GXutil.strcmp(A198ProfesionalEstado, "P") == 0 ) || ( GXutil.strcmp(A198ProfesionalEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors089( )
   {
      pr_default.close(21);
      pr_default.close(22);
      pr_default.close(23);
   }

   public void enableDisable( )
   {
   }

   public void getKey089( )
   {
      /* Using cursor BC000826 */
      pr_default.execute(24, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound9 = (short)(1) ;
      }
      else
      {
         RcdFound9 = (short)(0) ;
      }
      pr_default.close(24);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000827 */
      pr_default.execute(25, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(25) != 101) )
      {
         zm089( 31) ;
         RcdFound9 = (short)(1) ;
         A31ProfesionalId = BC000827_A31ProfesionalId[0] ;
         A173ProfesionalTipoDocumento = BC000827_A173ProfesionalTipoDocumento[0] ;
         A174ProfesionalNroDocumento = BC000827_A174ProfesionalNroDocumento[0] ;
         A85ProfesionalApellidoPaterno = BC000827_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000827_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = BC000827_A84ProfesionalNombres[0] ;
         A176ProfesionalFechaNacimiento = BC000827_A176ProfesionalFechaNacimiento[0] ;
         A177ProfesionalSexo = BC000827_A177ProfesionalSexo[0] ;
         A178ProfesionalDescripcion = BC000827_A178ProfesionalDescripcion[0] ;
         A179ProfesionalCorreo = BC000827_A179ProfesionalCorreo[0] ;
         A88ProfesionalCOP = BC000827_A88ProfesionalCOP[0] ;
         A180ProfesionalColorDisponible = BC000827_A180ProfesionalColorDisponible[0] ;
         A181ProfesionalColorCita = BC000827_A181ProfesionalColorCita[0] ;
         A182ProfesionalTiempoCita = BC000827_A182ProfesionalTiempoCita[0] ;
         A183ProfesionalDireccion = BC000827_A183ProfesionalDireccion[0] ;
         A189ProfesionalFoto = BC000827_A189ProfesionalFoto[0] ;
         A40000ProfesionalFoto_GXI = BC000827_A40000ProfesionalFoto_GXI[0] ;
         A190ProfesionalTwitter = BC000827_A190ProfesionalTwitter[0] ;
         A191ProfesionalFacebook = BC000827_A191ProfesionalFacebook[0] ;
         A192ProfesionalInstagram = BC000827_A192ProfesionalInstagram[0] ;
         A193ProfesionalLinkedin = BC000827_A193ProfesionalLinkedin[0] ;
         A194ProfesionalTelefono = BC000827_A194ProfesionalTelefono[0] ;
         A195ProfesionalFechaRegistro = BC000827_A195ProfesionalFechaRegistro[0] ;
         A196ProfesionalTerminosCondiciones = BC000827_A196ProfesionalTerminosCondiciones[0] ;
         A197ProfesionalEstadoCuenta = BC000827_A197ProfesionalEstadoCuenta[0] ;
         A198ProfesionalEstado = BC000827_A198ProfesionalEstado[0] ;
         A43PaisId = BC000827_A43PaisId[0] ;
         A44UbigeoCode = BC000827_A44UbigeoCode[0] ;
         A6SecUserId = BC000827_A6SecUserId[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         sMode9 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load089( ) ;
         if ( AnyError == 1 )
         {
            RcdFound9 = (short)(0) ;
            initializeNonKey089( ) ;
         }
         Gx_mode = sMode9 ;
      }
      else
      {
         RcdFound9 = (short)(0) ;
         initializeNonKey089( ) ;
         sMode9 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode9 ;
      }
      pr_default.close(25);
   }

   public void getEqualNoModal( )
   {
      getKey089( ) ;
      if ( RcdFound9 == 0 )
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
      confirm_080( ) ;
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

   public void checkOptimisticConcurrency089( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000828 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(26) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Profesional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(26) == 101) || ( GXutil.strcmp(Z173ProfesionalTipoDocumento, BC000828_A173ProfesionalTipoDocumento[0]) != 0 ) || ( GXutil.strcmp(Z174ProfesionalNroDocumento, BC000828_A174ProfesionalNroDocumento[0]) != 0 ) || ( GXutil.strcmp(Z85ProfesionalApellidoPaterno, BC000828_A85ProfesionalApellidoPaterno[0]) != 0 ) || ( GXutil.strcmp(Z86ProfesionalApellidoMaterno, BC000828_A86ProfesionalApellidoMaterno[0]) != 0 ) || ( GXutil.strcmp(Z84ProfesionalNombres, BC000828_A84ProfesionalNombres[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z176ProfesionalFechaNacimiento), GXutil.resetTime(BC000828_A176ProfesionalFechaNacimiento[0])) ) || ( GXutil.strcmp(Z177ProfesionalSexo, BC000828_A177ProfesionalSexo[0]) != 0 ) || ( GXutil.strcmp(Z178ProfesionalDescripcion, BC000828_A178ProfesionalDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z179ProfesionalCorreo, BC000828_A179ProfesionalCorreo[0]) != 0 ) || ( GXutil.strcmp(Z88ProfesionalCOP, BC000828_A88ProfesionalCOP[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z180ProfesionalColorDisponible, BC000828_A180ProfesionalColorDisponible[0]) != 0 ) || ( GXutil.strcmp(Z181ProfesionalColorCita, BC000828_A181ProfesionalColorCita[0]) != 0 ) || ( Z182ProfesionalTiempoCita != BC000828_A182ProfesionalTiempoCita[0] ) || ( GXutil.strcmp(Z183ProfesionalDireccion, BC000828_A183ProfesionalDireccion[0]) != 0 ) || ( GXutil.strcmp(Z190ProfesionalTwitter, BC000828_A190ProfesionalTwitter[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z191ProfesionalFacebook, BC000828_A191ProfesionalFacebook[0]) != 0 ) || ( GXutil.strcmp(Z192ProfesionalInstagram, BC000828_A192ProfesionalInstagram[0]) != 0 ) || ( GXutil.strcmp(Z193ProfesionalLinkedin, BC000828_A193ProfesionalLinkedin[0]) != 0 ) || ( GXutil.strcmp(Z194ProfesionalTelefono, BC000828_A194ProfesionalTelefono[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z195ProfesionalFechaRegistro), GXutil.resetTime(BC000828_A195ProfesionalFechaRegistro[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z196ProfesionalTerminosCondiciones != BC000828_A196ProfesionalTerminosCondiciones[0] ) || ( GXutil.strcmp(Z197ProfesionalEstadoCuenta, BC000828_A197ProfesionalEstadoCuenta[0]) != 0 ) || ( GXutil.strcmp(Z198ProfesionalEstado, BC000828_A198ProfesionalEstado[0]) != 0 ) || ( Z43PaisId != BC000828_A43PaisId[0] ) || ( GXutil.strcmp(Z44UbigeoCode, BC000828_A44UbigeoCode[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z6SecUserId != BC000828_A6SecUserId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Profesional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert089( )
   {
      beforeValidate089( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable089( ) ;
      }
      if ( AnyError == 0 )
      {
         zm089( 0) ;
         checkOptimisticConcurrency089( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm089( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert089( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000829 */
                  pr_default.execute(27, new Object[] {A173ProfesionalTipoDocumento, A174ProfesionalNroDocumento, A85ProfesionalApellidoPaterno, A86ProfesionalApellidoMaterno, A84ProfesionalNombres, A176ProfesionalFechaNacimiento, A177ProfesionalSexo, A178ProfesionalDescripcion, A179ProfesionalCorreo, A88ProfesionalCOP, A180ProfesionalColorDisponible, A181ProfesionalColorCita, Byte.valueOf(A182ProfesionalTiempoCita), A183ProfesionalDireccion, A189ProfesionalFoto, A40000ProfesionalFoto_GXI, A190ProfesionalTwitter, A191ProfesionalFacebook, A192ProfesionalInstagram, A193ProfesionalLinkedin, A194ProfesionalTelefono, A195ProfesionalFechaRegistro, Boolean.valueOf(A196ProfesionalTerminosCondiciones), A197ProfesionalEstadoCuenta, A198ProfesionalEstado, Short.valueOf(A43PaisId), A44UbigeoCode, Short.valueOf(A6SecUserId)});
                  A31ProfesionalId = BC000829_A31ProfesionalId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Profesional");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel089( ) ;
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
            load089( ) ;
         }
         endLevel089( ) ;
      }
      closeExtendedTableCursors089( ) ;
   }

   public void update089( )
   {
      beforeValidate089( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable089( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency089( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm089( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate089( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000830 */
                  pr_default.execute(28, new Object[] {A173ProfesionalTipoDocumento, A174ProfesionalNroDocumento, A85ProfesionalApellidoPaterno, A86ProfesionalApellidoMaterno, A84ProfesionalNombres, A176ProfesionalFechaNacimiento, A177ProfesionalSexo, A178ProfesionalDescripcion, A179ProfesionalCorreo, A88ProfesionalCOP, A180ProfesionalColorDisponible, A181ProfesionalColorCita, Byte.valueOf(A182ProfesionalTiempoCita), A183ProfesionalDireccion, A190ProfesionalTwitter, A191ProfesionalFacebook, A192ProfesionalInstagram, A193ProfesionalLinkedin, A194ProfesionalTelefono, A195ProfesionalFechaRegistro, Boolean.valueOf(A196ProfesionalTerminosCondiciones), A197ProfesionalEstadoCuenta, A198ProfesionalEstado, Short.valueOf(A43PaisId), A44UbigeoCode, Short.valueOf(A6SecUserId), Integer.valueOf(A31ProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Profesional");
                  if ( (pr_default.getStatus(28) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Profesional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate089( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel089( ) ;
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
         endLevel089( ) ;
      }
      closeExtendedTableCursors089( ) ;
   }

   public void deferredUpdate089( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000831 */
         pr_default.execute(29, new Object[] {A189ProfesionalFoto, A40000ProfesionalFoto_GXI, Integer.valueOf(A31ProfesionalId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Profesional");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate089( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency089( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls089( ) ;
         afterConfirm089( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete089( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart0815( ) ;
               while ( RcdFound15 != 0 )
               {
                  getByPrimaryKey0815( ) ;
                  delete0815( ) ;
                  scanKeyNext0815( ) ;
               }
               scanKeyEnd0815( ) ;
               scanKeyStart0814( ) ;
               while ( RcdFound14 != 0 )
               {
                  getByPrimaryKey0814( ) ;
                  delete0814( ) ;
                  scanKeyNext0814( ) ;
               }
               scanKeyEnd0814( ) ;
               scanKeyStart0813( ) ;
               while ( RcdFound13 != 0 )
               {
                  getByPrimaryKey0813( ) ;
                  delete0813( ) ;
                  scanKeyNext0813( ) ;
               }
               scanKeyEnd0813( ) ;
               scanKeyStart0812( ) ;
               while ( RcdFound12 != 0 )
               {
                  getByPrimaryKey0812( ) ;
                  delete0812( ) ;
                  scanKeyNext0812( ) ;
               }
               scanKeyEnd0812( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000832 */
                  pr_default.execute(30, new Object[] {Integer.valueOf(A31ProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Profesional");
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
      sMode9 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel089( ) ;
      Gx_mode = sMode9 ;
   }

   public void onDeleteControls089( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
         /* Using cursor BC000833 */
         pr_default.execute(31, new Object[] {Short.valueOf(A43PaisId)});
         A184PaisDescripcion = BC000833_A184PaisDescripcion[0] ;
         pr_default.close(31);
         /* Using cursor BC000834 */
         pr_default.execute(32, new Object[] {A44UbigeoCode});
         A186UbigeoDepartamento = BC000834_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000834_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000834_A188UbigeoDistrito[0] ;
         pr_default.close(32);
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000835 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Comentario Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor BC000836 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Rating Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor BC000837 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Educacion Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor BC000838 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Especialidad"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
      }
   }

   public void processNestedLevel0810( )
   {
      nGXsfl_10_idx = 0 ;
      while ( nGXsfl_10_idx < bcProfesional.getgxTv_SdtProfesional_Especialidad().size() )
      {
         readRow0810( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound10 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_10 != 0 ) )
         {
            standaloneNotModal0810( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0810( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0810( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0810( ) ;
               }
            }
         }
         KeyVarsToRow10( ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_10_idx = 0 ;
         while ( nGXsfl_10_idx < bcProfesional.getgxTv_SdtProfesional_Especialidad().size() )
         {
            readRow0810( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound10 == 0 )
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
               bcProfesional.getgxTv_SdtProfesional_Especialidad().removeElement(nGXsfl_10_idx);
               nGXsfl_10_idx = (int)(nGXsfl_10_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0810( ) ;
               VarsToRow10( ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0810( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_10 = (short)(0) ;
      nIsMod_10 = (short)(0) ;
      Gxremove10 = (byte)(0) ;
   }

   public void processNestedLevel0812( )
   {
      nGXsfl_12_idx = 0 ;
      while ( nGXsfl_12_idx < bcProfesional.getgxTv_SdtProfesional_Educacion().size() )
      {
         readRow0812( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound12 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_12 != 0 ) )
         {
            standaloneNotModal0812( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0812( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0812( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0812( ) ;
               }
            }
         }
         KeyVarsToRow12( ((com.projectthani.SdtProfesional_Educacion)bcProfesional.getgxTv_SdtProfesional_Educacion().elementAt(-1+nGXsfl_12_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_12_idx = 0 ;
         while ( nGXsfl_12_idx < bcProfesional.getgxTv_SdtProfesional_Educacion().size() )
         {
            readRow0812( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound12 == 0 )
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
               bcProfesional.getgxTv_SdtProfesional_Educacion().removeElement(nGXsfl_12_idx);
               nGXsfl_12_idx = (int)(nGXsfl_12_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0812( ) ;
               VarsToRow12( ((com.projectthani.SdtProfesional_Educacion)bcProfesional.getgxTv_SdtProfesional_Educacion().elementAt(-1+nGXsfl_12_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0812( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_12 = (short)(0) ;
      nIsMod_12 = (short)(0) ;
      Gxremove12 = (byte)(0) ;
   }

   public void processNestedLevel0813( )
   {
      nGXsfl_13_idx = 0 ;
      while ( nGXsfl_13_idx < bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().size() )
      {
         readRow0813( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound13 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_13 != 0 ) )
         {
            standaloneNotModal0813( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0813( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0813( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0813( ) ;
               }
            }
         }
         KeyVarsToRow13( ((com.projectthani.SdtProfesional_ExperienciaLaboral)bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().elementAt(-1+nGXsfl_13_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_13_idx = 0 ;
         while ( nGXsfl_13_idx < bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().size() )
         {
            readRow0813( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound13 == 0 )
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
               bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().removeElement(nGXsfl_13_idx);
               nGXsfl_13_idx = (int)(nGXsfl_13_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0813( ) ;
               VarsToRow13( ((com.projectthani.SdtProfesional_ExperienciaLaboral)bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().elementAt(-1+nGXsfl_13_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0813( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_13 = (short)(0) ;
      nIsMod_13 = (short)(0) ;
      Gxremove13 = (byte)(0) ;
   }

   public void processNestedLevel0814( )
   {
      nGXsfl_14_idx = 0 ;
      while ( nGXsfl_14_idx < bcProfesional.getgxTv_SdtProfesional_Premios().size() )
      {
         readRow0814( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound14 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_14 != 0 ) )
         {
            standaloneNotModal0814( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0814( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0814( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0814( ) ;
               }
            }
         }
         KeyVarsToRow14( ((com.projectthani.SdtProfesional_Premios)bcProfesional.getgxTv_SdtProfesional_Premios().elementAt(-1+nGXsfl_14_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_14_idx = 0 ;
         while ( nGXsfl_14_idx < bcProfesional.getgxTv_SdtProfesional_Premios().size() )
         {
            readRow0814( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound14 == 0 )
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
               bcProfesional.getgxTv_SdtProfesional_Premios().removeElement(nGXsfl_14_idx);
               nGXsfl_14_idx = (int)(nGXsfl_14_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0814( ) ;
               VarsToRow14( ((com.projectthani.SdtProfesional_Premios)bcProfesional.getgxTv_SdtProfesional_Premios().elementAt(-1+nGXsfl_14_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0814( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_14 = (short)(0) ;
      nIsMod_14 = (short)(0) ;
      Gxremove14 = (byte)(0) ;
   }

   public void processNestedLevel0815( )
   {
      nGXsfl_15_idx = 0 ;
      while ( nGXsfl_15_idx < bcProfesional.getgxTv_SdtProfesional_Servicios().size() )
      {
         readRow0815( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound15 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_15 != 0 ) )
         {
            standaloneNotModal0815( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0815( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0815( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0815( ) ;
               }
            }
         }
         KeyVarsToRow15( ((com.projectthani.SdtProfesional_Servicios)bcProfesional.getgxTv_SdtProfesional_Servicios().elementAt(-1+nGXsfl_15_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_15_idx = 0 ;
         while ( nGXsfl_15_idx < bcProfesional.getgxTv_SdtProfesional_Servicios().size() )
         {
            readRow0815( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound15 == 0 )
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
               bcProfesional.getgxTv_SdtProfesional_Servicios().removeElement(nGXsfl_15_idx);
               nGXsfl_15_idx = (int)(nGXsfl_15_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0815( ) ;
               VarsToRow15( ((com.projectthani.SdtProfesional_Servicios)bcProfesional.getgxTv_SdtProfesional_Servicios().elementAt(-1+nGXsfl_15_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0815( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_15 = (short)(0) ;
      nIsMod_15 = (short)(0) ;
      Gxremove15 = (byte)(0) ;
   }

   public void processLevel089( )
   {
      /* Save parent mode. */
      sMode9 = Gx_mode ;
      processNestedLevel0810( ) ;
      processNestedLevel0812( ) ;
      processNestedLevel0813( ) ;
      processNestedLevel0814( ) ;
      processNestedLevel0815( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode9 ;
      /* ' Update level parameters */
   }

   public void endLevel089( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(26);
      }
      if ( AnyError == 0 )
      {
         beforeComplete089( ) ;
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

   public void scanKeyStart089( )
   {
      /* Scan By routine */
      /* Using cursor BC000839 */
      pr_default.execute(37, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound9 = (short)(0) ;
      if ( (pr_default.getStatus(37) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A31ProfesionalId = BC000839_A31ProfesionalId[0] ;
         A173ProfesionalTipoDocumento = BC000839_A173ProfesionalTipoDocumento[0] ;
         A174ProfesionalNroDocumento = BC000839_A174ProfesionalNroDocumento[0] ;
         A85ProfesionalApellidoPaterno = BC000839_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000839_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = BC000839_A84ProfesionalNombres[0] ;
         A176ProfesionalFechaNacimiento = BC000839_A176ProfesionalFechaNacimiento[0] ;
         A177ProfesionalSexo = BC000839_A177ProfesionalSexo[0] ;
         A178ProfesionalDescripcion = BC000839_A178ProfesionalDescripcion[0] ;
         A179ProfesionalCorreo = BC000839_A179ProfesionalCorreo[0] ;
         A88ProfesionalCOP = BC000839_A88ProfesionalCOP[0] ;
         A180ProfesionalColorDisponible = BC000839_A180ProfesionalColorDisponible[0] ;
         A181ProfesionalColorCita = BC000839_A181ProfesionalColorCita[0] ;
         A182ProfesionalTiempoCita = BC000839_A182ProfesionalTiempoCita[0] ;
         A183ProfesionalDireccion = BC000839_A183ProfesionalDireccion[0] ;
         A184PaisDescripcion = BC000839_A184PaisDescripcion[0] ;
         A189ProfesionalFoto = BC000839_A189ProfesionalFoto[0] ;
         A40000ProfesionalFoto_GXI = BC000839_A40000ProfesionalFoto_GXI[0] ;
         A190ProfesionalTwitter = BC000839_A190ProfesionalTwitter[0] ;
         A191ProfesionalFacebook = BC000839_A191ProfesionalFacebook[0] ;
         A192ProfesionalInstagram = BC000839_A192ProfesionalInstagram[0] ;
         A193ProfesionalLinkedin = BC000839_A193ProfesionalLinkedin[0] ;
         A194ProfesionalTelefono = BC000839_A194ProfesionalTelefono[0] ;
         A195ProfesionalFechaRegistro = BC000839_A195ProfesionalFechaRegistro[0] ;
         A196ProfesionalTerminosCondiciones = BC000839_A196ProfesionalTerminosCondiciones[0] ;
         A197ProfesionalEstadoCuenta = BC000839_A197ProfesionalEstadoCuenta[0] ;
         A198ProfesionalEstado = BC000839_A198ProfesionalEstado[0] ;
         A186UbigeoDepartamento = BC000839_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000839_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000839_A188UbigeoDistrito[0] ;
         A43PaisId = BC000839_A43PaisId[0] ;
         A44UbigeoCode = BC000839_A44UbigeoCode[0] ;
         A6SecUserId = BC000839_A6SecUserId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext089( )
   {
      /* Scan next routine */
      pr_default.readNext(37);
      RcdFound9 = (short)(0) ;
      scanKeyLoad089( ) ;
   }

   public void scanKeyLoad089( )
   {
      sMode9 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(37) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A31ProfesionalId = BC000839_A31ProfesionalId[0] ;
         A173ProfesionalTipoDocumento = BC000839_A173ProfesionalTipoDocumento[0] ;
         A174ProfesionalNroDocumento = BC000839_A174ProfesionalNroDocumento[0] ;
         A85ProfesionalApellidoPaterno = BC000839_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = BC000839_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = BC000839_A84ProfesionalNombres[0] ;
         A176ProfesionalFechaNacimiento = BC000839_A176ProfesionalFechaNacimiento[0] ;
         A177ProfesionalSexo = BC000839_A177ProfesionalSexo[0] ;
         A178ProfesionalDescripcion = BC000839_A178ProfesionalDescripcion[0] ;
         A179ProfesionalCorreo = BC000839_A179ProfesionalCorreo[0] ;
         A88ProfesionalCOP = BC000839_A88ProfesionalCOP[0] ;
         A180ProfesionalColorDisponible = BC000839_A180ProfesionalColorDisponible[0] ;
         A181ProfesionalColorCita = BC000839_A181ProfesionalColorCita[0] ;
         A182ProfesionalTiempoCita = BC000839_A182ProfesionalTiempoCita[0] ;
         A183ProfesionalDireccion = BC000839_A183ProfesionalDireccion[0] ;
         A184PaisDescripcion = BC000839_A184PaisDescripcion[0] ;
         A189ProfesionalFoto = BC000839_A189ProfesionalFoto[0] ;
         A40000ProfesionalFoto_GXI = BC000839_A40000ProfesionalFoto_GXI[0] ;
         A190ProfesionalTwitter = BC000839_A190ProfesionalTwitter[0] ;
         A191ProfesionalFacebook = BC000839_A191ProfesionalFacebook[0] ;
         A192ProfesionalInstagram = BC000839_A192ProfesionalInstagram[0] ;
         A193ProfesionalLinkedin = BC000839_A193ProfesionalLinkedin[0] ;
         A194ProfesionalTelefono = BC000839_A194ProfesionalTelefono[0] ;
         A195ProfesionalFechaRegistro = BC000839_A195ProfesionalFechaRegistro[0] ;
         A196ProfesionalTerminosCondiciones = BC000839_A196ProfesionalTerminosCondiciones[0] ;
         A197ProfesionalEstadoCuenta = BC000839_A197ProfesionalEstadoCuenta[0] ;
         A198ProfesionalEstado = BC000839_A198ProfesionalEstado[0] ;
         A186UbigeoDepartamento = BC000839_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = BC000839_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = BC000839_A188UbigeoDistrito[0] ;
         A43PaisId = BC000839_A43PaisId[0] ;
         A44UbigeoCode = BC000839_A44UbigeoCode[0] ;
         A6SecUserId = BC000839_A6SecUserId[0] ;
      }
      Gx_mode = sMode9 ;
   }

   public void scanKeyEnd089( )
   {
      pr_default.close(37);
   }

   public void afterConfirm089( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert089( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate089( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete089( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete089( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate089( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes089( )
   {
   }

   public void zm0810( int GX_JID )
   {
      if ( ( GX_JID == 35 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 36 ) || ( GX_JID == 0 ) )
      {
         Z140EspecialidadCodigo = A140EspecialidadCodigo ;
         Z71EspecialidadNombre = A71EspecialidadNombre ;
      }
      if ( GX_JID == -35 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z140EspecialidadCodigo = A140EspecialidadCodigo ;
         Z71EspecialidadNombre = A71EspecialidadNombre ;
      }
   }

   public void standaloneNotModal0810( )
   {
   }

   public void standaloneModal0810( )
   {
   }

   public void load0810( )
   {
      /* Using cursor BC000840 */
      pr_default.execute(38, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(38) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A140EspecialidadCodigo = BC000840_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = BC000840_A71EspecialidadNombre[0] ;
         zm0810( -35) ;
      }
      pr_default.close(38);
      onLoadActions0810( ) ;
   }

   public void onLoadActions0810( )
   {
   }

   public void checkExtendedTable0810( )
   {
      nIsDirty_10 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0810( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000841 */
      pr_default.execute(39, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(39) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A140EspecialidadCodigo = BC000841_A140EspecialidadCodigo[0] ;
      A71EspecialidadNombre = BC000841_A71EspecialidadNombre[0] ;
      pr_default.close(39);
   }

   public void closeExtendedTableCursors0810( )
   {
      pr_default.close(39);
   }

   public void enableDisable0810( )
   {
   }

   public void getKey0810( )
   {
      /* Using cursor BC000842 */
      pr_default.execute(40, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(40) != 101) )
      {
         RcdFound10 = (short)(1) ;
      }
      else
      {
         RcdFound10 = (short)(0) ;
      }
      pr_default.close(40);
   }

   public void getByPrimaryKey0810( )
   {
      /* Using cursor BC000843 */
      pr_default.execute(41, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(41) != 101) )
      {
         zm0810( 35) ;
         RcdFound10 = (short)(1) ;
         initializeNonKey0810( ) ;
         A32EspecialidadId = BC000843_A32EspecialidadId[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0810( ) ;
         load0810( ) ;
         Gx_mode = sMode10 ;
      }
      else
      {
         RcdFound10 = (short)(0) ;
         initializeNonKey0810( ) ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0810( ) ;
         Gx_mode = sMode10 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0810( ) ;
      }
      pr_default.close(41);
   }

   public void checkOptimisticConcurrency0810( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000844 */
         pr_default.execute(42, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(42) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEspecialidad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(42) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalEspecialidad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0810( )
   {
      beforeValidate0810( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0810( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0810( 0) ;
         checkOptimisticConcurrency0810( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0810( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0810( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000845 */
                  pr_default.execute(43, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidad");
                  if ( (pr_default.getStatus(43) == 1) )
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
                        processLevel0810( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
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
            load0810( ) ;
         }
         endLevel0810( ) ;
      }
      closeExtendedTableCursors0810( ) ;
   }

   public void update0810( )
   {
      beforeValidate0810( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0810( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0810( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0810( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0810( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table [ProfesionalEspecialidad] */
                  deferredUpdate0810( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0810( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0810( ) ;
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
         endLevel0810( ) ;
      }
      closeExtendedTableCursors0810( ) ;
   }

   public void deferredUpdate0810( )
   {
   }

   public void delete0810( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0810( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0810( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0810( ) ;
         afterConfirm0810( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0810( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart0811( ) ;
               while ( RcdFound11 != 0 )
               {
                  getByPrimaryKey0811( ) ;
                  delete0811( ) ;
                  scanKeyNext0811( ) ;
               }
               scanKeyEnd0811( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000846 */
                  pr_default.execute(44, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidad");
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
      }
      sMode10 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0810( ) ;
      Gx_mode = sMode10 ;
   }

   public void onDeleteControls0810( )
   {
      standaloneModal0810( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000847 */
         pr_default.execute(45, new Object[] {Short.valueOf(A32EspecialidadId)});
         A140EspecialidadCodigo = BC000847_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = BC000847_A71EspecialidadNombre[0] ;
         pr_default.close(45);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000848 */
         pr_default.execute(46, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Disponibilidad"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor BC000849 */
         pr_default.execute(47, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Conf Comision"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
      }
   }

   public void processNestedLevel0811( )
   {
      nGXsfl_11_idx = 0 ;
      while ( nGXsfl_11_idx < ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().size() )
      {
         readRow0811( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound11 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_11 != 0 ) )
         {
            standaloneNotModal0811( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0811( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0811( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0811( ) ;
               }
            }
         }
         KeyVarsToRow11( ((com.projectthani.SdtProfesional_Especialidad_Sede)((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().elementAt(-1+nGXsfl_11_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_11_idx = 0 ;
         while ( nGXsfl_11_idx < ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().size() )
         {
            readRow0811( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound11 == 0 )
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
               ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().removeElement(nGXsfl_11_idx);
               nGXsfl_11_idx = (int)(nGXsfl_11_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0811( ) ;
               VarsToRow11( ((com.projectthani.SdtProfesional_Especialidad_Sede)((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().elementAt(-1+nGXsfl_11_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0811( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_11 = (short)(0) ;
      nIsMod_11 = (short)(0) ;
      Gxremove11 = (byte)(0) ;
   }

   public void processLevel0810( )
   {
      /* Save parent mode. */
      sMode10 = Gx_mode ;
      processNestedLevel0811( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode10 ;
      /* ' Update level parameters */
   }

   public void endLevel0810( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(42);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0810( )
   {
      /* Scan By routine */
      /* Using cursor BC000850 */
      pr_default.execute(48, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(48) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A140EspecialidadCodigo = BC000850_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = BC000850_A71EspecialidadNombre[0] ;
         A32EspecialidadId = BC000850_A32EspecialidadId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0810( )
   {
      /* Scan next routine */
      pr_default.readNext(48);
      RcdFound10 = (short)(0) ;
      scanKeyLoad0810( ) ;
   }

   public void scanKeyLoad0810( )
   {
      sMode10 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(48) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A140EspecialidadCodigo = BC000850_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = BC000850_A71EspecialidadNombre[0] ;
         A32EspecialidadId = BC000850_A32EspecialidadId[0] ;
      }
      Gx_mode = sMode10 ;
   }

   public void scanKeyEnd0810( )
   {
      pr_default.close(48);
   }

   public void afterConfirm0810( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0810( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0810( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0810( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0810( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0810( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0810( )
   {
   }

   public void zm0811( int GX_JID )
   {
      if ( ( GX_JID == 37 ) || ( GX_JID == 0 ) )
      {
         Z199CostoConsulta = A199CostoConsulta ;
      }
      if ( ( GX_JID == 38 ) || ( GX_JID == 0 ) )
      {
         Z28ClinicaId = A28ClinicaId ;
         Z75SedeNombre = A75SedeNombre ;
      }
      if ( ( GX_JID == 39 ) || ( GX_JID == 0 ) )
      {
         Z80ClinicaNombreAbreviado = A80ClinicaNombreAbreviado ;
      }
      if ( GX_JID == -37 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z54SedeTipoConsulta = A54SedeTipoConsulta ;
         Z199CostoConsulta = A199CostoConsulta ;
         Z30SedeId = A30SedeId ;
         Z28ClinicaId = A28ClinicaId ;
         Z75SedeNombre = A75SedeNombre ;
         Z80ClinicaNombreAbreviado = A80ClinicaNombreAbreviado ;
      }
   }

   public void standaloneNotModal0811( )
   {
   }

   public void standaloneModal0811( )
   {
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A199CostoConsulta)==0) && ( Gx_BScreen == 0 ) )
      {
         A199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      }
   }

   public void load0811( )
   {
      /* Using cursor BC000851 */
      pr_default.execute(49, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), A54SedeTipoConsulta, Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(49) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A28ClinicaId = BC000851_A28ClinicaId[0] ;
         A199CostoConsulta = BC000851_A199CostoConsulta[0] ;
         A75SedeNombre = BC000851_A75SedeNombre[0] ;
         A80ClinicaNombreAbreviado = BC000851_A80ClinicaNombreAbreviado[0] ;
         zm0811( -37) ;
      }
      pr_default.close(49);
      onLoadActions0811( ) ;
   }

   public void onLoadActions0811( )
   {
   }

   public void checkExtendedTable0811( )
   {
      nIsDirty_11 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0811( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000852 */
      pr_default.execute(50, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(50) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SEDEID");
         AnyError = (short)(1) ;
      }
      A28ClinicaId = BC000852_A28ClinicaId[0] ;
      A75SedeNombre = BC000852_A75SedeNombre[0] ;
      pr_default.close(50);
      /* Using cursor BC000853 */
      pr_default.execute(51, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(51) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "CLINICAID");
         AnyError = (short)(1) ;
      }
      A80ClinicaNombreAbreviado = BC000853_A80ClinicaNombreAbreviado[0] ;
      pr_default.close(51);
      if ( ! ( ( GXutil.strcmp(A54SedeTipoConsulta, "V") == 0 ) || ( GXutil.strcmp(A54SedeTipoConsulta, "P") == 0 ) || ( GXutil.strcmp(A54SedeTipoConsulta, "D") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Tipo Consulta fuera del rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0811( )
   {
      pr_default.close(50);
      pr_default.close(51);
   }

   public void enableDisable0811( )
   {
   }

   public void getKey0811( )
   {
      /* Using cursor BC000854 */
      pr_default.execute(52, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
      if ( (pr_default.getStatus(52) != 101) )
      {
         RcdFound11 = (short)(1) ;
      }
      else
      {
         RcdFound11 = (short)(0) ;
      }
      pr_default.close(52);
   }

   public void getByPrimaryKey0811( )
   {
      /* Using cursor BC000855 */
      pr_default.execute(53, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
      if ( (pr_default.getStatus(53) != 101) )
      {
         zm0811( 37) ;
         RcdFound11 = (short)(1) ;
         initializeNonKey0811( ) ;
         A54SedeTipoConsulta = BC000855_A54SedeTipoConsulta[0] ;
         A199CostoConsulta = BC000855_A199CostoConsulta[0] ;
         A30SedeId = BC000855_A30SedeId[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z30SedeId = A30SedeId ;
         Z54SedeTipoConsulta = A54SedeTipoConsulta ;
         sMode11 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0811( ) ;
         load0811( ) ;
         Gx_mode = sMode11 ;
      }
      else
      {
         RcdFound11 = (short)(0) ;
         initializeNonKey0811( ) ;
         sMode11 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0811( ) ;
         Gx_mode = sMode11 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0811( ) ;
      }
      pr_default.close(53);
   }

   public void checkOptimisticConcurrency0811( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000856 */
         pr_default.execute(54, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
         if ( (pr_default.getStatus(54) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEspecialidadSede"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(54) == 101) || ( DecimalUtil.compareTo(Z199CostoConsulta, BC000856_A199CostoConsulta[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalEspecialidadSede"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0811( )
   {
      beforeValidate0811( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0811( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0811( 0) ;
         checkOptimisticConcurrency0811( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0811( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0811( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000857 */
                  pr_default.execute(55, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), A54SedeTipoConsulta, A199CostoConsulta, Short.valueOf(A30SedeId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidadSede");
                  if ( (pr_default.getStatus(55) == 1) )
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
            load0811( ) ;
         }
         endLevel0811( ) ;
      }
      closeExtendedTableCursors0811( ) ;
   }

   public void update0811( )
   {
      beforeValidate0811( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0811( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0811( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0811( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0811( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000858 */
                  pr_default.execute(56, new Object[] {A199CostoConsulta, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidadSede");
                  if ( (pr_default.getStatus(56) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEspecialidadSede"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0811( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0811( ) ;
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
         endLevel0811( ) ;
      }
      closeExtendedTableCursors0811( ) ;
   }

   public void deferredUpdate0811( )
   {
   }

   public void delete0811( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0811( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0811( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0811( ) ;
         afterConfirm0811( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0811( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000859 */
               pr_default.execute(57, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidadSede");
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
      sMode11 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0811( ) ;
      Gx_mode = sMode11 ;
   }

   public void onDeleteControls0811( )
   {
      standaloneModal0811( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000860 */
         pr_default.execute(58, new Object[] {Short.valueOf(A30SedeId)});
         A28ClinicaId = BC000860_A28ClinicaId[0] ;
         A75SedeNombre = BC000860_A75SedeNombre[0] ;
         pr_default.close(58);
         /* Using cursor BC000861 */
         pr_default.execute(59, new Object[] {Short.valueOf(A28ClinicaId)});
         A80ClinicaNombreAbreviado = BC000861_A80ClinicaNombreAbreviado[0] ;
         pr_default.close(59);
      }
   }

   public void endLevel0811( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(54);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0811( )
   {
      /* Scan By routine */
      /* Using cursor BC000862 */
      pr_default.execute(60, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      RcdFound11 = (short)(0) ;
      if ( (pr_default.getStatus(60) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A28ClinicaId = BC000862_A28ClinicaId[0] ;
         A54SedeTipoConsulta = BC000862_A54SedeTipoConsulta[0] ;
         A199CostoConsulta = BC000862_A199CostoConsulta[0] ;
         A75SedeNombre = BC000862_A75SedeNombre[0] ;
         A80ClinicaNombreAbreviado = BC000862_A80ClinicaNombreAbreviado[0] ;
         A30SedeId = BC000862_A30SedeId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0811( )
   {
      /* Scan next routine */
      pr_default.readNext(60);
      RcdFound11 = (short)(0) ;
      scanKeyLoad0811( ) ;
   }

   public void scanKeyLoad0811( )
   {
      sMode11 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(60) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A28ClinicaId = BC000862_A28ClinicaId[0] ;
         A54SedeTipoConsulta = BC000862_A54SedeTipoConsulta[0] ;
         A199CostoConsulta = BC000862_A199CostoConsulta[0] ;
         A75SedeNombre = BC000862_A75SedeNombre[0] ;
         A80ClinicaNombreAbreviado = BC000862_A80ClinicaNombreAbreviado[0] ;
         A30SedeId = BC000862_A30SedeId[0] ;
      }
      Gx_mode = sMode11 ;
   }

   public void scanKeyEnd0811( )
   {
      pr_default.close(60);
   }

   public void afterConfirm0811( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0811( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0811( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0811( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0811( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0811( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0811( )
   {
   }

   public void send_integrity_lvl_hashes0811( )
   {
   }

   public void send_integrity_lvl_hashes0810( )
   {
   }

   public void zm0812( int GX_JID )
   {
      if ( ( GX_JID == 40 ) || ( GX_JID == 0 ) )
      {
         Z200EducacionNombreInstitucion = A200EducacionNombreInstitucion ;
         Z201EducacionDesde = A201EducacionDesde ;
         Z202EducacionHasta = A202EducacionHasta ;
         Z203EducacionPaisDescripcion = A203EducacionPaisDescripcion ;
      }
      if ( GX_JID == -40 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z55EducacionId = A55EducacionId ;
         Z200EducacionNombreInstitucion = A200EducacionNombreInstitucion ;
         Z201EducacionDesde = A201EducacionDesde ;
         Z202EducacionHasta = A202EducacionHasta ;
         Z203EducacionPaisDescripcion = A203EducacionPaisDescripcion ;
      }
   }

   public void standaloneNotModal0812( )
   {
   }

   public void standaloneModal0812( )
   {
      if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A55EducacionId) )
      {
         A55EducacionId = java.util.UUID.randomUUID( ) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0812( )
   {
      /* Using cursor BC000863 */
      pr_default.execute(61, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
      if ( (pr_default.getStatus(61) != 101) )
      {
         RcdFound12 = (short)(1) ;
         A200EducacionNombreInstitucion = BC000863_A200EducacionNombreInstitucion[0] ;
         A201EducacionDesde = BC000863_A201EducacionDesde[0] ;
         A202EducacionHasta = BC000863_A202EducacionHasta[0] ;
         A203EducacionPaisDescripcion = BC000863_A203EducacionPaisDescripcion[0] ;
         zm0812( -40) ;
      }
      pr_default.close(61);
      onLoadActions0812( ) ;
   }

   public void onLoadActions0812( )
   {
   }

   public void checkExtendedTable0812( )
   {
      nIsDirty_12 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0812( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A201EducacionDesde)) || (( GXutil.resetTime(A201EducacionDesde).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A201EducacionDesde), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Educacion Desde fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A202EducacionHasta)) || (( GXutil.resetTime(A202EducacionHasta).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A202EducacionHasta), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Educacion Hasta fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0812( )
   {
   }

   public void enableDisable0812( )
   {
   }

   public void getKey0812( )
   {
      /* Using cursor BC000864 */
      pr_default.execute(62, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
      if ( (pr_default.getStatus(62) != 101) )
      {
         RcdFound12 = (short)(1) ;
      }
      else
      {
         RcdFound12 = (short)(0) ;
      }
      pr_default.close(62);
   }

   public void getByPrimaryKey0812( )
   {
      /* Using cursor BC000865 */
      pr_default.execute(63, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
      if ( (pr_default.getStatus(63) != 101) )
      {
         zm0812( 40) ;
         RcdFound12 = (short)(1) ;
         initializeNonKey0812( ) ;
         A55EducacionId = BC000865_A55EducacionId[0] ;
         A200EducacionNombreInstitucion = BC000865_A200EducacionNombreInstitucion[0] ;
         A201EducacionDesde = BC000865_A201EducacionDesde[0] ;
         A202EducacionHasta = BC000865_A202EducacionHasta[0] ;
         A203EducacionPaisDescripcion = BC000865_A203EducacionPaisDescripcion[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z55EducacionId = A55EducacionId ;
         sMode12 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0812( ) ;
         load0812( ) ;
         Gx_mode = sMode12 ;
      }
      else
      {
         RcdFound12 = (short)(0) ;
         initializeNonKey0812( ) ;
         sMode12 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0812( ) ;
         Gx_mode = sMode12 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0812( ) ;
      }
      pr_default.close(63);
   }

   public void checkOptimisticConcurrency0812( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000866 */
         pr_default.execute(64, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
         if ( (pr_default.getStatus(64) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEducacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(64) == 101) || ( GXutil.strcmp(Z200EducacionNombreInstitucion, BC000866_A200EducacionNombreInstitucion[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z201EducacionDesde), GXutil.resetTime(BC000866_A201EducacionDesde[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z202EducacionHasta), GXutil.resetTime(BC000866_A202EducacionHasta[0])) ) || ( GXutil.strcmp(Z203EducacionPaisDescripcion, BC000866_A203EducacionPaisDescripcion[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalEducacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0812( )
   {
      beforeValidate0812( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0812( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0812( 0) ;
         checkOptimisticConcurrency0812( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0812( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0812( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000867 */
                  pr_default.execute(65, new Object[] {Integer.valueOf(A31ProfesionalId), A200EducacionNombreInstitucion, A201EducacionDesde, A202EducacionHasta, A203EducacionPaisDescripcion, A55EducacionId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEducacion");
                  if ( (pr_default.getStatus(65) == 1) )
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
            load0812( ) ;
         }
         endLevel0812( ) ;
      }
      closeExtendedTableCursors0812( ) ;
   }

   public void update0812( )
   {
      beforeValidate0812( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0812( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0812( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0812( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0812( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000868 */
                  pr_default.execute(66, new Object[] {A200EducacionNombreInstitucion, A201EducacionDesde, A202EducacionHasta, A203EducacionPaisDescripcion, Integer.valueOf(A31ProfesionalId), A55EducacionId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEducacion");
                  if ( (pr_default.getStatus(66) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEducacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0812( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0812( ) ;
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
         endLevel0812( ) ;
      }
      closeExtendedTableCursors0812( ) ;
   }

   public void deferredUpdate0812( )
   {
   }

   public void delete0812( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0812( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0812( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0812( ) ;
         afterConfirm0812( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0812( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000869 */
               pr_default.execute(67, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEducacion");
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
      sMode12 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0812( ) ;
      Gx_mode = sMode12 ;
   }

   public void onDeleteControls0812( )
   {
      standaloneModal0812( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0812( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(64);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0812( )
   {
      /* Scan By routine */
      /* Using cursor BC000870 */
      pr_default.execute(68, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound12 = (short)(0) ;
      if ( (pr_default.getStatus(68) != 101) )
      {
         RcdFound12 = (short)(1) ;
         A55EducacionId = BC000870_A55EducacionId[0] ;
         A200EducacionNombreInstitucion = BC000870_A200EducacionNombreInstitucion[0] ;
         A201EducacionDesde = BC000870_A201EducacionDesde[0] ;
         A202EducacionHasta = BC000870_A202EducacionHasta[0] ;
         A203EducacionPaisDescripcion = BC000870_A203EducacionPaisDescripcion[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0812( )
   {
      /* Scan next routine */
      pr_default.readNext(68);
      RcdFound12 = (short)(0) ;
      scanKeyLoad0812( ) ;
   }

   public void scanKeyLoad0812( )
   {
      sMode12 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(68) != 101) )
      {
         RcdFound12 = (short)(1) ;
         A55EducacionId = BC000870_A55EducacionId[0] ;
         A200EducacionNombreInstitucion = BC000870_A200EducacionNombreInstitucion[0] ;
         A201EducacionDesde = BC000870_A201EducacionDesde[0] ;
         A202EducacionHasta = BC000870_A202EducacionHasta[0] ;
         A203EducacionPaisDescripcion = BC000870_A203EducacionPaisDescripcion[0] ;
      }
      Gx_mode = sMode12 ;
   }

   public void scanKeyEnd0812( )
   {
      pr_default.close(68);
   }

   public void afterConfirm0812( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0812( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0812( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0812( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0812( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0812( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0812( )
   {
   }

   public void send_integrity_lvl_hashes0812( )
   {
   }

   public void zm0813( int GX_JID )
   {
      if ( ( GX_JID == 41 ) || ( GX_JID == 0 ) )
      {
         Z204ExperienciaLaboralEmpresaNombre = A204ExperienciaLaboralEmpresaNombre ;
         Z205ExperienciaLaboralDesde = A205ExperienciaLaboralDesde ;
         Z206ExperienciaLaboralHasta = A206ExperienciaLaboralHasta ;
      }
      if ( GX_JID == -41 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z56ExperienciaLaboralId = A56ExperienciaLaboralId ;
         Z204ExperienciaLaboralEmpresaNombre = A204ExperienciaLaboralEmpresaNombre ;
         Z205ExperienciaLaboralDesde = A205ExperienciaLaboralDesde ;
         Z206ExperienciaLaboralHasta = A206ExperienciaLaboralHasta ;
      }
   }

   public void standaloneNotModal0813( )
   {
   }

   public void standaloneModal0813( )
   {
      if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A56ExperienciaLaboralId) )
      {
         A56ExperienciaLaboralId = java.util.UUID.randomUUID( ) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0813( )
   {
      /* Using cursor BC000871 */
      pr_default.execute(69, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
      if ( (pr_default.getStatus(69) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A204ExperienciaLaboralEmpresaNombre = BC000871_A204ExperienciaLaboralEmpresaNombre[0] ;
         A205ExperienciaLaboralDesde = BC000871_A205ExperienciaLaboralDesde[0] ;
         A206ExperienciaLaboralHasta = BC000871_A206ExperienciaLaboralHasta[0] ;
         zm0813( -41) ;
      }
      pr_default.close(69);
      onLoadActions0813( ) ;
   }

   public void onLoadActions0813( )
   {
   }

   public void checkExtendedTable0813( )
   {
      nIsDirty_13 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0813( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A205ExperienciaLaboralDesde)) || (( GXutil.resetTime(A205ExperienciaLaboralDesde).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A205ExperienciaLaboralDesde), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Experiencia Laboral Desde fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A206ExperienciaLaboralHasta)) || (( GXutil.resetTime(A206ExperienciaLaboralHasta).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A206ExperienciaLaboralHasta), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Experiencia Laboral Hasta fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0813( )
   {
   }

   public void enableDisable0813( )
   {
   }

   public void getKey0813( )
   {
      /* Using cursor BC000872 */
      pr_default.execute(70, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
      if ( (pr_default.getStatus(70) != 101) )
      {
         RcdFound13 = (short)(1) ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
      }
      pr_default.close(70);
   }

   public void getByPrimaryKey0813( )
   {
      /* Using cursor BC000873 */
      pr_default.execute(71, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
      if ( (pr_default.getStatus(71) != 101) )
      {
         zm0813( 41) ;
         RcdFound13 = (short)(1) ;
         initializeNonKey0813( ) ;
         A56ExperienciaLaboralId = BC000873_A56ExperienciaLaboralId[0] ;
         A204ExperienciaLaboralEmpresaNombre = BC000873_A204ExperienciaLaboralEmpresaNombre[0] ;
         A205ExperienciaLaboralDesde = BC000873_A205ExperienciaLaboralDesde[0] ;
         A206ExperienciaLaboralHasta = BC000873_A206ExperienciaLaboralHasta[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z56ExperienciaLaboralId = A56ExperienciaLaboralId ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0813( ) ;
         load0813( ) ;
         Gx_mode = sMode13 ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
         initializeNonKey0813( ) ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0813( ) ;
         Gx_mode = sMode13 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0813( ) ;
      }
      pr_default.close(71);
   }

   public void checkOptimisticConcurrency0813( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000874 */
         pr_default.execute(72, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
         if ( (pr_default.getStatus(72) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalExperienciaLaboral"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(72) == 101) || ( GXutil.strcmp(Z204ExperienciaLaboralEmpresaNombre, BC000874_A204ExperienciaLaboralEmpresaNombre[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z205ExperienciaLaboralDesde), GXutil.resetTime(BC000874_A205ExperienciaLaboralDesde[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z206ExperienciaLaboralHasta), GXutil.resetTime(BC000874_A206ExperienciaLaboralHasta[0])) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalExperienciaLaboral"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0813( )
   {
      beforeValidate0813( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0813( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0813( 0) ;
         checkOptimisticConcurrency0813( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0813( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0813( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000875 */
                  pr_default.execute(73, new Object[] {Integer.valueOf(A31ProfesionalId), A204ExperienciaLaboralEmpresaNombre, A205ExperienciaLaboralDesde, A206ExperienciaLaboralHasta, A56ExperienciaLaboralId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalExperienciaLaboral");
                  if ( (pr_default.getStatus(73) == 1) )
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
            load0813( ) ;
         }
         endLevel0813( ) ;
      }
      closeExtendedTableCursors0813( ) ;
   }

   public void update0813( )
   {
      beforeValidate0813( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0813( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0813( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0813( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0813( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000876 */
                  pr_default.execute(74, new Object[] {A204ExperienciaLaboralEmpresaNombre, A205ExperienciaLaboralDesde, A206ExperienciaLaboralHasta, Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalExperienciaLaboral");
                  if ( (pr_default.getStatus(74) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalExperienciaLaboral"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0813( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0813( ) ;
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
         endLevel0813( ) ;
      }
      closeExtendedTableCursors0813( ) ;
   }

   public void deferredUpdate0813( )
   {
   }

   public void delete0813( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0813( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0813( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0813( ) ;
         afterConfirm0813( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0813( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000877 */
               pr_default.execute(75, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalExperienciaLaboral");
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
      sMode13 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0813( ) ;
      Gx_mode = sMode13 ;
   }

   public void onDeleteControls0813( )
   {
      standaloneModal0813( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0813( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(72);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0813( )
   {
      /* Scan By routine */
      /* Using cursor BC000878 */
      pr_default.execute(76, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(76) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A56ExperienciaLaboralId = BC000878_A56ExperienciaLaboralId[0] ;
         A204ExperienciaLaboralEmpresaNombre = BC000878_A204ExperienciaLaboralEmpresaNombre[0] ;
         A205ExperienciaLaboralDesde = BC000878_A205ExperienciaLaboralDesde[0] ;
         A206ExperienciaLaboralHasta = BC000878_A206ExperienciaLaboralHasta[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0813( )
   {
      /* Scan next routine */
      pr_default.readNext(76);
      RcdFound13 = (short)(0) ;
      scanKeyLoad0813( ) ;
   }

   public void scanKeyLoad0813( )
   {
      sMode13 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(76) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A56ExperienciaLaboralId = BC000878_A56ExperienciaLaboralId[0] ;
         A204ExperienciaLaboralEmpresaNombre = BC000878_A204ExperienciaLaboralEmpresaNombre[0] ;
         A205ExperienciaLaboralDesde = BC000878_A205ExperienciaLaboralDesde[0] ;
         A206ExperienciaLaboralHasta = BC000878_A206ExperienciaLaboralHasta[0] ;
      }
      Gx_mode = sMode13 ;
   }

   public void scanKeyEnd0813( )
   {
      pr_default.close(76);
   }

   public void afterConfirm0813( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0813( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0813( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0813( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0813( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0813( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0813( )
   {
   }

   public void send_integrity_lvl_hashes0813( )
   {
   }

   public void zm0814( int GX_JID )
   {
      if ( ( GX_JID == 42 ) || ( GX_JID == 0 ) )
      {
         Z207PremiosNombre = A207PremiosNombre ;
         Z208PremiosFecha = A208PremiosFecha ;
      }
      if ( GX_JID == -42 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z57PremiosId = A57PremiosId ;
         Z207PremiosNombre = A207PremiosNombre ;
         Z208PremiosFecha = A208PremiosFecha ;
         Z209PremiosDescripcion = A209PremiosDescripcion ;
      }
   }

   public void standaloneNotModal0814( )
   {
   }

   public void standaloneModal0814( )
   {
      if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A57PremiosId) )
      {
         A57PremiosId = java.util.UUID.randomUUID( ) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0814( )
   {
      /* Using cursor BC000879 */
      pr_default.execute(77, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
      if ( (pr_default.getStatus(77) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A207PremiosNombre = BC000879_A207PremiosNombre[0] ;
         A208PremiosFecha = BC000879_A208PremiosFecha[0] ;
         A209PremiosDescripcion = BC000879_A209PremiosDescripcion[0] ;
         zm0814( -42) ;
      }
      pr_default.close(77);
      onLoadActions0814( ) ;
   }

   public void onLoadActions0814( )
   {
   }

   public void checkExtendedTable0814( )
   {
      nIsDirty_14 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0814( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A208PremiosFecha)) || (( GXutil.resetTime(A208PremiosFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A208PremiosFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Premios Fecha fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0814( )
   {
   }

   public void enableDisable0814( )
   {
   }

   public void getKey0814( )
   {
      /* Using cursor BC000880 */
      pr_default.execute(78, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
      if ( (pr_default.getStatus(78) != 101) )
      {
         RcdFound14 = (short)(1) ;
      }
      else
      {
         RcdFound14 = (short)(0) ;
      }
      pr_default.close(78);
   }

   public void getByPrimaryKey0814( )
   {
      /* Using cursor BC000881 */
      pr_default.execute(79, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
      if ( (pr_default.getStatus(79) != 101) )
      {
         zm0814( 42) ;
         RcdFound14 = (short)(1) ;
         initializeNonKey0814( ) ;
         A57PremiosId = BC000881_A57PremiosId[0] ;
         A207PremiosNombre = BC000881_A207PremiosNombre[0] ;
         A208PremiosFecha = BC000881_A208PremiosFecha[0] ;
         A209PremiosDescripcion = BC000881_A209PremiosDescripcion[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z57PremiosId = A57PremiosId ;
         sMode14 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0814( ) ;
         load0814( ) ;
         Gx_mode = sMode14 ;
      }
      else
      {
         RcdFound14 = (short)(0) ;
         initializeNonKey0814( ) ;
         sMode14 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0814( ) ;
         Gx_mode = sMode14 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0814( ) ;
      }
      pr_default.close(79);
   }

   public void checkOptimisticConcurrency0814( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000882 */
         pr_default.execute(80, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
         if ( (pr_default.getStatus(80) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalPremios"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(80) == 101) || ( GXutil.strcmp(Z207PremiosNombre, BC000882_A207PremiosNombre[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z208PremiosFecha), GXutil.resetTime(BC000882_A208PremiosFecha[0])) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalPremios"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0814( )
   {
      beforeValidate0814( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0814( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0814( 0) ;
         checkOptimisticConcurrency0814( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0814( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0814( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000883 */
                  pr_default.execute(81, new Object[] {Integer.valueOf(A31ProfesionalId), A207PremiosNombre, A208PremiosFecha, A209PremiosDescripcion, A57PremiosId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalPremios");
                  if ( (pr_default.getStatus(81) == 1) )
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
            load0814( ) ;
         }
         endLevel0814( ) ;
      }
      closeExtendedTableCursors0814( ) ;
   }

   public void update0814( )
   {
      beforeValidate0814( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0814( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0814( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0814( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0814( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000884 */
                  pr_default.execute(82, new Object[] {A207PremiosNombre, A208PremiosFecha, A209PremiosDescripcion, Integer.valueOf(A31ProfesionalId), A57PremiosId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalPremios");
                  if ( (pr_default.getStatus(82) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalPremios"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0814( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0814( ) ;
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
         endLevel0814( ) ;
      }
      closeExtendedTableCursors0814( ) ;
   }

   public void deferredUpdate0814( )
   {
   }

   public void delete0814( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0814( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0814( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0814( ) ;
         afterConfirm0814( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0814( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000885 */
               pr_default.execute(83, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalPremios");
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
      sMode14 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0814( ) ;
      Gx_mode = sMode14 ;
   }

   public void onDeleteControls0814( )
   {
      standaloneModal0814( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0814( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(80);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0814( )
   {
      /* Scan By routine */
      /* Using cursor BC000886 */
      pr_default.execute(84, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound14 = (short)(0) ;
      if ( (pr_default.getStatus(84) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A57PremiosId = BC000886_A57PremiosId[0] ;
         A207PremiosNombre = BC000886_A207PremiosNombre[0] ;
         A208PremiosFecha = BC000886_A208PremiosFecha[0] ;
         A209PremiosDescripcion = BC000886_A209PremiosDescripcion[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0814( )
   {
      /* Scan next routine */
      pr_default.readNext(84);
      RcdFound14 = (short)(0) ;
      scanKeyLoad0814( ) ;
   }

   public void scanKeyLoad0814( )
   {
      sMode14 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(84) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A57PremiosId = BC000886_A57PremiosId[0] ;
         A207PremiosNombre = BC000886_A207PremiosNombre[0] ;
         A208PremiosFecha = BC000886_A208PremiosFecha[0] ;
         A209PremiosDescripcion = BC000886_A209PremiosDescripcion[0] ;
      }
      Gx_mode = sMode14 ;
   }

   public void scanKeyEnd0814( )
   {
      pr_default.close(84);
   }

   public void afterConfirm0814( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0814( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0814( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0814( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0814( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0814( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0814( )
   {
   }

   public void send_integrity_lvl_hashes0814( )
   {
   }

   public void zm0815( int GX_JID )
   {
      if ( ( GX_JID == 43 ) || ( GX_JID == 0 ) )
      {
         Z210ServiciosNombre = A210ServiciosNombre ;
      }
      if ( GX_JID == -43 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z58ServiciosId = A58ServiciosId ;
         Z210ServiciosNombre = A210ServiciosNombre ;
      }
   }

   public void standaloneNotModal0815( )
   {
   }

   public void standaloneModal0815( )
   {
      if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A58ServiciosId) )
      {
         A58ServiciosId = java.util.UUID.randomUUID( ) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0815( )
   {
      /* Using cursor BC000887 */
      pr_default.execute(85, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
      if ( (pr_default.getStatus(85) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A210ServiciosNombre = BC000887_A210ServiciosNombre[0] ;
         zm0815( -43) ;
      }
      pr_default.close(85);
      onLoadActions0815( ) ;
   }

   public void onLoadActions0815( )
   {
   }

   public void checkExtendedTable0815( )
   {
      nIsDirty_15 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0815( ) ;
      Gx_BScreen = (byte)(0) ;
   }

   public void closeExtendedTableCursors0815( )
   {
   }

   public void enableDisable0815( )
   {
   }

   public void getKey0815( )
   {
      /* Using cursor BC000888 */
      pr_default.execute(86, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
      if ( (pr_default.getStatus(86) != 101) )
      {
         RcdFound15 = (short)(1) ;
      }
      else
      {
         RcdFound15 = (short)(0) ;
      }
      pr_default.close(86);
   }

   public void getByPrimaryKey0815( )
   {
      /* Using cursor BC000889 */
      pr_default.execute(87, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
      if ( (pr_default.getStatus(87) != 101) )
      {
         zm0815( 43) ;
         RcdFound15 = (short)(1) ;
         initializeNonKey0815( ) ;
         A58ServiciosId = BC000889_A58ServiciosId[0] ;
         A210ServiciosNombre = BC000889_A210ServiciosNombre[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z58ServiciosId = A58ServiciosId ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0815( ) ;
         load0815( ) ;
         Gx_mode = sMode15 ;
      }
      else
      {
         RcdFound15 = (short)(0) ;
         initializeNonKey0815( ) ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0815( ) ;
         Gx_mode = sMode15 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0815( ) ;
      }
      pr_default.close(87);
   }

   public void checkOptimisticConcurrency0815( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000890 */
         pr_default.execute(88, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
         if ( (pr_default.getStatus(88) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalServicios"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(88) == 101) || ( GXutil.strcmp(Z210ServiciosNombre, BC000890_A210ServiciosNombre[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalServicios"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0815( )
   {
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0815( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0815( 0) ;
         checkOptimisticConcurrency0815( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0815( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0815( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000891 */
                  pr_default.execute(89, new Object[] {Integer.valueOf(A31ProfesionalId), A210ServiciosNombre, A58ServiciosId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalServicios");
                  if ( (pr_default.getStatus(89) == 1) )
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
            load0815( ) ;
         }
         endLevel0815( ) ;
      }
      closeExtendedTableCursors0815( ) ;
   }

   public void update0815( )
   {
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0815( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0815( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0815( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0815( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000892 */
                  pr_default.execute(90, new Object[] {A210ServiciosNombre, Integer.valueOf(A31ProfesionalId), A58ServiciosId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalServicios");
                  if ( (pr_default.getStatus(90) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalServicios"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0815( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0815( ) ;
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
         endLevel0815( ) ;
      }
      closeExtendedTableCursors0815( ) ;
   }

   public void deferredUpdate0815( )
   {
   }

   public void delete0815( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0815( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0815( ) ;
         afterConfirm0815( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0815( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000893 */
               pr_default.execute(91, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalServicios");
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
      sMode15 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0815( ) ;
      Gx_mode = sMode15 ;
   }

   public void onDeleteControls0815( )
   {
      standaloneModal0815( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0815( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(88);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0815( )
   {
      /* Scan By routine */
      /* Using cursor BC000894 */
      pr_default.execute(92, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound15 = (short)(0) ;
      if ( (pr_default.getStatus(92) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A58ServiciosId = BC000894_A58ServiciosId[0] ;
         A210ServiciosNombre = BC000894_A210ServiciosNombre[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0815( )
   {
      /* Scan next routine */
      pr_default.readNext(92);
      RcdFound15 = (short)(0) ;
      scanKeyLoad0815( ) ;
   }

   public void scanKeyLoad0815( )
   {
      sMode15 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(92) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A58ServiciosId = BC000894_A58ServiciosId[0] ;
         A210ServiciosNombre = BC000894_A210ServiciosNombre[0] ;
      }
      Gx_mode = sMode15 ;
   }

   public void scanKeyEnd0815( )
   {
      pr_default.close(92);
   }

   public void afterConfirm0815( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0815( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0815( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0815( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0815( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0815( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0815( )
   {
   }

   public void send_integrity_lvl_hashes0815( )
   {
   }

   public void send_integrity_lvl_hashes089( )
   {
   }

   public void addRow089( )
   {
      VarsToRow9( bcProfesional) ;
   }

   public void readRow089( )
   {
      RowToVars9( bcProfesional, 1) ;
   }

   public void addRow0810( )
   {
      com.projectthani.SdtProfesional_Especialidad obj10;
      obj10 = new com.projectthani.SdtProfesional_Especialidad(remoteHandle);
      VarsToRow10( obj10) ;
      bcProfesional.getgxTv_SdtProfesional_Especialidad().add(obj10, 0);
      obj10.setgxTv_SdtProfesional_Especialidad_Mode( "UPD" );
      obj10.setgxTv_SdtProfesional_Especialidad_Modified( (short)(0) );
   }

   public void readRow0810( )
   {
      nGXsfl_10_idx = (int)(nGXsfl_10_idx+1) ;
      RowToVars10( ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)), 1) ;
   }

   public void addRow0811( )
   {
      com.projectthani.SdtProfesional_Especialidad_Sede obj11;
      obj11 = new com.projectthani.SdtProfesional_Especialidad_Sede(remoteHandle);
      VarsToRow11( obj11) ;
      ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().add(obj11, 0);
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Mode( "UPD" );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Modified( (short)(0) );
   }

   public void readRow0811( )
   {
      nGXsfl_11_idx = (int)(nGXsfl_11_idx+1) ;
      RowToVars11( ((com.projectthani.SdtProfesional_Especialidad_Sede)((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().elementAt(-1+nGXsfl_11_idx)), 1) ;
   }

   public void addRow0812( )
   {
      com.projectthani.SdtProfesional_Educacion obj12;
      obj12 = new com.projectthani.SdtProfesional_Educacion(remoteHandle);
      VarsToRow12( obj12) ;
      bcProfesional.getgxTv_SdtProfesional_Educacion().add(obj12, 0);
      obj12.setgxTv_SdtProfesional_Educacion_Mode( "UPD" );
      obj12.setgxTv_SdtProfesional_Educacion_Modified( (short)(0) );
   }

   public void readRow0812( )
   {
      nGXsfl_12_idx = (int)(nGXsfl_12_idx+1) ;
      RowToVars12( ((com.projectthani.SdtProfesional_Educacion)bcProfesional.getgxTv_SdtProfesional_Educacion().elementAt(-1+nGXsfl_12_idx)), 1) ;
   }

   public void addRow0813( )
   {
      com.projectthani.SdtProfesional_ExperienciaLaboral obj13;
      obj13 = new com.projectthani.SdtProfesional_ExperienciaLaboral(remoteHandle);
      VarsToRow13( obj13) ;
      bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().add(obj13, 0);
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Mode( "UPD" );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Modified( (short)(0) );
   }

   public void readRow0813( )
   {
      nGXsfl_13_idx = (int)(nGXsfl_13_idx+1) ;
      RowToVars13( ((com.projectthani.SdtProfesional_ExperienciaLaboral)bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().elementAt(-1+nGXsfl_13_idx)), 1) ;
   }

   public void addRow0814( )
   {
      com.projectthani.SdtProfesional_Premios obj14;
      obj14 = new com.projectthani.SdtProfesional_Premios(remoteHandle);
      VarsToRow14( obj14) ;
      bcProfesional.getgxTv_SdtProfesional_Premios().add(obj14, 0);
      obj14.setgxTv_SdtProfesional_Premios_Mode( "UPD" );
      obj14.setgxTv_SdtProfesional_Premios_Modified( (short)(0) );
   }

   public void readRow0814( )
   {
      nGXsfl_14_idx = (int)(nGXsfl_14_idx+1) ;
      RowToVars14( ((com.projectthani.SdtProfesional_Premios)bcProfesional.getgxTv_SdtProfesional_Premios().elementAt(-1+nGXsfl_14_idx)), 1) ;
   }

   public void addRow0815( )
   {
      com.projectthani.SdtProfesional_Servicios obj15;
      obj15 = new com.projectthani.SdtProfesional_Servicios(remoteHandle);
      VarsToRow15( obj15) ;
      bcProfesional.getgxTv_SdtProfesional_Servicios().add(obj15, 0);
      obj15.setgxTv_SdtProfesional_Servicios_Mode( "UPD" );
      obj15.setgxTv_SdtProfesional_Servicios_Modified( (short)(0) );
   }

   public void readRow0815( )
   {
      nGXsfl_15_idx = (int)(nGXsfl_15_idx+1) ;
      RowToVars15( ((com.projectthani.SdtProfesional_Servicios)bcProfesional.getgxTv_SdtProfesional_Servicios().elementAt(-1+nGXsfl_15_idx)), 1) ;
   }

   public void initializeNonKey089( )
   {
      A175ProfesionalNombreCompleto2 = "" ;
      A173ProfesionalTipoDocumento = "" ;
      A174ProfesionalNroDocumento = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      A177ProfesionalSexo = "" ;
      A178ProfesionalDescripcion = "" ;
      A179ProfesionalCorreo = "" ;
      A88ProfesionalCOP = "" ;
      A180ProfesionalColorDisponible = "" ;
      A181ProfesionalColorCita = "" ;
      A183ProfesionalDireccion = "" ;
      A43PaisId = (short)(0) ;
      A184PaisDescripcion = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A189ProfesionalFoto = "" ;
      A40000ProfesionalFoto_GXI = "" ;
      A190ProfesionalTwitter = "" ;
      A191ProfesionalFacebook = "" ;
      A192ProfesionalInstagram = "" ;
      A193ProfesionalLinkedin = "" ;
      A194ProfesionalTelefono = "" ;
      A6SecUserId = (short)(0) ;
      A195ProfesionalFechaRegistro = GXutil.nullDate() ;
      A196ProfesionalTerminosCondiciones = false ;
      A197ProfesionalEstadoCuenta = "" ;
      A198ProfesionalEstado = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      A182ProfesionalTiempoCita = (byte)(30) ;
      Z173ProfesionalTipoDocumento = "" ;
      Z174ProfesionalNroDocumento = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      Z84ProfesionalNombres = "" ;
      Z176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      Z177ProfesionalSexo = "" ;
      Z178ProfesionalDescripcion = "" ;
      Z179ProfesionalCorreo = "" ;
      Z88ProfesionalCOP = "" ;
      Z180ProfesionalColorDisponible = "" ;
      Z181ProfesionalColorCita = "" ;
      Z182ProfesionalTiempoCita = (byte)(0) ;
      Z183ProfesionalDireccion = "" ;
      Z190ProfesionalTwitter = "" ;
      Z191ProfesionalFacebook = "" ;
      Z192ProfesionalInstagram = "" ;
      Z193ProfesionalLinkedin = "" ;
      Z194ProfesionalTelefono = "" ;
      Z195ProfesionalFechaRegistro = GXutil.nullDate() ;
      Z196ProfesionalTerminosCondiciones = false ;
      Z197ProfesionalEstadoCuenta = "" ;
      Z198ProfesionalEstado = "" ;
      Z43PaisId = (short)(0) ;
      Z44UbigeoCode = "" ;
      Z6SecUserId = (short)(0) ;
   }

   public void initAll089( )
   {
      A31ProfesionalId = 0 ;
      initializeNonKey089( ) ;
   }

   public void standaloneModalInsert( )
   {
      A182ProfesionalTiempoCita = i182ProfesionalTiempoCita ;
   }

   public void initializeNonKey0810( )
   {
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
   }

   public void initAll0810( )
   {
      A32EspecialidadId = (short)(0) ;
      initializeNonKey0810( ) ;
   }

   public void standaloneModalInsert0810( )
   {
   }

   public void initializeNonKey0811( )
   {
      A28ClinicaId = (short)(0) ;
      A75SedeNombre = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      Z199CostoConsulta = DecimalUtil.ZERO ;
   }

   public void initAll0811( )
   {
      A30SedeId = (short)(0) ;
      A54SedeTipoConsulta = "" ;
      initializeNonKey0811( ) ;
   }

   public void standaloneModalInsert0811( )
   {
      A199CostoConsulta = i199CostoConsulta ;
   }

   public void initializeNonKey0812( )
   {
      A200EducacionNombreInstitucion = "" ;
      A201EducacionDesde = GXutil.nullDate() ;
      A202EducacionHasta = GXutil.nullDate() ;
      A203EducacionPaisDescripcion = "" ;
      Z200EducacionNombreInstitucion = "" ;
      Z201EducacionDesde = GXutil.nullDate() ;
      Z202EducacionHasta = GXutil.nullDate() ;
      Z203EducacionPaisDescripcion = "" ;
   }

   public void initAll0812( )
   {
      A55EducacionId = java.util.UUID.randomUUID( ) ;
      initializeNonKey0812( ) ;
   }

   public void standaloneModalInsert0812( )
   {
   }

   public void initializeNonKey0813( )
   {
      A204ExperienciaLaboralEmpresaNombre = "" ;
      A205ExperienciaLaboralDesde = GXutil.nullDate() ;
      A206ExperienciaLaboralHasta = GXutil.nullDate() ;
      Z204ExperienciaLaboralEmpresaNombre = "" ;
      Z205ExperienciaLaboralDesde = GXutil.nullDate() ;
      Z206ExperienciaLaboralHasta = GXutil.nullDate() ;
   }

   public void initAll0813( )
   {
      A56ExperienciaLaboralId = java.util.UUID.randomUUID( ) ;
      initializeNonKey0813( ) ;
   }

   public void standaloneModalInsert0813( )
   {
   }

   public void initializeNonKey0814( )
   {
      A207PremiosNombre = "" ;
      A208PremiosFecha = GXutil.nullDate() ;
      A209PremiosDescripcion = "" ;
      Z207PremiosNombre = "" ;
      Z208PremiosFecha = GXutil.nullDate() ;
   }

   public void initAll0814( )
   {
      A57PremiosId = java.util.UUID.randomUUID( ) ;
      initializeNonKey0814( ) ;
   }

   public void standaloneModalInsert0814( )
   {
   }

   public void initializeNonKey0815( )
   {
      A210ServiciosNombre = "" ;
      Z210ServiciosNombre = "" ;
   }

   public void initAll0815( )
   {
      A58ServiciosId = java.util.UUID.randomUUID( ) ;
      initializeNonKey0815( ) ;
   }

   public void standaloneModalInsert0815( )
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

   public void VarsToRow9( com.projectthani.SdtProfesional obj9 )
   {
      obj9.setgxTv_SdtProfesional_Mode( Gx_mode );
      obj9.setgxTv_SdtProfesional_Profesionalnombrecompleto2( A175ProfesionalNombreCompleto2 );
      obj9.setgxTv_SdtProfesional_Profesionaltipodocumento( A173ProfesionalTipoDocumento );
      obj9.setgxTv_SdtProfesional_Profesionalnrodocumento( A174ProfesionalNroDocumento );
      obj9.setgxTv_SdtProfesional_Profesionalapellidopaterno( A85ProfesionalApellidoPaterno );
      obj9.setgxTv_SdtProfesional_Profesionalapellidomaterno( A86ProfesionalApellidoMaterno );
      obj9.setgxTv_SdtProfesional_Profesionalnombres( A84ProfesionalNombres );
      obj9.setgxTv_SdtProfesional_Profesionalfechanacimiento( A176ProfesionalFechaNacimiento );
      obj9.setgxTv_SdtProfesional_Profesionalsexo( A177ProfesionalSexo );
      obj9.setgxTv_SdtProfesional_Profesionaldescripcion( A178ProfesionalDescripcion );
      obj9.setgxTv_SdtProfesional_Profesionalcorreo( A179ProfesionalCorreo );
      obj9.setgxTv_SdtProfesional_Profesionalcop( A88ProfesionalCOP );
      obj9.setgxTv_SdtProfesional_Profesionalcolordisponible( A180ProfesionalColorDisponible );
      obj9.setgxTv_SdtProfesional_Profesionalcolorcita( A181ProfesionalColorCita );
      obj9.setgxTv_SdtProfesional_Profesionaldireccion( A183ProfesionalDireccion );
      obj9.setgxTv_SdtProfesional_Paisid( A43PaisId );
      obj9.setgxTv_SdtProfesional_Paisdescripcion( A184PaisDescripcion );
      obj9.setgxTv_SdtProfesional_Ubigeocode( A44UbigeoCode );
      obj9.setgxTv_SdtProfesional_Ubigeonombre( A185UbigeoNombre );
      obj9.setgxTv_SdtProfesional_Profesionalfoto( A189ProfesionalFoto );
      obj9.setgxTv_SdtProfesional_Profesionalfoto_gxi( A40000ProfesionalFoto_GXI );
      obj9.setgxTv_SdtProfesional_Profesionaltwitter( A190ProfesionalTwitter );
      obj9.setgxTv_SdtProfesional_Profesionalfacebook( A191ProfesionalFacebook );
      obj9.setgxTv_SdtProfesional_Profesionalinstagram( A192ProfesionalInstagram );
      obj9.setgxTv_SdtProfesional_Profesionallinkedin( A193ProfesionalLinkedin );
      obj9.setgxTv_SdtProfesional_Profesionaltelefono( A194ProfesionalTelefono );
      obj9.setgxTv_SdtProfesional_Secuserid( A6SecUserId );
      obj9.setgxTv_SdtProfesional_Profesionalfecharegistro( A195ProfesionalFechaRegistro );
      obj9.setgxTv_SdtProfesional_Profesionalterminoscondiciones( A196ProfesionalTerminosCondiciones );
      obj9.setgxTv_SdtProfesional_Profesionalestadocuenta( A197ProfesionalEstadoCuenta );
      obj9.setgxTv_SdtProfesional_Profesionalestado( A198ProfesionalEstado );
      obj9.setgxTv_SdtProfesional_Profesionaltiempocita( A182ProfesionalTiempoCita );
      obj9.setgxTv_SdtProfesional_Profesionalid( A31ProfesionalId );
      obj9.setgxTv_SdtProfesional_Profesionalid_Z( Z31ProfesionalId );
      obj9.setgxTv_SdtProfesional_Profesionaltipodocumento_Z( Z173ProfesionalTipoDocumento );
      obj9.setgxTv_SdtProfesional_Profesionalnrodocumento_Z( Z174ProfesionalNroDocumento );
      obj9.setgxTv_SdtProfesional_Profesionalapellidopaterno_Z( Z85ProfesionalApellidoPaterno );
      obj9.setgxTv_SdtProfesional_Profesionalapellidomaterno_Z( Z86ProfesionalApellidoMaterno );
      obj9.setgxTv_SdtProfesional_Profesionalnombres_Z( Z84ProfesionalNombres );
      obj9.setgxTv_SdtProfesional_Profesionalnombrecompleto2_Z( Z175ProfesionalNombreCompleto2 );
      obj9.setgxTv_SdtProfesional_Profesionalfechanacimiento_Z( Z176ProfesionalFechaNacimiento );
      obj9.setgxTv_SdtProfesional_Profesionalsexo_Z( Z177ProfesionalSexo );
      obj9.setgxTv_SdtProfesional_Profesionaldescripcion_Z( Z178ProfesionalDescripcion );
      obj9.setgxTv_SdtProfesional_Profesionalcorreo_Z( Z179ProfesionalCorreo );
      obj9.setgxTv_SdtProfesional_Profesionalcop_Z( Z88ProfesionalCOP );
      obj9.setgxTv_SdtProfesional_Profesionalcolordisponible_Z( Z180ProfesionalColorDisponible );
      obj9.setgxTv_SdtProfesional_Profesionalcolorcita_Z( Z181ProfesionalColorCita );
      obj9.setgxTv_SdtProfesional_Profesionaltiempocita_Z( Z182ProfesionalTiempoCita );
      obj9.setgxTv_SdtProfesional_Profesionaldireccion_Z( Z183ProfesionalDireccion );
      obj9.setgxTv_SdtProfesional_Paisid_Z( Z43PaisId );
      obj9.setgxTv_SdtProfesional_Paisdescripcion_Z( Z184PaisDescripcion );
      obj9.setgxTv_SdtProfesional_Ubigeocode_Z( Z44UbigeoCode );
      obj9.setgxTv_SdtProfesional_Ubigeonombre_Z( Z185UbigeoNombre );
      obj9.setgxTv_SdtProfesional_Profesionaltwitter_Z( Z190ProfesionalTwitter );
      obj9.setgxTv_SdtProfesional_Profesionalfacebook_Z( Z191ProfesionalFacebook );
      obj9.setgxTv_SdtProfesional_Profesionalinstagram_Z( Z192ProfesionalInstagram );
      obj9.setgxTv_SdtProfesional_Profesionallinkedin_Z( Z193ProfesionalLinkedin );
      obj9.setgxTv_SdtProfesional_Profesionaltelefono_Z( Z194ProfesionalTelefono );
      obj9.setgxTv_SdtProfesional_Secuserid_Z( Z6SecUserId );
      obj9.setgxTv_SdtProfesional_Profesionalfecharegistro_Z( Z195ProfesionalFechaRegistro );
      obj9.setgxTv_SdtProfesional_Profesionalterminoscondiciones_Z( Z196ProfesionalTerminosCondiciones );
      obj9.setgxTv_SdtProfesional_Profesionalestadocuenta_Z( Z197ProfesionalEstadoCuenta );
      obj9.setgxTv_SdtProfesional_Profesionalestado_Z( Z198ProfesionalEstado );
      obj9.setgxTv_SdtProfesional_Profesionalfoto_gxi_Z( Z40000ProfesionalFoto_GXI );
      obj9.setgxTv_SdtProfesional_Mode( Gx_mode );
   }

   public void KeyVarsToRow9( com.projectthani.SdtProfesional obj9 )
   {
      obj9.setgxTv_SdtProfesional_Profesionalid( A31ProfesionalId );
   }

   public void RowToVars9( com.projectthani.SdtProfesional obj9 ,
                           int forceLoad )
   {
      Gx_mode = obj9.getgxTv_SdtProfesional_Mode() ;
      A175ProfesionalNombreCompleto2 = obj9.getgxTv_SdtProfesional_Profesionalnombrecompleto2() ;
      A173ProfesionalTipoDocumento = obj9.getgxTv_SdtProfesional_Profesionaltipodocumento() ;
      A174ProfesionalNroDocumento = obj9.getgxTv_SdtProfesional_Profesionalnrodocumento() ;
      A85ProfesionalApellidoPaterno = obj9.getgxTv_SdtProfesional_Profesionalapellidopaterno() ;
      A86ProfesionalApellidoMaterno = obj9.getgxTv_SdtProfesional_Profesionalapellidomaterno() ;
      A84ProfesionalNombres = obj9.getgxTv_SdtProfesional_Profesionalnombres() ;
      A176ProfesionalFechaNacimiento = obj9.getgxTv_SdtProfesional_Profesionalfechanacimiento() ;
      A177ProfesionalSexo = obj9.getgxTv_SdtProfesional_Profesionalsexo() ;
      A178ProfesionalDescripcion = obj9.getgxTv_SdtProfesional_Profesionaldescripcion() ;
      A179ProfesionalCorreo = obj9.getgxTv_SdtProfesional_Profesionalcorreo() ;
      A88ProfesionalCOP = obj9.getgxTv_SdtProfesional_Profesionalcop() ;
      A180ProfesionalColorDisponible = obj9.getgxTv_SdtProfesional_Profesionalcolordisponible() ;
      A181ProfesionalColorCita = obj9.getgxTv_SdtProfesional_Profesionalcolorcita() ;
      A183ProfesionalDireccion = obj9.getgxTv_SdtProfesional_Profesionaldireccion() ;
      A43PaisId = obj9.getgxTv_SdtProfesional_Paisid() ;
      A184PaisDescripcion = obj9.getgxTv_SdtProfesional_Paisdescripcion() ;
      A44UbigeoCode = obj9.getgxTv_SdtProfesional_Ubigeocode() ;
      A185UbigeoNombre = obj9.getgxTv_SdtProfesional_Ubigeonombre() ;
      A189ProfesionalFoto = obj9.getgxTv_SdtProfesional_Profesionalfoto() ;
      A40000ProfesionalFoto_GXI = obj9.getgxTv_SdtProfesional_Profesionalfoto_gxi() ;
      A190ProfesionalTwitter = obj9.getgxTv_SdtProfesional_Profesionaltwitter() ;
      A191ProfesionalFacebook = obj9.getgxTv_SdtProfesional_Profesionalfacebook() ;
      A192ProfesionalInstagram = obj9.getgxTv_SdtProfesional_Profesionalinstagram() ;
      A193ProfesionalLinkedin = obj9.getgxTv_SdtProfesional_Profesionallinkedin() ;
      A194ProfesionalTelefono = obj9.getgxTv_SdtProfesional_Profesionaltelefono() ;
      A6SecUserId = obj9.getgxTv_SdtProfesional_Secuserid() ;
      A195ProfesionalFechaRegistro = obj9.getgxTv_SdtProfesional_Profesionalfecharegistro() ;
      A196ProfesionalTerminosCondiciones = obj9.getgxTv_SdtProfesional_Profesionalterminoscondiciones() ;
      A197ProfesionalEstadoCuenta = obj9.getgxTv_SdtProfesional_Profesionalestadocuenta() ;
      A198ProfesionalEstado = obj9.getgxTv_SdtProfesional_Profesionalestado() ;
      A182ProfesionalTiempoCita = obj9.getgxTv_SdtProfesional_Profesionaltiempocita() ;
      A31ProfesionalId = obj9.getgxTv_SdtProfesional_Profesionalid() ;
      Z31ProfesionalId = obj9.getgxTv_SdtProfesional_Profesionalid_Z() ;
      Z173ProfesionalTipoDocumento = obj9.getgxTv_SdtProfesional_Profesionaltipodocumento_Z() ;
      Z174ProfesionalNroDocumento = obj9.getgxTv_SdtProfesional_Profesionalnrodocumento_Z() ;
      Z85ProfesionalApellidoPaterno = obj9.getgxTv_SdtProfesional_Profesionalapellidopaterno_Z() ;
      Z86ProfesionalApellidoMaterno = obj9.getgxTv_SdtProfesional_Profesionalapellidomaterno_Z() ;
      Z84ProfesionalNombres = obj9.getgxTv_SdtProfesional_Profesionalnombres_Z() ;
      Z175ProfesionalNombreCompleto2 = obj9.getgxTv_SdtProfesional_Profesionalnombrecompleto2_Z() ;
      Z176ProfesionalFechaNacimiento = obj9.getgxTv_SdtProfesional_Profesionalfechanacimiento_Z() ;
      Z177ProfesionalSexo = obj9.getgxTv_SdtProfesional_Profesionalsexo_Z() ;
      Z178ProfesionalDescripcion = obj9.getgxTv_SdtProfesional_Profesionaldescripcion_Z() ;
      Z179ProfesionalCorreo = obj9.getgxTv_SdtProfesional_Profesionalcorreo_Z() ;
      Z88ProfesionalCOP = obj9.getgxTv_SdtProfesional_Profesionalcop_Z() ;
      Z180ProfesionalColorDisponible = obj9.getgxTv_SdtProfesional_Profesionalcolordisponible_Z() ;
      Z181ProfesionalColorCita = obj9.getgxTv_SdtProfesional_Profesionalcolorcita_Z() ;
      Z182ProfesionalTiempoCita = obj9.getgxTv_SdtProfesional_Profesionaltiempocita_Z() ;
      Z183ProfesionalDireccion = obj9.getgxTv_SdtProfesional_Profesionaldireccion_Z() ;
      Z43PaisId = obj9.getgxTv_SdtProfesional_Paisid_Z() ;
      Z184PaisDescripcion = obj9.getgxTv_SdtProfesional_Paisdescripcion_Z() ;
      Z44UbigeoCode = obj9.getgxTv_SdtProfesional_Ubigeocode_Z() ;
      Z185UbigeoNombre = obj9.getgxTv_SdtProfesional_Ubigeonombre_Z() ;
      Z190ProfesionalTwitter = obj9.getgxTv_SdtProfesional_Profesionaltwitter_Z() ;
      Z191ProfesionalFacebook = obj9.getgxTv_SdtProfesional_Profesionalfacebook_Z() ;
      Z192ProfesionalInstagram = obj9.getgxTv_SdtProfesional_Profesionalinstagram_Z() ;
      Z193ProfesionalLinkedin = obj9.getgxTv_SdtProfesional_Profesionallinkedin_Z() ;
      Z194ProfesionalTelefono = obj9.getgxTv_SdtProfesional_Profesionaltelefono_Z() ;
      Z6SecUserId = obj9.getgxTv_SdtProfesional_Secuserid_Z() ;
      Z195ProfesionalFechaRegistro = obj9.getgxTv_SdtProfesional_Profesionalfecharegistro_Z() ;
      Z196ProfesionalTerminosCondiciones = obj9.getgxTv_SdtProfesional_Profesionalterminoscondiciones_Z() ;
      Z197ProfesionalEstadoCuenta = obj9.getgxTv_SdtProfesional_Profesionalestadocuenta_Z() ;
      Z198ProfesionalEstado = obj9.getgxTv_SdtProfesional_Profesionalestado_Z() ;
      Z40000ProfesionalFoto_GXI = obj9.getgxTv_SdtProfesional_Profesionalfoto_gxi_Z() ;
      Gx_mode = obj9.getgxTv_SdtProfesional_Mode() ;
   }

   public void VarsToRow10( com.projectthani.SdtProfesional_Especialidad obj10 )
   {
      obj10.setgxTv_SdtProfesional_Especialidad_Mode( Gx_mode );
      obj10.setgxTv_SdtProfesional_Especialidad_Especialidadcodigo( A140EspecialidadCodigo );
      obj10.setgxTv_SdtProfesional_Especialidad_Especialidadnombre( A71EspecialidadNombre );
      obj10.setgxTv_SdtProfesional_Especialidad_Especialidadid( A32EspecialidadId );
      obj10.setgxTv_SdtProfesional_Especialidad_Especialidadid_Z( Z32EspecialidadId );
      obj10.setgxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z( Z140EspecialidadCodigo );
      obj10.setgxTv_SdtProfesional_Especialidad_Especialidadnombre_Z( Z71EspecialidadNombre );
      obj10.setgxTv_SdtProfesional_Especialidad_Modified( nIsMod_10 );
   }

   public void KeyVarsToRow10( com.projectthani.SdtProfesional_Especialidad obj10 )
   {
      obj10.setgxTv_SdtProfesional_Especialidad_Especialidadid( A32EspecialidadId );
   }

   public void RowToVars10( com.projectthani.SdtProfesional_Especialidad obj10 ,
                            int forceLoad )
   {
      Gx_mode = obj10.getgxTv_SdtProfesional_Especialidad_Mode() ;
      A140EspecialidadCodigo = obj10.getgxTv_SdtProfesional_Especialidad_Especialidadcodigo() ;
      A71EspecialidadNombre = obj10.getgxTv_SdtProfesional_Especialidad_Especialidadnombre() ;
      A32EspecialidadId = obj10.getgxTv_SdtProfesional_Especialidad_Especialidadid() ;
      Z32EspecialidadId = obj10.getgxTv_SdtProfesional_Especialidad_Especialidadid_Z() ;
      Z140EspecialidadCodigo = obj10.getgxTv_SdtProfesional_Especialidad_Especialidadcodigo_Z() ;
      Z71EspecialidadNombre = obj10.getgxTv_SdtProfesional_Especialidad_Especialidadnombre_Z() ;
      nIsMod_10 = obj10.getgxTv_SdtProfesional_Especialidad_Modified() ;
   }

   public void VarsToRow11( com.projectthani.SdtProfesional_Especialidad_Sede obj11 )
   {
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Mode( Gx_mode );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Sedenombre( A75SedeNombre );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado( A80ClinicaNombreAbreviado );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta( A199CostoConsulta );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Sedeid( A30SedeId );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta( A54SedeTipoConsulta );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z( Z30SedeId );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z( Z54SedeTipoConsulta );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z( Z75SedeNombre );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z( Z80ClinicaNombreAbreviado );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z( Z199CostoConsulta );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Modified( nIsMod_11 );
   }

   public void KeyVarsToRow11( com.projectthani.SdtProfesional_Especialidad_Sede obj11 )
   {
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Sedeid( A30SedeId );
      obj11.setgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta( A54SedeTipoConsulta );
   }

   public void RowToVars11( com.projectthani.SdtProfesional_Especialidad_Sede obj11 ,
                            int forceLoad )
   {
      Gx_mode = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Mode() ;
      A75SedeNombre = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Sedenombre() ;
      A80ClinicaNombreAbreviado = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado() ;
      A199CostoConsulta = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta() ;
      A30SedeId = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Sedeid() ;
      A54SedeTipoConsulta = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta() ;
      Z30SedeId = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Sedeid_Z() ;
      Z54SedeTipoConsulta = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Sedetipoconsulta_Z() ;
      Z75SedeNombre = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Sedenombre_Z() ;
      Z80ClinicaNombreAbreviado = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Clinicanombreabreviado_Z() ;
      Z199CostoConsulta = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Costoconsulta_Z() ;
      nIsMod_11 = obj11.getgxTv_SdtProfesional_Especialidad_Sede_Modified() ;
   }

   public void VarsToRow12( com.projectthani.SdtProfesional_Educacion obj12 )
   {
      obj12.setgxTv_SdtProfesional_Educacion_Mode( Gx_mode );
      obj12.setgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion( A200EducacionNombreInstitucion );
      obj12.setgxTv_SdtProfesional_Educacion_Educaciondesde( A201EducacionDesde );
      obj12.setgxTv_SdtProfesional_Educacion_Educacionhasta( A202EducacionHasta );
      obj12.setgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion( A203EducacionPaisDescripcion );
      obj12.setgxTv_SdtProfesional_Educacion_Educacionid( A55EducacionId );
      obj12.setgxTv_SdtProfesional_Educacion_Educacionid_Z( Z55EducacionId );
      obj12.setgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z( Z200EducacionNombreInstitucion );
      obj12.setgxTv_SdtProfesional_Educacion_Educaciondesde_Z( Z201EducacionDesde );
      obj12.setgxTv_SdtProfesional_Educacion_Educacionhasta_Z( Z202EducacionHasta );
      obj12.setgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z( Z203EducacionPaisDescripcion );
      obj12.setgxTv_SdtProfesional_Educacion_Modified( nIsMod_12 );
   }

   public void KeyVarsToRow12( com.projectthani.SdtProfesional_Educacion obj12 )
   {
      obj12.setgxTv_SdtProfesional_Educacion_Educacionid( A55EducacionId );
   }

   public void RowToVars12( com.projectthani.SdtProfesional_Educacion obj12 ,
                            int forceLoad )
   {
      Gx_mode = obj12.getgxTv_SdtProfesional_Educacion_Mode() ;
      A200EducacionNombreInstitucion = obj12.getgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion() ;
      A201EducacionDesde = obj12.getgxTv_SdtProfesional_Educacion_Educaciondesde() ;
      A202EducacionHasta = obj12.getgxTv_SdtProfesional_Educacion_Educacionhasta() ;
      A203EducacionPaisDescripcion = obj12.getgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion() ;
      A55EducacionId = obj12.getgxTv_SdtProfesional_Educacion_Educacionid() ;
      Z55EducacionId = obj12.getgxTv_SdtProfesional_Educacion_Educacionid_Z() ;
      Z200EducacionNombreInstitucion = obj12.getgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion_Z() ;
      Z201EducacionDesde = obj12.getgxTv_SdtProfesional_Educacion_Educaciondesde_Z() ;
      Z202EducacionHasta = obj12.getgxTv_SdtProfesional_Educacion_Educacionhasta_Z() ;
      Z203EducacionPaisDescripcion = obj12.getgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion_Z() ;
      nIsMod_12 = obj12.getgxTv_SdtProfesional_Educacion_Modified() ;
   }

   public void VarsToRow13( com.projectthani.SdtProfesional_ExperienciaLaboral obj13 )
   {
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Mode( Gx_mode );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre( A204ExperienciaLaboralEmpresaNombre );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde( A205ExperienciaLaboralDesde );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta( A206ExperienciaLaboralHasta );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid( A56ExperienciaLaboralId );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z( Z56ExperienciaLaboralId );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z( Z204ExperienciaLaboralEmpresaNombre );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z( Z205ExperienciaLaboralDesde );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z( Z206ExperienciaLaboralHasta );
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Modified( nIsMod_13 );
   }

   public void KeyVarsToRow13( com.projectthani.SdtProfesional_ExperienciaLaboral obj13 )
   {
      obj13.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid( A56ExperienciaLaboralId );
   }

   public void RowToVars13( com.projectthani.SdtProfesional_ExperienciaLaboral obj13 ,
                            int forceLoad )
   {
      Gx_mode = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Mode() ;
      A204ExperienciaLaboralEmpresaNombre = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre() ;
      A205ExperienciaLaboralDesde = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde() ;
      A206ExperienciaLaboralHasta = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta() ;
      A56ExperienciaLaboralId = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid() ;
      Z56ExperienciaLaboralId = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid_Z() ;
      Z204ExperienciaLaboralEmpresaNombre = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre_Z() ;
      Z205ExperienciaLaboralDesde = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde_Z() ;
      Z206ExperienciaLaboralHasta = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta_Z() ;
      nIsMod_13 = obj13.getgxTv_SdtProfesional_ExperienciaLaboral_Modified() ;
   }

   public void VarsToRow14( com.projectthani.SdtProfesional_Premios obj14 )
   {
      obj14.setgxTv_SdtProfesional_Premios_Mode( Gx_mode );
      obj14.setgxTv_SdtProfesional_Premios_Premiosnombre( A207PremiosNombre );
      obj14.setgxTv_SdtProfesional_Premios_Premiosfecha( A208PremiosFecha );
      obj14.setgxTv_SdtProfesional_Premios_Premiosdescripcion( A209PremiosDescripcion );
      obj14.setgxTv_SdtProfesional_Premios_Premiosid( A57PremiosId );
      obj14.setgxTv_SdtProfesional_Premios_Premiosid_Z( Z57PremiosId );
      obj14.setgxTv_SdtProfesional_Premios_Premiosnombre_Z( Z207PremiosNombre );
      obj14.setgxTv_SdtProfesional_Premios_Premiosfecha_Z( Z208PremiosFecha );
      obj14.setgxTv_SdtProfesional_Premios_Modified( nIsMod_14 );
   }

   public void KeyVarsToRow14( com.projectthani.SdtProfesional_Premios obj14 )
   {
      obj14.setgxTv_SdtProfesional_Premios_Premiosid( A57PremiosId );
   }

   public void RowToVars14( com.projectthani.SdtProfesional_Premios obj14 ,
                            int forceLoad )
   {
      Gx_mode = obj14.getgxTv_SdtProfesional_Premios_Mode() ;
      A207PremiosNombre = obj14.getgxTv_SdtProfesional_Premios_Premiosnombre() ;
      A208PremiosFecha = obj14.getgxTv_SdtProfesional_Premios_Premiosfecha() ;
      A209PremiosDescripcion = obj14.getgxTv_SdtProfesional_Premios_Premiosdescripcion() ;
      A57PremiosId = obj14.getgxTv_SdtProfesional_Premios_Premiosid() ;
      Z57PremiosId = obj14.getgxTv_SdtProfesional_Premios_Premiosid_Z() ;
      Z207PremiosNombre = obj14.getgxTv_SdtProfesional_Premios_Premiosnombre_Z() ;
      Z208PremiosFecha = obj14.getgxTv_SdtProfesional_Premios_Premiosfecha_Z() ;
      nIsMod_14 = obj14.getgxTv_SdtProfesional_Premios_Modified() ;
   }

   public void VarsToRow15( com.projectthani.SdtProfesional_Servicios obj15 )
   {
      obj15.setgxTv_SdtProfesional_Servicios_Mode( Gx_mode );
      obj15.setgxTv_SdtProfesional_Servicios_Serviciosnombre( A210ServiciosNombre );
      obj15.setgxTv_SdtProfesional_Servicios_Serviciosid( A58ServiciosId );
      obj15.setgxTv_SdtProfesional_Servicios_Serviciosid_Z( Z58ServiciosId );
      obj15.setgxTv_SdtProfesional_Servicios_Serviciosnombre_Z( Z210ServiciosNombre );
      obj15.setgxTv_SdtProfesional_Servicios_Modified( nIsMod_15 );
   }

   public void KeyVarsToRow15( com.projectthani.SdtProfesional_Servicios obj15 )
   {
      obj15.setgxTv_SdtProfesional_Servicios_Serviciosid( A58ServiciosId );
   }

   public void RowToVars15( com.projectthani.SdtProfesional_Servicios obj15 ,
                            int forceLoad )
   {
      Gx_mode = obj15.getgxTv_SdtProfesional_Servicios_Mode() ;
      A210ServiciosNombre = obj15.getgxTv_SdtProfesional_Servicios_Serviciosnombre() ;
      A58ServiciosId = obj15.getgxTv_SdtProfesional_Servicios_Serviciosid() ;
      Z58ServiciosId = obj15.getgxTv_SdtProfesional_Servicios_Serviciosid_Z() ;
      Z210ServiciosNombre = obj15.getgxTv_SdtProfesional_Servicios_Serviciosnombre_Z() ;
      nIsMod_15 = obj15.getgxTv_SdtProfesional_Servicios_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A31ProfesionalId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey089( ) ;
      scanKeyStart089( ) ;
      if ( RcdFound9 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z31ProfesionalId = A31ProfesionalId ;
      }
      zm089( -31) ;
      onLoadActions089( ) ;
      addRow089( ) ;
      bcProfesional.getgxTv_SdtProfesional_Especialidad().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0810( ) ;
         nGXsfl_10_idx = 1 ;
         while ( RcdFound10 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z32EspecialidadId = A32EspecialidadId ;
            zm0810( -35) ;
            onLoadActions0810( ) ;
            nRcdExists_10 = (short)(1) ;
            nIsMod_10 = (short)(0) ;
            addRow0810( ) ;
            ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().clearCollection();
            if ( RcdFound10 == 1 )
            {
               scanKeyStart0811( ) ;
               nGXsfl_11_idx = 1 ;
               while ( RcdFound11 != 0 )
               {
                  Z31ProfesionalId = A31ProfesionalId ;
                  Z32EspecialidadId = A32EspecialidadId ;
                  Z30SedeId = A30SedeId ;
                  Z54SedeTipoConsulta = A54SedeTipoConsulta ;
                  zm0811( -37) ;
                  onLoadActions0811( ) ;
                  nRcdExists_11 = (short)(1) ;
                  nIsMod_11 = (short)(0) ;
                  addRow0811( ) ;
                  nGXsfl_11_idx = (int)(nGXsfl_11_idx+1) ;
                  scanKeyNext0811( ) ;
               }
               scanKeyEnd0811( ) ;
            }
            nGXsfl_10_idx = (int)(nGXsfl_10_idx+1) ;
            scanKeyNext0810( ) ;
         }
         scanKeyEnd0810( ) ;
      }
      bcProfesional.getgxTv_SdtProfesional_Educacion().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0812( ) ;
         nGXsfl_12_idx = 1 ;
         while ( RcdFound12 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z55EducacionId = A55EducacionId ;
            zm0812( -40) ;
            onLoadActions0812( ) ;
            nRcdExists_12 = (short)(1) ;
            nIsMod_12 = (short)(0) ;
            addRow0812( ) ;
            nGXsfl_12_idx = (int)(nGXsfl_12_idx+1) ;
            scanKeyNext0812( ) ;
         }
         scanKeyEnd0812( ) ;
      }
      bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0813( ) ;
         nGXsfl_13_idx = 1 ;
         while ( RcdFound13 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z56ExperienciaLaboralId = A56ExperienciaLaboralId ;
            zm0813( -41) ;
            onLoadActions0813( ) ;
            nRcdExists_13 = (short)(1) ;
            nIsMod_13 = (short)(0) ;
            addRow0813( ) ;
            nGXsfl_13_idx = (int)(nGXsfl_13_idx+1) ;
            scanKeyNext0813( ) ;
         }
         scanKeyEnd0813( ) ;
      }
      bcProfesional.getgxTv_SdtProfesional_Premios().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0814( ) ;
         nGXsfl_14_idx = 1 ;
         while ( RcdFound14 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z57PremiosId = A57PremiosId ;
            zm0814( -42) ;
            onLoadActions0814( ) ;
            nRcdExists_14 = (short)(1) ;
            nIsMod_14 = (short)(0) ;
            addRow0814( ) ;
            nGXsfl_14_idx = (int)(nGXsfl_14_idx+1) ;
            scanKeyNext0814( ) ;
         }
         scanKeyEnd0814( ) ;
      }
      bcProfesional.getgxTv_SdtProfesional_Servicios().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0815( ) ;
         nGXsfl_15_idx = 1 ;
         while ( RcdFound15 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z58ServiciosId = A58ServiciosId ;
            zm0815( -43) ;
            onLoadActions0815( ) ;
            nRcdExists_15 = (short)(1) ;
            nIsMod_15 = (short)(0) ;
            addRow0815( ) ;
            nGXsfl_15_idx = (int)(nGXsfl_15_idx+1) ;
            scanKeyNext0815( ) ;
         }
         scanKeyEnd0815( ) ;
      }
      scanKeyEnd089( ) ;
      if ( RcdFound9 == 0 )
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
      RowToVars9( bcProfesional, 0) ;
      scanKeyStart089( ) ;
      if ( RcdFound9 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z31ProfesionalId = A31ProfesionalId ;
      }
      zm089( -31) ;
      onLoadActions089( ) ;
      addRow089( ) ;
      bcProfesional.getgxTv_SdtProfesional_Especialidad().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0810( ) ;
         nGXsfl_10_idx = 1 ;
         while ( RcdFound10 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z32EspecialidadId = A32EspecialidadId ;
            zm0810( -35) ;
            onLoadActions0810( ) ;
            nRcdExists_10 = (short)(1) ;
            nIsMod_10 = (short)(0) ;
            addRow0810( ) ;
            ((com.projectthani.SdtProfesional_Especialidad)bcProfesional.getgxTv_SdtProfesional_Especialidad().elementAt(-1+nGXsfl_10_idx)).getgxTv_SdtProfesional_Especialidad_Sede().clearCollection();
            if ( RcdFound10 == 1 )
            {
               scanKeyStart0811( ) ;
               nGXsfl_11_idx = 1 ;
               while ( RcdFound11 != 0 )
               {
                  Z31ProfesionalId = A31ProfesionalId ;
                  Z32EspecialidadId = A32EspecialidadId ;
                  Z30SedeId = A30SedeId ;
                  Z54SedeTipoConsulta = A54SedeTipoConsulta ;
                  zm0811( -37) ;
                  onLoadActions0811( ) ;
                  nRcdExists_11 = (short)(1) ;
                  nIsMod_11 = (short)(0) ;
                  addRow0811( ) ;
                  nGXsfl_11_idx = (int)(nGXsfl_11_idx+1) ;
                  scanKeyNext0811( ) ;
               }
               scanKeyEnd0811( ) ;
            }
            nGXsfl_10_idx = (int)(nGXsfl_10_idx+1) ;
            scanKeyNext0810( ) ;
         }
         scanKeyEnd0810( ) ;
      }
      bcProfesional.getgxTv_SdtProfesional_Educacion().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0812( ) ;
         nGXsfl_12_idx = 1 ;
         while ( RcdFound12 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z55EducacionId = A55EducacionId ;
            zm0812( -40) ;
            onLoadActions0812( ) ;
            nRcdExists_12 = (short)(1) ;
            nIsMod_12 = (short)(0) ;
            addRow0812( ) ;
            nGXsfl_12_idx = (int)(nGXsfl_12_idx+1) ;
            scanKeyNext0812( ) ;
         }
         scanKeyEnd0812( ) ;
      }
      bcProfesional.getgxTv_SdtProfesional_Experiencialaboral().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0813( ) ;
         nGXsfl_13_idx = 1 ;
         while ( RcdFound13 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z56ExperienciaLaboralId = A56ExperienciaLaboralId ;
            zm0813( -41) ;
            onLoadActions0813( ) ;
            nRcdExists_13 = (short)(1) ;
            nIsMod_13 = (short)(0) ;
            addRow0813( ) ;
            nGXsfl_13_idx = (int)(nGXsfl_13_idx+1) ;
            scanKeyNext0813( ) ;
         }
         scanKeyEnd0813( ) ;
      }
      bcProfesional.getgxTv_SdtProfesional_Premios().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0814( ) ;
         nGXsfl_14_idx = 1 ;
         while ( RcdFound14 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z57PremiosId = A57PremiosId ;
            zm0814( -42) ;
            onLoadActions0814( ) ;
            nRcdExists_14 = (short)(1) ;
            nIsMod_14 = (short)(0) ;
            addRow0814( ) ;
            nGXsfl_14_idx = (int)(nGXsfl_14_idx+1) ;
            scanKeyNext0814( ) ;
         }
         scanKeyEnd0814( ) ;
      }
      bcProfesional.getgxTv_SdtProfesional_Servicios().clearCollection();
      if ( RcdFound9 == 1 )
      {
         scanKeyStart0815( ) ;
         nGXsfl_15_idx = 1 ;
         while ( RcdFound15 != 0 )
         {
            Z31ProfesionalId = A31ProfesionalId ;
            Z58ServiciosId = A58ServiciosId ;
            zm0815( -43) ;
            onLoadActions0815( ) ;
            nRcdExists_15 = (short)(1) ;
            nIsMod_15 = (short)(0) ;
            addRow0815( ) ;
            nGXsfl_15_idx = (int)(nGXsfl_15_idx+1) ;
            scanKeyNext0815( ) ;
         }
         scanKeyEnd0815( ) ;
      }
      scanKeyEnd089( ) ;
      if ( RcdFound9 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey089( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert089( ) ;
      }
      else
      {
         if ( RcdFound9 == 1 )
         {
            if ( A31ProfesionalId != Z31ProfesionalId )
            {
               A31ProfesionalId = Z31ProfesionalId ;
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
               update089( ) ;
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
               if ( A31ProfesionalId != Z31ProfesionalId )
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
                     insert089( ) ;
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
                     insert089( ) ;
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
      RowToVars9( bcProfesional, 1) ;
      saveImpl( ) ;
      VarsToRow9( bcProfesional) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars9( bcProfesional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert089( ) ;
      afterTrn( ) ;
      VarsToRow9( bcProfesional) ;
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
         com.projectthani.SdtProfesional auxBC = new com.projectthani.SdtProfesional( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A31ProfesionalId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcProfesional);
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
      RowToVars9( bcProfesional, 1) ;
      updateImpl( ) ;
      VarsToRow9( bcProfesional) ;
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
      RowToVars9( bcProfesional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert089( ) ;
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
      VarsToRow9( bcProfesional) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars9( bcProfesional, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey089( ) ;
      if ( RcdFound9 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A31ProfesionalId != Z31ProfesionalId )
         {
            A31ProfesionalId = Z31ProfesionalId ;
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
         if ( A31ProfesionalId != Z31ProfesionalId )
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
      pr_default.close(16);
      pr_default.close(15);
      pr_default.close(13);
      pr_default.close(12);
      pr_default.close(9);
      pr_default.close(8);
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      pr_default.close(0);
      pr_default.close(31);
      pr_default.close(17);
      pr_default.close(32);
      pr_default.close(18);
      pr_default.close(19);
      pr_default.close(45);
      pr_default.close(14);
      pr_default.close(58);
      pr_default.close(10);
      pr_default.close(59);
      pr_default.close(11);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "profesional_bc");
      VarsToRow9( bcProfesional) ;
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
      Gx_mode = bcProfesional.getgxTv_SdtProfesional_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcProfesional.setgxTv_SdtProfesional_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtProfesional sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcProfesional )
      {
         bcProfesional = sdt ;
         if ( GXutil.strcmp(bcProfesional.getgxTv_SdtProfesional_Mode(), "") == 0 )
         {
            bcProfesional.setgxTv_SdtProfesional_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow9( bcProfesional) ;
         }
         else
         {
            RowToVars9( bcProfesional, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcProfesional.getgxTv_SdtProfesional_Mode(), "") == 0 )
         {
            bcProfesional.setgxTv_SdtProfesional_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars9( bcProfesional, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtProfesional getProfesional_BC( )
   {
      return bcProfesional ;
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
      sMode9 = "" ;
      sMode10 = "" ;
      Z173ProfesionalTipoDocumento = "" ;
      A173ProfesionalTipoDocumento = "" ;
      Z174ProfesionalNroDocumento = "" ;
      A174ProfesionalNroDocumento = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      Z84ProfesionalNombres = "" ;
      A84ProfesionalNombres = "" ;
      Z176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      Z177ProfesionalSexo = "" ;
      A177ProfesionalSexo = "" ;
      Z178ProfesionalDescripcion = "" ;
      A178ProfesionalDescripcion = "" ;
      Z179ProfesionalCorreo = "" ;
      A179ProfesionalCorreo = "" ;
      Z88ProfesionalCOP = "" ;
      A88ProfesionalCOP = "" ;
      Z180ProfesionalColorDisponible = "" ;
      A180ProfesionalColorDisponible = "" ;
      Z181ProfesionalColorCita = "" ;
      A181ProfesionalColorCita = "" ;
      Z183ProfesionalDireccion = "" ;
      A183ProfesionalDireccion = "" ;
      Z190ProfesionalTwitter = "" ;
      A190ProfesionalTwitter = "" ;
      Z191ProfesionalFacebook = "" ;
      A191ProfesionalFacebook = "" ;
      Z192ProfesionalInstagram = "" ;
      A192ProfesionalInstagram = "" ;
      Z193ProfesionalLinkedin = "" ;
      A193ProfesionalLinkedin = "" ;
      Z194ProfesionalTelefono = "" ;
      A194ProfesionalTelefono = "" ;
      Z195ProfesionalFechaRegistro = GXutil.nullDate() ;
      A195ProfesionalFechaRegistro = GXutil.nullDate() ;
      Z197ProfesionalEstadoCuenta = "" ;
      A197ProfesionalEstadoCuenta = "" ;
      Z198ProfesionalEstado = "" ;
      A198ProfesionalEstado = "" ;
      Z44UbigeoCode = "" ;
      A44UbigeoCode = "" ;
      Z175ProfesionalNombreCompleto2 = "" ;
      A175ProfesionalNombreCompleto2 = "" ;
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
      Z189ProfesionalFoto = "" ;
      A189ProfesionalFoto = "" ;
      Z40000ProfesionalFoto_GXI = "" ;
      A40000ProfesionalFoto_GXI = "" ;
      BC000822_A31ProfesionalId = new int[1] ;
      BC000822_A173ProfesionalTipoDocumento = new String[] {""} ;
      BC000822_A174ProfesionalNroDocumento = new String[] {""} ;
      BC000822_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000822_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000822_A84ProfesionalNombres = new String[] {""} ;
      BC000822_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      BC000822_A177ProfesionalSexo = new String[] {""} ;
      BC000822_A178ProfesionalDescripcion = new String[] {""} ;
      BC000822_A179ProfesionalCorreo = new String[] {""} ;
      BC000822_A88ProfesionalCOP = new String[] {""} ;
      BC000822_A180ProfesionalColorDisponible = new String[] {""} ;
      BC000822_A181ProfesionalColorCita = new String[] {""} ;
      BC000822_A182ProfesionalTiempoCita = new byte[1] ;
      BC000822_A183ProfesionalDireccion = new String[] {""} ;
      BC000822_A184PaisDescripcion = new String[] {""} ;
      BC000822_A189ProfesionalFoto = new String[] {""} ;
      BC000822_A40000ProfesionalFoto_GXI = new String[] {""} ;
      BC000822_A190ProfesionalTwitter = new String[] {""} ;
      BC000822_A191ProfesionalFacebook = new String[] {""} ;
      BC000822_A192ProfesionalInstagram = new String[] {""} ;
      BC000822_A193ProfesionalLinkedin = new String[] {""} ;
      BC000822_A194ProfesionalTelefono = new String[] {""} ;
      BC000822_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC000822_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      BC000822_A197ProfesionalEstadoCuenta = new String[] {""} ;
      BC000822_A198ProfesionalEstado = new String[] {""} ;
      BC000822_A186UbigeoDepartamento = new String[] {""} ;
      BC000822_A187UbigeoProvincia = new String[] {""} ;
      BC000822_A188UbigeoDistrito = new String[] {""} ;
      BC000822_A43PaisId = new short[1] ;
      BC000822_A44UbigeoCode = new String[] {""} ;
      BC000822_A6SecUserId = new short[1] ;
      BC000823_A184PaisDescripcion = new String[] {""} ;
      BC000824_A186UbigeoDepartamento = new String[] {""} ;
      BC000824_A187UbigeoProvincia = new String[] {""} ;
      BC000824_A188UbigeoDistrito = new String[] {""} ;
      BC000825_A6SecUserId = new short[1] ;
      BC000826_A31ProfesionalId = new int[1] ;
      BC000827_A31ProfesionalId = new int[1] ;
      BC000827_A173ProfesionalTipoDocumento = new String[] {""} ;
      BC000827_A174ProfesionalNroDocumento = new String[] {""} ;
      BC000827_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000827_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000827_A84ProfesionalNombres = new String[] {""} ;
      BC000827_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      BC000827_A177ProfesionalSexo = new String[] {""} ;
      BC000827_A178ProfesionalDescripcion = new String[] {""} ;
      BC000827_A179ProfesionalCorreo = new String[] {""} ;
      BC000827_A88ProfesionalCOP = new String[] {""} ;
      BC000827_A180ProfesionalColorDisponible = new String[] {""} ;
      BC000827_A181ProfesionalColorCita = new String[] {""} ;
      BC000827_A182ProfesionalTiempoCita = new byte[1] ;
      BC000827_A183ProfesionalDireccion = new String[] {""} ;
      BC000827_A189ProfesionalFoto = new String[] {""} ;
      BC000827_A40000ProfesionalFoto_GXI = new String[] {""} ;
      BC000827_A190ProfesionalTwitter = new String[] {""} ;
      BC000827_A191ProfesionalFacebook = new String[] {""} ;
      BC000827_A192ProfesionalInstagram = new String[] {""} ;
      BC000827_A193ProfesionalLinkedin = new String[] {""} ;
      BC000827_A194ProfesionalTelefono = new String[] {""} ;
      BC000827_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC000827_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      BC000827_A197ProfesionalEstadoCuenta = new String[] {""} ;
      BC000827_A198ProfesionalEstado = new String[] {""} ;
      BC000827_A43PaisId = new short[1] ;
      BC000827_A44UbigeoCode = new String[] {""} ;
      BC000827_A6SecUserId = new short[1] ;
      BC000828_A31ProfesionalId = new int[1] ;
      BC000828_A173ProfesionalTipoDocumento = new String[] {""} ;
      BC000828_A174ProfesionalNroDocumento = new String[] {""} ;
      BC000828_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000828_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000828_A84ProfesionalNombres = new String[] {""} ;
      BC000828_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      BC000828_A177ProfesionalSexo = new String[] {""} ;
      BC000828_A178ProfesionalDescripcion = new String[] {""} ;
      BC000828_A179ProfesionalCorreo = new String[] {""} ;
      BC000828_A88ProfesionalCOP = new String[] {""} ;
      BC000828_A180ProfesionalColorDisponible = new String[] {""} ;
      BC000828_A181ProfesionalColorCita = new String[] {""} ;
      BC000828_A182ProfesionalTiempoCita = new byte[1] ;
      BC000828_A183ProfesionalDireccion = new String[] {""} ;
      BC000828_A189ProfesionalFoto = new String[] {""} ;
      BC000828_A40000ProfesionalFoto_GXI = new String[] {""} ;
      BC000828_A190ProfesionalTwitter = new String[] {""} ;
      BC000828_A191ProfesionalFacebook = new String[] {""} ;
      BC000828_A192ProfesionalInstagram = new String[] {""} ;
      BC000828_A193ProfesionalLinkedin = new String[] {""} ;
      BC000828_A194ProfesionalTelefono = new String[] {""} ;
      BC000828_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC000828_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      BC000828_A197ProfesionalEstadoCuenta = new String[] {""} ;
      BC000828_A198ProfesionalEstado = new String[] {""} ;
      BC000828_A43PaisId = new short[1] ;
      BC000828_A44UbigeoCode = new String[] {""} ;
      BC000828_A6SecUserId = new short[1] ;
      BC000829_A31ProfesionalId = new int[1] ;
      BC000833_A184PaisDescripcion = new String[] {""} ;
      BC000834_A186UbigeoDepartamento = new String[] {""} ;
      BC000834_A187UbigeoProvincia = new String[] {""} ;
      BC000834_A188UbigeoDistrito = new String[] {""} ;
      BC000835_A63ComentarioProfesionalId = new int[1] ;
      BC000836_A60RatingProfesionalId = new int[1] ;
      BC000837_A59EducacionProfesionalId = new int[1] ;
      BC000838_A31ProfesionalId = new int[1] ;
      BC000838_A32EspecialidadId = new short[1] ;
      BC000839_A31ProfesionalId = new int[1] ;
      BC000839_A173ProfesionalTipoDocumento = new String[] {""} ;
      BC000839_A174ProfesionalNroDocumento = new String[] {""} ;
      BC000839_A85ProfesionalApellidoPaterno = new String[] {""} ;
      BC000839_A86ProfesionalApellidoMaterno = new String[] {""} ;
      BC000839_A84ProfesionalNombres = new String[] {""} ;
      BC000839_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      BC000839_A177ProfesionalSexo = new String[] {""} ;
      BC000839_A178ProfesionalDescripcion = new String[] {""} ;
      BC000839_A179ProfesionalCorreo = new String[] {""} ;
      BC000839_A88ProfesionalCOP = new String[] {""} ;
      BC000839_A180ProfesionalColorDisponible = new String[] {""} ;
      BC000839_A181ProfesionalColorCita = new String[] {""} ;
      BC000839_A182ProfesionalTiempoCita = new byte[1] ;
      BC000839_A183ProfesionalDireccion = new String[] {""} ;
      BC000839_A184PaisDescripcion = new String[] {""} ;
      BC000839_A189ProfesionalFoto = new String[] {""} ;
      BC000839_A40000ProfesionalFoto_GXI = new String[] {""} ;
      BC000839_A190ProfesionalTwitter = new String[] {""} ;
      BC000839_A191ProfesionalFacebook = new String[] {""} ;
      BC000839_A192ProfesionalInstagram = new String[] {""} ;
      BC000839_A193ProfesionalLinkedin = new String[] {""} ;
      BC000839_A194ProfesionalTelefono = new String[] {""} ;
      BC000839_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC000839_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      BC000839_A197ProfesionalEstadoCuenta = new String[] {""} ;
      BC000839_A198ProfesionalEstado = new String[] {""} ;
      BC000839_A186UbigeoDepartamento = new String[] {""} ;
      BC000839_A187UbigeoProvincia = new String[] {""} ;
      BC000839_A188UbigeoDistrito = new String[] {""} ;
      BC000839_A43PaisId = new short[1] ;
      BC000839_A44UbigeoCode = new String[] {""} ;
      BC000839_A6SecUserId = new short[1] ;
      Z140EspecialidadCodigo = "" ;
      A140EspecialidadCodigo = "" ;
      Z71EspecialidadNombre = "" ;
      A71EspecialidadNombre = "" ;
      BC000840_A31ProfesionalId = new int[1] ;
      BC000840_A140EspecialidadCodigo = new String[] {""} ;
      BC000840_A71EspecialidadNombre = new String[] {""} ;
      BC000840_A32EspecialidadId = new short[1] ;
      BC000841_A140EspecialidadCodigo = new String[] {""} ;
      BC000841_A71EspecialidadNombre = new String[] {""} ;
      BC000842_A31ProfesionalId = new int[1] ;
      BC000842_A32EspecialidadId = new short[1] ;
      BC000843_A31ProfesionalId = new int[1] ;
      BC000843_A32EspecialidadId = new short[1] ;
      BC000844_A31ProfesionalId = new int[1] ;
      BC000844_A32EspecialidadId = new short[1] ;
      BC000847_A140EspecialidadCodigo = new String[] {""} ;
      BC000847_A71EspecialidadNombre = new String[] {""} ;
      BC000848_A34DisponibilidadId = new int[1] ;
      BC000849_A29ConfComisionId = new short[1] ;
      BC000850_A31ProfesionalId = new int[1] ;
      BC000850_A140EspecialidadCodigo = new String[] {""} ;
      BC000850_A71EspecialidadNombre = new String[] {""} ;
      BC000850_A32EspecialidadId = new short[1] ;
      Z199CostoConsulta = DecimalUtil.ZERO ;
      A199CostoConsulta = DecimalUtil.ZERO ;
      Z75SedeNombre = "" ;
      A75SedeNombre = "" ;
      Z80ClinicaNombreAbreviado = "" ;
      A80ClinicaNombreAbreviado = "" ;
      Z54SedeTipoConsulta = "" ;
      A54SedeTipoConsulta = "" ;
      BC000851_A28ClinicaId = new short[1] ;
      BC000851_A31ProfesionalId = new int[1] ;
      BC000851_A32EspecialidadId = new short[1] ;
      BC000851_A54SedeTipoConsulta = new String[] {""} ;
      BC000851_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000851_A75SedeNombre = new String[] {""} ;
      BC000851_A80ClinicaNombreAbreviado = new String[] {""} ;
      BC000851_A30SedeId = new short[1] ;
      BC000852_A28ClinicaId = new short[1] ;
      BC000852_A75SedeNombre = new String[] {""} ;
      BC000853_A80ClinicaNombreAbreviado = new String[] {""} ;
      BC000854_A31ProfesionalId = new int[1] ;
      BC000854_A32EspecialidadId = new short[1] ;
      BC000854_A30SedeId = new short[1] ;
      BC000854_A54SedeTipoConsulta = new String[] {""} ;
      BC000855_A31ProfesionalId = new int[1] ;
      BC000855_A32EspecialidadId = new short[1] ;
      BC000855_A54SedeTipoConsulta = new String[] {""} ;
      BC000855_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000855_A30SedeId = new short[1] ;
      sMode11 = "" ;
      BC000856_A31ProfesionalId = new int[1] ;
      BC000856_A32EspecialidadId = new short[1] ;
      BC000856_A54SedeTipoConsulta = new String[] {""} ;
      BC000856_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000856_A30SedeId = new short[1] ;
      BC000860_A28ClinicaId = new short[1] ;
      BC000860_A75SedeNombre = new String[] {""} ;
      BC000861_A80ClinicaNombreAbreviado = new String[] {""} ;
      BC000862_A28ClinicaId = new short[1] ;
      BC000862_A31ProfesionalId = new int[1] ;
      BC000862_A32EspecialidadId = new short[1] ;
      BC000862_A54SedeTipoConsulta = new String[] {""} ;
      BC000862_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000862_A75SedeNombre = new String[] {""} ;
      BC000862_A80ClinicaNombreAbreviado = new String[] {""} ;
      BC000862_A30SedeId = new short[1] ;
      Z200EducacionNombreInstitucion = "" ;
      A200EducacionNombreInstitucion = "" ;
      Z201EducacionDesde = GXutil.nullDate() ;
      A201EducacionDesde = GXutil.nullDate() ;
      Z202EducacionHasta = GXutil.nullDate() ;
      A202EducacionHasta = GXutil.nullDate() ;
      Z203EducacionPaisDescripcion = "" ;
      A203EducacionPaisDescripcion = "" ;
      Z55EducacionId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A55EducacionId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      BC000863_A31ProfesionalId = new int[1] ;
      BC000863_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000863_A200EducacionNombreInstitucion = new String[] {""} ;
      BC000863_A201EducacionDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000863_A202EducacionHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000863_A203EducacionPaisDescripcion = new String[] {""} ;
      BC000864_A31ProfesionalId = new int[1] ;
      BC000864_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000865_A31ProfesionalId = new int[1] ;
      BC000865_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000865_A200EducacionNombreInstitucion = new String[] {""} ;
      BC000865_A201EducacionDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000865_A202EducacionHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000865_A203EducacionPaisDescripcion = new String[] {""} ;
      sMode12 = "" ;
      BC000866_A31ProfesionalId = new int[1] ;
      BC000866_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000866_A200EducacionNombreInstitucion = new String[] {""} ;
      BC000866_A201EducacionDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000866_A202EducacionHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000866_A203EducacionPaisDescripcion = new String[] {""} ;
      BC000870_A31ProfesionalId = new int[1] ;
      BC000870_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000870_A200EducacionNombreInstitucion = new String[] {""} ;
      BC000870_A201EducacionDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000870_A202EducacionHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000870_A203EducacionPaisDescripcion = new String[] {""} ;
      Z204ExperienciaLaboralEmpresaNombre = "" ;
      A204ExperienciaLaboralEmpresaNombre = "" ;
      Z205ExperienciaLaboralDesde = GXutil.nullDate() ;
      A205ExperienciaLaboralDesde = GXutil.nullDate() ;
      Z206ExperienciaLaboralHasta = GXutil.nullDate() ;
      A206ExperienciaLaboralHasta = GXutil.nullDate() ;
      Z56ExperienciaLaboralId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A56ExperienciaLaboralId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      BC000871_A31ProfesionalId = new int[1] ;
      BC000871_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000871_A204ExperienciaLaboralEmpresaNombre = new String[] {""} ;
      BC000871_A205ExperienciaLaboralDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000871_A206ExperienciaLaboralHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000872_A31ProfesionalId = new int[1] ;
      BC000872_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000873_A31ProfesionalId = new int[1] ;
      BC000873_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000873_A204ExperienciaLaboralEmpresaNombre = new String[] {""} ;
      BC000873_A205ExperienciaLaboralDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000873_A206ExperienciaLaboralHasta = new java.util.Date[] {GXutil.nullDate()} ;
      sMode13 = "" ;
      BC000874_A31ProfesionalId = new int[1] ;
      BC000874_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000874_A204ExperienciaLaboralEmpresaNombre = new String[] {""} ;
      BC000874_A205ExperienciaLaboralDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000874_A206ExperienciaLaboralHasta = new java.util.Date[] {GXutil.nullDate()} ;
      BC000878_A31ProfesionalId = new int[1] ;
      BC000878_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000878_A204ExperienciaLaboralEmpresaNombre = new String[] {""} ;
      BC000878_A205ExperienciaLaboralDesde = new java.util.Date[] {GXutil.nullDate()} ;
      BC000878_A206ExperienciaLaboralHasta = new java.util.Date[] {GXutil.nullDate()} ;
      Z207PremiosNombre = "" ;
      A207PremiosNombre = "" ;
      Z208PremiosFecha = GXutil.nullDate() ;
      A208PremiosFecha = GXutil.nullDate() ;
      Z57PremiosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A57PremiosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      Z209PremiosDescripcion = "" ;
      A209PremiosDescripcion = "" ;
      BC000879_A31ProfesionalId = new int[1] ;
      BC000879_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000879_A207PremiosNombre = new String[] {""} ;
      BC000879_A208PremiosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000879_A209PremiosDescripcion = new String[] {""} ;
      BC000880_A31ProfesionalId = new int[1] ;
      BC000880_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000881_A31ProfesionalId = new int[1] ;
      BC000881_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000881_A207PremiosNombre = new String[] {""} ;
      BC000881_A208PremiosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000881_A209PremiosDescripcion = new String[] {""} ;
      sMode14 = "" ;
      BC000882_A31ProfesionalId = new int[1] ;
      BC000882_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000882_A207PremiosNombre = new String[] {""} ;
      BC000882_A208PremiosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000882_A209PremiosDescripcion = new String[] {""} ;
      BC000886_A31ProfesionalId = new int[1] ;
      BC000886_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000886_A207PremiosNombre = new String[] {""} ;
      BC000886_A208PremiosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000886_A209PremiosDescripcion = new String[] {""} ;
      Z210ServiciosNombre = "" ;
      A210ServiciosNombre = "" ;
      Z58ServiciosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A58ServiciosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      BC000887_A31ProfesionalId = new int[1] ;
      BC000887_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000887_A210ServiciosNombre = new String[] {""} ;
      BC000888_A31ProfesionalId = new int[1] ;
      BC000888_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000889_A31ProfesionalId = new int[1] ;
      BC000889_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000889_A210ServiciosNombre = new String[] {""} ;
      sMode15 = "" ;
      BC000890_A31ProfesionalId = new int[1] ;
      BC000890_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000890_A210ServiciosNombre = new String[] {""} ;
      BC000894_A31ProfesionalId = new int[1] ;
      BC000894_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC000894_A210ServiciosNombre = new String[] {""} ;
      i199CostoConsulta = DecimalUtil.ZERO ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.profesional_bc__default(),
         new Object[] {
             new Object[] {
            BC00082_A31ProfesionalId, BC00082_A58ServiciosId, BC00082_A210ServiciosNombre
            }
            , new Object[] {
            BC00083_A31ProfesionalId, BC00083_A58ServiciosId, BC00083_A210ServiciosNombre
            }
            , new Object[] {
            BC00084_A31ProfesionalId, BC00084_A57PremiosId, BC00084_A207PremiosNombre, BC00084_A208PremiosFecha, BC00084_A209PremiosDescripcion
            }
            , new Object[] {
            BC00085_A31ProfesionalId, BC00085_A57PremiosId, BC00085_A207PremiosNombre, BC00085_A208PremiosFecha, BC00085_A209PremiosDescripcion
            }
            , new Object[] {
            BC00086_A31ProfesionalId, BC00086_A56ExperienciaLaboralId, BC00086_A204ExperienciaLaboralEmpresaNombre, BC00086_A205ExperienciaLaboralDesde, BC00086_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            BC00087_A31ProfesionalId, BC00087_A56ExperienciaLaboralId, BC00087_A204ExperienciaLaboralEmpresaNombre, BC00087_A205ExperienciaLaboralDesde, BC00087_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            BC00088_A31ProfesionalId, BC00088_A55EducacionId, BC00088_A200EducacionNombreInstitucion, BC00088_A201EducacionDesde, BC00088_A202EducacionHasta, BC00088_A203EducacionPaisDescripcion
            }
            , new Object[] {
            BC00089_A31ProfesionalId, BC00089_A55EducacionId, BC00089_A200EducacionNombreInstitucion, BC00089_A201EducacionDesde, BC00089_A202EducacionHasta, BC00089_A203EducacionPaisDescripcion
            }
            , new Object[] {
            BC000810_A31ProfesionalId, BC000810_A32EspecialidadId, BC000810_A54SedeTipoConsulta, BC000810_A199CostoConsulta, BC000810_A30SedeId
            }
            , new Object[] {
            BC000811_A31ProfesionalId, BC000811_A32EspecialidadId, BC000811_A54SedeTipoConsulta, BC000811_A199CostoConsulta, BC000811_A30SedeId
            }
            , new Object[] {
            BC000812_A28ClinicaId, BC000812_A75SedeNombre
            }
            , new Object[] {
            BC000813_A80ClinicaNombreAbreviado
            }
            , new Object[] {
            BC000814_A31ProfesionalId, BC000814_A32EspecialidadId
            }
            , new Object[] {
            BC000815_A31ProfesionalId, BC000815_A32EspecialidadId
            }
            , new Object[] {
            BC000816_A140EspecialidadCodigo, BC000816_A71EspecialidadNombre
            }
            , new Object[] {
            BC000817_A31ProfesionalId, BC000817_A173ProfesionalTipoDocumento, BC000817_A174ProfesionalNroDocumento, BC000817_A85ProfesionalApellidoPaterno, BC000817_A86ProfesionalApellidoMaterno, BC000817_A84ProfesionalNombres, BC000817_A176ProfesionalFechaNacimiento, BC000817_A177ProfesionalSexo, BC000817_A178ProfesionalDescripcion, BC000817_A179ProfesionalCorreo,
            BC000817_A88ProfesionalCOP, BC000817_A180ProfesionalColorDisponible, BC000817_A181ProfesionalColorCita, BC000817_A182ProfesionalTiempoCita, BC000817_A183ProfesionalDireccion, BC000817_A189ProfesionalFoto, BC000817_A40000ProfesionalFoto_GXI, BC000817_A190ProfesionalTwitter, BC000817_A191ProfesionalFacebook, BC000817_A192ProfesionalInstagram,
            BC000817_A193ProfesionalLinkedin, BC000817_A194ProfesionalTelefono, BC000817_A195ProfesionalFechaRegistro, BC000817_A196ProfesionalTerminosCondiciones, BC000817_A197ProfesionalEstadoCuenta, BC000817_A198ProfesionalEstado, BC000817_A43PaisId, BC000817_A44UbigeoCode, BC000817_A6SecUserId
            }
            , new Object[] {
            BC000818_A31ProfesionalId, BC000818_A173ProfesionalTipoDocumento, BC000818_A174ProfesionalNroDocumento, BC000818_A85ProfesionalApellidoPaterno, BC000818_A86ProfesionalApellidoMaterno, BC000818_A84ProfesionalNombres, BC000818_A176ProfesionalFechaNacimiento, BC000818_A177ProfesionalSexo, BC000818_A178ProfesionalDescripcion, BC000818_A179ProfesionalCorreo,
            BC000818_A88ProfesionalCOP, BC000818_A180ProfesionalColorDisponible, BC000818_A181ProfesionalColorCita, BC000818_A182ProfesionalTiempoCita, BC000818_A183ProfesionalDireccion, BC000818_A189ProfesionalFoto, BC000818_A40000ProfesionalFoto_GXI, BC000818_A190ProfesionalTwitter, BC000818_A191ProfesionalFacebook, BC000818_A192ProfesionalInstagram,
            BC000818_A193ProfesionalLinkedin, BC000818_A194ProfesionalTelefono, BC000818_A195ProfesionalFechaRegistro, BC000818_A196ProfesionalTerminosCondiciones, BC000818_A197ProfesionalEstadoCuenta, BC000818_A198ProfesionalEstado, BC000818_A43PaisId, BC000818_A44UbigeoCode, BC000818_A6SecUserId
            }
            , new Object[] {
            BC000819_A184PaisDescripcion
            }
            , new Object[] {
            BC000820_A186UbigeoDepartamento, BC000820_A187UbigeoProvincia, BC000820_A188UbigeoDistrito
            }
            , new Object[] {
            BC000821_A6SecUserId
            }
            , new Object[] {
            BC000822_A31ProfesionalId, BC000822_A173ProfesionalTipoDocumento, BC000822_A174ProfesionalNroDocumento, BC000822_A85ProfesionalApellidoPaterno, BC000822_A86ProfesionalApellidoMaterno, BC000822_A84ProfesionalNombres, BC000822_A176ProfesionalFechaNacimiento, BC000822_A177ProfesionalSexo, BC000822_A178ProfesionalDescripcion, BC000822_A179ProfesionalCorreo,
            BC000822_A88ProfesionalCOP, BC000822_A180ProfesionalColorDisponible, BC000822_A181ProfesionalColorCita, BC000822_A182ProfesionalTiempoCita, BC000822_A183ProfesionalDireccion, BC000822_A184PaisDescripcion, BC000822_A189ProfesionalFoto, BC000822_A40000ProfesionalFoto_GXI, BC000822_A190ProfesionalTwitter, BC000822_A191ProfesionalFacebook,
            BC000822_A192ProfesionalInstagram, BC000822_A193ProfesionalLinkedin, BC000822_A194ProfesionalTelefono, BC000822_A195ProfesionalFechaRegistro, BC000822_A196ProfesionalTerminosCondiciones, BC000822_A197ProfesionalEstadoCuenta, BC000822_A198ProfesionalEstado, BC000822_A186UbigeoDepartamento, BC000822_A187UbigeoProvincia, BC000822_A188UbigeoDistrito,
            BC000822_A43PaisId, BC000822_A44UbigeoCode, BC000822_A6SecUserId
            }
            , new Object[] {
            BC000823_A184PaisDescripcion
            }
            , new Object[] {
            BC000824_A186UbigeoDepartamento, BC000824_A187UbigeoProvincia, BC000824_A188UbigeoDistrito
            }
            , new Object[] {
            BC000825_A6SecUserId
            }
            , new Object[] {
            BC000826_A31ProfesionalId
            }
            , new Object[] {
            BC000827_A31ProfesionalId, BC000827_A173ProfesionalTipoDocumento, BC000827_A174ProfesionalNroDocumento, BC000827_A85ProfesionalApellidoPaterno, BC000827_A86ProfesionalApellidoMaterno, BC000827_A84ProfesionalNombres, BC000827_A176ProfesionalFechaNacimiento, BC000827_A177ProfesionalSexo, BC000827_A178ProfesionalDescripcion, BC000827_A179ProfesionalCorreo,
            BC000827_A88ProfesionalCOP, BC000827_A180ProfesionalColorDisponible, BC000827_A181ProfesionalColorCita, BC000827_A182ProfesionalTiempoCita, BC000827_A183ProfesionalDireccion, BC000827_A189ProfesionalFoto, BC000827_A40000ProfesionalFoto_GXI, BC000827_A190ProfesionalTwitter, BC000827_A191ProfesionalFacebook, BC000827_A192ProfesionalInstagram,
            BC000827_A193ProfesionalLinkedin, BC000827_A194ProfesionalTelefono, BC000827_A195ProfesionalFechaRegistro, BC000827_A196ProfesionalTerminosCondiciones, BC000827_A197ProfesionalEstadoCuenta, BC000827_A198ProfesionalEstado, BC000827_A43PaisId, BC000827_A44UbigeoCode, BC000827_A6SecUserId
            }
            , new Object[] {
            BC000828_A31ProfesionalId, BC000828_A173ProfesionalTipoDocumento, BC000828_A174ProfesionalNroDocumento, BC000828_A85ProfesionalApellidoPaterno, BC000828_A86ProfesionalApellidoMaterno, BC000828_A84ProfesionalNombres, BC000828_A176ProfesionalFechaNacimiento, BC000828_A177ProfesionalSexo, BC000828_A178ProfesionalDescripcion, BC000828_A179ProfesionalCorreo,
            BC000828_A88ProfesionalCOP, BC000828_A180ProfesionalColorDisponible, BC000828_A181ProfesionalColorCita, BC000828_A182ProfesionalTiempoCita, BC000828_A183ProfesionalDireccion, BC000828_A189ProfesionalFoto, BC000828_A40000ProfesionalFoto_GXI, BC000828_A190ProfesionalTwitter, BC000828_A191ProfesionalFacebook, BC000828_A192ProfesionalInstagram,
            BC000828_A193ProfesionalLinkedin, BC000828_A194ProfesionalTelefono, BC000828_A195ProfesionalFechaRegistro, BC000828_A196ProfesionalTerminosCondiciones, BC000828_A197ProfesionalEstadoCuenta, BC000828_A198ProfesionalEstado, BC000828_A43PaisId, BC000828_A44UbigeoCode, BC000828_A6SecUserId
            }
            , new Object[] {
            BC000829_A31ProfesionalId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000833_A184PaisDescripcion
            }
            , new Object[] {
            BC000834_A186UbigeoDepartamento, BC000834_A187UbigeoProvincia, BC000834_A188UbigeoDistrito
            }
            , new Object[] {
            BC000835_A63ComentarioProfesionalId
            }
            , new Object[] {
            BC000836_A60RatingProfesionalId
            }
            , new Object[] {
            BC000837_A59EducacionProfesionalId
            }
            , new Object[] {
            BC000838_A31ProfesionalId, BC000838_A32EspecialidadId
            }
            , new Object[] {
            BC000839_A31ProfesionalId, BC000839_A173ProfesionalTipoDocumento, BC000839_A174ProfesionalNroDocumento, BC000839_A85ProfesionalApellidoPaterno, BC000839_A86ProfesionalApellidoMaterno, BC000839_A84ProfesionalNombres, BC000839_A176ProfesionalFechaNacimiento, BC000839_A177ProfesionalSexo, BC000839_A178ProfesionalDescripcion, BC000839_A179ProfesionalCorreo,
            BC000839_A88ProfesionalCOP, BC000839_A180ProfesionalColorDisponible, BC000839_A181ProfesionalColorCita, BC000839_A182ProfesionalTiempoCita, BC000839_A183ProfesionalDireccion, BC000839_A184PaisDescripcion, BC000839_A189ProfesionalFoto, BC000839_A40000ProfesionalFoto_GXI, BC000839_A190ProfesionalTwitter, BC000839_A191ProfesionalFacebook,
            BC000839_A192ProfesionalInstagram, BC000839_A193ProfesionalLinkedin, BC000839_A194ProfesionalTelefono, BC000839_A195ProfesionalFechaRegistro, BC000839_A196ProfesionalTerminosCondiciones, BC000839_A197ProfesionalEstadoCuenta, BC000839_A198ProfesionalEstado, BC000839_A186UbigeoDepartamento, BC000839_A187UbigeoProvincia, BC000839_A188UbigeoDistrito,
            BC000839_A43PaisId, BC000839_A44UbigeoCode, BC000839_A6SecUserId
            }
            , new Object[] {
            BC000840_A31ProfesionalId, BC000840_A140EspecialidadCodigo, BC000840_A71EspecialidadNombre, BC000840_A32EspecialidadId
            }
            , new Object[] {
            BC000841_A140EspecialidadCodigo, BC000841_A71EspecialidadNombre
            }
            , new Object[] {
            BC000842_A31ProfesionalId, BC000842_A32EspecialidadId
            }
            , new Object[] {
            BC000843_A31ProfesionalId, BC000843_A32EspecialidadId
            }
            , new Object[] {
            BC000844_A31ProfesionalId, BC000844_A32EspecialidadId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000847_A140EspecialidadCodigo, BC000847_A71EspecialidadNombre
            }
            , new Object[] {
            BC000848_A34DisponibilidadId
            }
            , new Object[] {
            BC000849_A29ConfComisionId
            }
            , new Object[] {
            BC000850_A31ProfesionalId, BC000850_A140EspecialidadCodigo, BC000850_A71EspecialidadNombre, BC000850_A32EspecialidadId
            }
            , new Object[] {
            BC000851_A28ClinicaId, BC000851_A31ProfesionalId, BC000851_A32EspecialidadId, BC000851_A54SedeTipoConsulta, BC000851_A199CostoConsulta, BC000851_A75SedeNombre, BC000851_A80ClinicaNombreAbreviado, BC000851_A30SedeId
            }
            , new Object[] {
            BC000852_A28ClinicaId, BC000852_A75SedeNombre
            }
            , new Object[] {
            BC000853_A80ClinicaNombreAbreviado
            }
            , new Object[] {
            BC000854_A31ProfesionalId, BC000854_A32EspecialidadId, BC000854_A30SedeId, BC000854_A54SedeTipoConsulta
            }
            , new Object[] {
            BC000855_A31ProfesionalId, BC000855_A32EspecialidadId, BC000855_A54SedeTipoConsulta, BC000855_A199CostoConsulta, BC000855_A30SedeId
            }
            , new Object[] {
            BC000856_A31ProfesionalId, BC000856_A32EspecialidadId, BC000856_A54SedeTipoConsulta, BC000856_A199CostoConsulta, BC000856_A30SedeId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000860_A28ClinicaId, BC000860_A75SedeNombre
            }
            , new Object[] {
            BC000861_A80ClinicaNombreAbreviado
            }
            , new Object[] {
            BC000862_A28ClinicaId, BC000862_A31ProfesionalId, BC000862_A32EspecialidadId, BC000862_A54SedeTipoConsulta, BC000862_A199CostoConsulta, BC000862_A75SedeNombre, BC000862_A80ClinicaNombreAbreviado, BC000862_A30SedeId
            }
            , new Object[] {
            BC000863_A31ProfesionalId, BC000863_A55EducacionId, BC000863_A200EducacionNombreInstitucion, BC000863_A201EducacionDesde, BC000863_A202EducacionHasta, BC000863_A203EducacionPaisDescripcion
            }
            , new Object[] {
            BC000864_A31ProfesionalId, BC000864_A55EducacionId
            }
            , new Object[] {
            BC000865_A31ProfesionalId, BC000865_A55EducacionId, BC000865_A200EducacionNombreInstitucion, BC000865_A201EducacionDesde, BC000865_A202EducacionHasta, BC000865_A203EducacionPaisDescripcion
            }
            , new Object[] {
            BC000866_A31ProfesionalId, BC000866_A55EducacionId, BC000866_A200EducacionNombreInstitucion, BC000866_A201EducacionDesde, BC000866_A202EducacionHasta, BC000866_A203EducacionPaisDescripcion
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000870_A31ProfesionalId, BC000870_A55EducacionId, BC000870_A200EducacionNombreInstitucion, BC000870_A201EducacionDesde, BC000870_A202EducacionHasta, BC000870_A203EducacionPaisDescripcion
            }
            , new Object[] {
            BC000871_A31ProfesionalId, BC000871_A56ExperienciaLaboralId, BC000871_A204ExperienciaLaboralEmpresaNombre, BC000871_A205ExperienciaLaboralDesde, BC000871_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            BC000872_A31ProfesionalId, BC000872_A56ExperienciaLaboralId
            }
            , new Object[] {
            BC000873_A31ProfesionalId, BC000873_A56ExperienciaLaboralId, BC000873_A204ExperienciaLaboralEmpresaNombre, BC000873_A205ExperienciaLaboralDesde, BC000873_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            BC000874_A31ProfesionalId, BC000874_A56ExperienciaLaboralId, BC000874_A204ExperienciaLaboralEmpresaNombre, BC000874_A205ExperienciaLaboralDesde, BC000874_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000878_A31ProfesionalId, BC000878_A56ExperienciaLaboralId, BC000878_A204ExperienciaLaboralEmpresaNombre, BC000878_A205ExperienciaLaboralDesde, BC000878_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            BC000879_A31ProfesionalId, BC000879_A57PremiosId, BC000879_A207PremiosNombre, BC000879_A208PremiosFecha, BC000879_A209PremiosDescripcion
            }
            , new Object[] {
            BC000880_A31ProfesionalId, BC000880_A57PremiosId
            }
            , new Object[] {
            BC000881_A31ProfesionalId, BC000881_A57PremiosId, BC000881_A207PremiosNombre, BC000881_A208PremiosFecha, BC000881_A209PremiosDescripcion
            }
            , new Object[] {
            BC000882_A31ProfesionalId, BC000882_A57PremiosId, BC000882_A207PremiosNombre, BC000882_A208PremiosFecha, BC000882_A209PremiosDescripcion
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000886_A31ProfesionalId, BC000886_A57PremiosId, BC000886_A207PremiosNombre, BC000886_A208PremiosFecha, BC000886_A209PremiosDescripcion
            }
            , new Object[] {
            BC000887_A31ProfesionalId, BC000887_A58ServiciosId, BC000887_A210ServiciosNombre
            }
            , new Object[] {
            BC000888_A31ProfesionalId, BC000888_A58ServiciosId
            }
            , new Object[] {
            BC000889_A31ProfesionalId, BC000889_A58ServiciosId, BC000889_A210ServiciosNombre
            }
            , new Object[] {
            BC000890_A31ProfesionalId, BC000890_A58ServiciosId, BC000890_A210ServiciosNombre
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000894_A31ProfesionalId, BC000894_A58ServiciosId, BC000894_A210ServiciosNombre
            }
         }
      );
      Z58ServiciosId = java.util.UUID.randomUUID( ) ;
      A58ServiciosId = java.util.UUID.randomUUID( ) ;
      Z57PremiosId = java.util.UUID.randomUUID( ) ;
      A57PremiosId = java.util.UUID.randomUUID( ) ;
      Z56ExperienciaLaboralId = java.util.UUID.randomUUID( ) ;
      A56ExperienciaLaboralId = java.util.UUID.randomUUID( ) ;
      Z55EducacionId = java.util.UUID.randomUUID( ) ;
      A55EducacionId = java.util.UUID.randomUUID( ) ;
      Z199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      A199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      i199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      Z182ProfesionalTiempoCita = (byte)(30) ;
      A182ProfesionalTiempoCita = (byte)(30) ;
      i182ProfesionalTiempoCita = (byte)(30) ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e11082 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z182ProfesionalTiempoCita ;
   private byte A182ProfesionalTiempoCita ;
   private byte Gx_BScreen ;
   private byte Gxremove10 ;
   private byte Gxremove12 ;
   private byte Gxremove13 ;
   private byte Gxremove14 ;
   private byte Gxremove15 ;
   private byte Gxremove11 ;
   private byte i182ProfesionalTiempoCita ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nIsMod_15 ;
   private short RcdFound15 ;
   private short nIsMod_14 ;
   private short RcdFound14 ;
   private short nIsMod_13 ;
   private short RcdFound13 ;
   private short nIsMod_12 ;
   private short RcdFound12 ;
   private short nIsMod_11 ;
   private short RcdFound11 ;
   private short nIsMod_10 ;
   private short RcdFound10 ;
   private short Z43PaisId ;
   private short A43PaisId ;
   private short Z6SecUserId ;
   private short A6SecUserId ;
   private short RcdFound9 ;
   private short nIsDirty_9 ;
   private short nRcdExists_10 ;
   private short nRcdExists_12 ;
   private short nRcdExists_13 ;
   private short nRcdExists_14 ;
   private short nRcdExists_15 ;
   private short Z32EspecialidadId ;
   private short A32EspecialidadId ;
   private short nIsDirty_10 ;
   private short nRcdExists_11 ;
   private short Z28ClinicaId ;
   private short A28ClinicaId ;
   private short Z30SedeId ;
   private short A30SedeId ;
   private short nIsDirty_11 ;
   private short nIsDirty_12 ;
   private short nIsDirty_13 ;
   private short nIsDirty_14 ;
   private short nIsDirty_15 ;
   private int trnEnded ;
   private int Z31ProfesionalId ;
   private int A31ProfesionalId ;
   private int nGXsfl_15_idx=1 ;
   private int nGXsfl_14_idx=1 ;
   private int nGXsfl_13_idx=1 ;
   private int nGXsfl_12_idx=1 ;
   private int nGXsfl_11_idx=1 ;
   private int nGXsfl_10_idx=1 ;
   private int GX_JID ;
   private java.math.BigDecimal Z199CostoConsulta ;
   private java.math.BigDecimal A199CostoConsulta ;
   private java.math.BigDecimal i199CostoConsulta ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode9 ;
   private String sMode10 ;
   private String Z173ProfesionalTipoDocumento ;
   private String A173ProfesionalTipoDocumento ;
   private String Z177ProfesionalSexo ;
   private String A177ProfesionalSexo ;
   private String Z180ProfesionalColorDisponible ;
   private String A180ProfesionalColorDisponible ;
   private String Z181ProfesionalColorCita ;
   private String A181ProfesionalColorCita ;
   private String Z194ProfesionalTelefono ;
   private String A194ProfesionalTelefono ;
   private String Z197ProfesionalEstadoCuenta ;
   private String A197ProfesionalEstadoCuenta ;
   private String Z198ProfesionalEstado ;
   private String A198ProfesionalEstado ;
   private String Z44UbigeoCode ;
   private String A44UbigeoCode ;
   private String Z54SedeTipoConsulta ;
   private String A54SedeTipoConsulta ;
   private String sMode11 ;
   private String sMode12 ;
   private String sMode13 ;
   private String sMode14 ;
   private String sMode15 ;
   private java.util.Date Z176ProfesionalFechaNacimiento ;
   private java.util.Date A176ProfesionalFechaNacimiento ;
   private java.util.Date Z195ProfesionalFechaRegistro ;
   private java.util.Date A195ProfesionalFechaRegistro ;
   private java.util.Date Z201EducacionDesde ;
   private java.util.Date A201EducacionDesde ;
   private java.util.Date Z202EducacionHasta ;
   private java.util.Date A202EducacionHasta ;
   private java.util.Date Z205ExperienciaLaboralDesde ;
   private java.util.Date A205ExperienciaLaboralDesde ;
   private java.util.Date Z206ExperienciaLaboralHasta ;
   private java.util.Date A206ExperienciaLaboralHasta ;
   private java.util.Date Z208PremiosFecha ;
   private java.util.Date A208PremiosFecha ;
   private boolean returnInSub ;
   private boolean Z196ProfesionalTerminosCondiciones ;
   private boolean A196ProfesionalTerminosCondiciones ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z209PremiosDescripcion ;
   private String A209PremiosDescripcion ;
   private String Z174ProfesionalNroDocumento ;
   private String A174ProfesionalNroDocumento ;
   private String Z85ProfesionalApellidoPaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String Z86ProfesionalApellidoMaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String Z84ProfesionalNombres ;
   private String A84ProfesionalNombres ;
   private String Z178ProfesionalDescripcion ;
   private String A178ProfesionalDescripcion ;
   private String Z179ProfesionalCorreo ;
   private String A179ProfesionalCorreo ;
   private String Z88ProfesionalCOP ;
   private String A88ProfesionalCOP ;
   private String Z183ProfesionalDireccion ;
   private String A183ProfesionalDireccion ;
   private String Z190ProfesionalTwitter ;
   private String A190ProfesionalTwitter ;
   private String Z191ProfesionalFacebook ;
   private String A191ProfesionalFacebook ;
   private String Z192ProfesionalInstagram ;
   private String A192ProfesionalInstagram ;
   private String Z193ProfesionalLinkedin ;
   private String A193ProfesionalLinkedin ;
   private String Z175ProfesionalNombreCompleto2 ;
   private String A175ProfesionalNombreCompleto2 ;
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
   private String Z40000ProfesionalFoto_GXI ;
   private String A40000ProfesionalFoto_GXI ;
   private String Z140EspecialidadCodigo ;
   private String A140EspecialidadCodigo ;
   private String Z71EspecialidadNombre ;
   private String A71EspecialidadNombre ;
   private String Z75SedeNombre ;
   private String A75SedeNombre ;
   private String Z80ClinicaNombreAbreviado ;
   private String A80ClinicaNombreAbreviado ;
   private String Z200EducacionNombreInstitucion ;
   private String A200EducacionNombreInstitucion ;
   private String Z203EducacionPaisDescripcion ;
   private String A203EducacionPaisDescripcion ;
   private String Z204ExperienciaLaboralEmpresaNombre ;
   private String A204ExperienciaLaboralEmpresaNombre ;
   private String Z207PremiosNombre ;
   private String A207PremiosNombre ;
   private String Z210ServiciosNombre ;
   private String A210ServiciosNombre ;
   private String Z189ProfesionalFoto ;
   private String A189ProfesionalFoto ;
   private java.util.UUID Z55EducacionId ;
   private java.util.UUID A55EducacionId ;
   private java.util.UUID Z56ExperienciaLaboralId ;
   private java.util.UUID A56ExperienciaLaboralId ;
   private java.util.UUID Z57PremiosId ;
   private java.util.UUID A57PremiosId ;
   private java.util.UUID Z58ServiciosId ;
   private java.util.UUID A58ServiciosId ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtProfesional bcProfesional ;
   private IDataStoreProvider pr_default ;
   private int[] BC000822_A31ProfesionalId ;
   private String[] BC000822_A173ProfesionalTipoDocumento ;
   private String[] BC000822_A174ProfesionalNroDocumento ;
   private String[] BC000822_A85ProfesionalApellidoPaterno ;
   private String[] BC000822_A86ProfesionalApellidoMaterno ;
   private String[] BC000822_A84ProfesionalNombres ;
   private java.util.Date[] BC000822_A176ProfesionalFechaNacimiento ;
   private String[] BC000822_A177ProfesionalSexo ;
   private String[] BC000822_A178ProfesionalDescripcion ;
   private String[] BC000822_A179ProfesionalCorreo ;
   private String[] BC000822_A88ProfesionalCOP ;
   private String[] BC000822_A180ProfesionalColorDisponible ;
   private String[] BC000822_A181ProfesionalColorCita ;
   private byte[] BC000822_A182ProfesionalTiempoCita ;
   private String[] BC000822_A183ProfesionalDireccion ;
   private String[] BC000822_A184PaisDescripcion ;
   private String[] BC000822_A189ProfesionalFoto ;
   private String[] BC000822_A40000ProfesionalFoto_GXI ;
   private String[] BC000822_A190ProfesionalTwitter ;
   private String[] BC000822_A191ProfesionalFacebook ;
   private String[] BC000822_A192ProfesionalInstagram ;
   private String[] BC000822_A193ProfesionalLinkedin ;
   private String[] BC000822_A194ProfesionalTelefono ;
   private java.util.Date[] BC000822_A195ProfesionalFechaRegistro ;
   private boolean[] BC000822_A196ProfesionalTerminosCondiciones ;
   private String[] BC000822_A197ProfesionalEstadoCuenta ;
   private String[] BC000822_A198ProfesionalEstado ;
   private String[] BC000822_A186UbigeoDepartamento ;
   private String[] BC000822_A187UbigeoProvincia ;
   private String[] BC000822_A188UbigeoDistrito ;
   private short[] BC000822_A43PaisId ;
   private String[] BC000822_A44UbigeoCode ;
   private short[] BC000822_A6SecUserId ;
   private String[] BC000823_A184PaisDescripcion ;
   private String[] BC000824_A186UbigeoDepartamento ;
   private String[] BC000824_A187UbigeoProvincia ;
   private String[] BC000824_A188UbigeoDistrito ;
   private short[] BC000825_A6SecUserId ;
   private int[] BC000826_A31ProfesionalId ;
   private int[] BC000827_A31ProfesionalId ;
   private String[] BC000827_A173ProfesionalTipoDocumento ;
   private String[] BC000827_A174ProfesionalNroDocumento ;
   private String[] BC000827_A85ProfesionalApellidoPaterno ;
   private String[] BC000827_A86ProfesionalApellidoMaterno ;
   private String[] BC000827_A84ProfesionalNombres ;
   private java.util.Date[] BC000827_A176ProfesionalFechaNacimiento ;
   private String[] BC000827_A177ProfesionalSexo ;
   private String[] BC000827_A178ProfesionalDescripcion ;
   private String[] BC000827_A179ProfesionalCorreo ;
   private String[] BC000827_A88ProfesionalCOP ;
   private String[] BC000827_A180ProfesionalColorDisponible ;
   private String[] BC000827_A181ProfesionalColorCita ;
   private byte[] BC000827_A182ProfesionalTiempoCita ;
   private String[] BC000827_A183ProfesionalDireccion ;
   private String[] BC000827_A189ProfesionalFoto ;
   private String[] BC000827_A40000ProfesionalFoto_GXI ;
   private String[] BC000827_A190ProfesionalTwitter ;
   private String[] BC000827_A191ProfesionalFacebook ;
   private String[] BC000827_A192ProfesionalInstagram ;
   private String[] BC000827_A193ProfesionalLinkedin ;
   private String[] BC000827_A194ProfesionalTelefono ;
   private java.util.Date[] BC000827_A195ProfesionalFechaRegistro ;
   private boolean[] BC000827_A196ProfesionalTerminosCondiciones ;
   private String[] BC000827_A197ProfesionalEstadoCuenta ;
   private String[] BC000827_A198ProfesionalEstado ;
   private short[] BC000827_A43PaisId ;
   private String[] BC000827_A44UbigeoCode ;
   private short[] BC000827_A6SecUserId ;
   private int[] BC000828_A31ProfesionalId ;
   private String[] BC000828_A173ProfesionalTipoDocumento ;
   private String[] BC000828_A174ProfesionalNroDocumento ;
   private String[] BC000828_A85ProfesionalApellidoPaterno ;
   private String[] BC000828_A86ProfesionalApellidoMaterno ;
   private String[] BC000828_A84ProfesionalNombres ;
   private java.util.Date[] BC000828_A176ProfesionalFechaNacimiento ;
   private String[] BC000828_A177ProfesionalSexo ;
   private String[] BC000828_A178ProfesionalDescripcion ;
   private String[] BC000828_A179ProfesionalCorreo ;
   private String[] BC000828_A88ProfesionalCOP ;
   private String[] BC000828_A180ProfesionalColorDisponible ;
   private String[] BC000828_A181ProfesionalColorCita ;
   private byte[] BC000828_A182ProfesionalTiempoCita ;
   private String[] BC000828_A183ProfesionalDireccion ;
   private String[] BC000828_A189ProfesionalFoto ;
   private String[] BC000828_A40000ProfesionalFoto_GXI ;
   private String[] BC000828_A190ProfesionalTwitter ;
   private String[] BC000828_A191ProfesionalFacebook ;
   private String[] BC000828_A192ProfesionalInstagram ;
   private String[] BC000828_A193ProfesionalLinkedin ;
   private String[] BC000828_A194ProfesionalTelefono ;
   private java.util.Date[] BC000828_A195ProfesionalFechaRegistro ;
   private boolean[] BC000828_A196ProfesionalTerminosCondiciones ;
   private String[] BC000828_A197ProfesionalEstadoCuenta ;
   private String[] BC000828_A198ProfesionalEstado ;
   private short[] BC000828_A43PaisId ;
   private String[] BC000828_A44UbigeoCode ;
   private short[] BC000828_A6SecUserId ;
   private int[] BC000829_A31ProfesionalId ;
   private String[] BC000833_A184PaisDescripcion ;
   private String[] BC000834_A186UbigeoDepartamento ;
   private String[] BC000834_A187UbigeoProvincia ;
   private String[] BC000834_A188UbigeoDistrito ;
   private int[] BC000835_A63ComentarioProfesionalId ;
   private int[] BC000836_A60RatingProfesionalId ;
   private int[] BC000837_A59EducacionProfesionalId ;
   private int[] BC000838_A31ProfesionalId ;
   private short[] BC000838_A32EspecialidadId ;
   private int[] BC000839_A31ProfesionalId ;
   private String[] BC000839_A173ProfesionalTipoDocumento ;
   private String[] BC000839_A174ProfesionalNroDocumento ;
   private String[] BC000839_A85ProfesionalApellidoPaterno ;
   private String[] BC000839_A86ProfesionalApellidoMaterno ;
   private String[] BC000839_A84ProfesionalNombres ;
   private java.util.Date[] BC000839_A176ProfesionalFechaNacimiento ;
   private String[] BC000839_A177ProfesionalSexo ;
   private String[] BC000839_A178ProfesionalDescripcion ;
   private String[] BC000839_A179ProfesionalCorreo ;
   private String[] BC000839_A88ProfesionalCOP ;
   private String[] BC000839_A180ProfesionalColorDisponible ;
   private String[] BC000839_A181ProfesionalColorCita ;
   private byte[] BC000839_A182ProfesionalTiempoCita ;
   private String[] BC000839_A183ProfesionalDireccion ;
   private String[] BC000839_A184PaisDescripcion ;
   private String[] BC000839_A189ProfesionalFoto ;
   private String[] BC000839_A40000ProfesionalFoto_GXI ;
   private String[] BC000839_A190ProfesionalTwitter ;
   private String[] BC000839_A191ProfesionalFacebook ;
   private String[] BC000839_A192ProfesionalInstagram ;
   private String[] BC000839_A193ProfesionalLinkedin ;
   private String[] BC000839_A194ProfesionalTelefono ;
   private java.util.Date[] BC000839_A195ProfesionalFechaRegistro ;
   private boolean[] BC000839_A196ProfesionalTerminosCondiciones ;
   private String[] BC000839_A197ProfesionalEstadoCuenta ;
   private String[] BC000839_A198ProfesionalEstado ;
   private String[] BC000839_A186UbigeoDepartamento ;
   private String[] BC000839_A187UbigeoProvincia ;
   private String[] BC000839_A188UbigeoDistrito ;
   private short[] BC000839_A43PaisId ;
   private String[] BC000839_A44UbigeoCode ;
   private short[] BC000839_A6SecUserId ;
   private int[] BC000840_A31ProfesionalId ;
   private String[] BC000840_A140EspecialidadCodigo ;
   private String[] BC000840_A71EspecialidadNombre ;
   private short[] BC000840_A32EspecialidadId ;
   private String[] BC000841_A140EspecialidadCodigo ;
   private String[] BC000841_A71EspecialidadNombre ;
   private int[] BC000842_A31ProfesionalId ;
   private short[] BC000842_A32EspecialidadId ;
   private int[] BC000843_A31ProfesionalId ;
   private short[] BC000843_A32EspecialidadId ;
   private int[] BC000844_A31ProfesionalId ;
   private short[] BC000844_A32EspecialidadId ;
   private String[] BC000847_A140EspecialidadCodigo ;
   private String[] BC000847_A71EspecialidadNombre ;
   private int[] BC000848_A34DisponibilidadId ;
   private short[] BC000849_A29ConfComisionId ;
   private int[] BC000850_A31ProfesionalId ;
   private String[] BC000850_A140EspecialidadCodigo ;
   private String[] BC000850_A71EspecialidadNombre ;
   private short[] BC000850_A32EspecialidadId ;
   private short[] BC000851_A28ClinicaId ;
   private int[] BC000851_A31ProfesionalId ;
   private short[] BC000851_A32EspecialidadId ;
   private String[] BC000851_A54SedeTipoConsulta ;
   private java.math.BigDecimal[] BC000851_A199CostoConsulta ;
   private String[] BC000851_A75SedeNombre ;
   private String[] BC000851_A80ClinicaNombreAbreviado ;
   private short[] BC000851_A30SedeId ;
   private short[] BC000852_A28ClinicaId ;
   private String[] BC000852_A75SedeNombre ;
   private String[] BC000853_A80ClinicaNombreAbreviado ;
   private int[] BC000854_A31ProfesionalId ;
   private short[] BC000854_A32EspecialidadId ;
   private short[] BC000854_A30SedeId ;
   private String[] BC000854_A54SedeTipoConsulta ;
   private int[] BC000855_A31ProfesionalId ;
   private short[] BC000855_A32EspecialidadId ;
   private String[] BC000855_A54SedeTipoConsulta ;
   private java.math.BigDecimal[] BC000855_A199CostoConsulta ;
   private short[] BC000855_A30SedeId ;
   private int[] BC000856_A31ProfesionalId ;
   private short[] BC000856_A32EspecialidadId ;
   private String[] BC000856_A54SedeTipoConsulta ;
   private java.math.BigDecimal[] BC000856_A199CostoConsulta ;
   private short[] BC000856_A30SedeId ;
   private short[] BC000860_A28ClinicaId ;
   private String[] BC000860_A75SedeNombre ;
   private String[] BC000861_A80ClinicaNombreAbreviado ;
   private short[] BC000862_A28ClinicaId ;
   private int[] BC000862_A31ProfesionalId ;
   private short[] BC000862_A32EspecialidadId ;
   private String[] BC000862_A54SedeTipoConsulta ;
   private java.math.BigDecimal[] BC000862_A199CostoConsulta ;
   private String[] BC000862_A75SedeNombre ;
   private String[] BC000862_A80ClinicaNombreAbreviado ;
   private short[] BC000862_A30SedeId ;
   private int[] BC000863_A31ProfesionalId ;
   private java.util.UUID[] BC000863_A55EducacionId ;
   private String[] BC000863_A200EducacionNombreInstitucion ;
   private java.util.Date[] BC000863_A201EducacionDesde ;
   private java.util.Date[] BC000863_A202EducacionHasta ;
   private String[] BC000863_A203EducacionPaisDescripcion ;
   private int[] BC000864_A31ProfesionalId ;
   private java.util.UUID[] BC000864_A55EducacionId ;
   private int[] BC000865_A31ProfesionalId ;
   private java.util.UUID[] BC000865_A55EducacionId ;
   private String[] BC000865_A200EducacionNombreInstitucion ;
   private java.util.Date[] BC000865_A201EducacionDesde ;
   private java.util.Date[] BC000865_A202EducacionHasta ;
   private String[] BC000865_A203EducacionPaisDescripcion ;
   private int[] BC000866_A31ProfesionalId ;
   private java.util.UUID[] BC000866_A55EducacionId ;
   private String[] BC000866_A200EducacionNombreInstitucion ;
   private java.util.Date[] BC000866_A201EducacionDesde ;
   private java.util.Date[] BC000866_A202EducacionHasta ;
   private String[] BC000866_A203EducacionPaisDescripcion ;
   private int[] BC000870_A31ProfesionalId ;
   private java.util.UUID[] BC000870_A55EducacionId ;
   private String[] BC000870_A200EducacionNombreInstitucion ;
   private java.util.Date[] BC000870_A201EducacionDesde ;
   private java.util.Date[] BC000870_A202EducacionHasta ;
   private String[] BC000870_A203EducacionPaisDescripcion ;
   private int[] BC000871_A31ProfesionalId ;
   private java.util.UUID[] BC000871_A56ExperienciaLaboralId ;
   private String[] BC000871_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] BC000871_A205ExperienciaLaboralDesde ;
   private java.util.Date[] BC000871_A206ExperienciaLaboralHasta ;
   private int[] BC000872_A31ProfesionalId ;
   private java.util.UUID[] BC000872_A56ExperienciaLaboralId ;
   private int[] BC000873_A31ProfesionalId ;
   private java.util.UUID[] BC000873_A56ExperienciaLaboralId ;
   private String[] BC000873_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] BC000873_A205ExperienciaLaboralDesde ;
   private java.util.Date[] BC000873_A206ExperienciaLaboralHasta ;
   private int[] BC000874_A31ProfesionalId ;
   private java.util.UUID[] BC000874_A56ExperienciaLaboralId ;
   private String[] BC000874_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] BC000874_A205ExperienciaLaboralDesde ;
   private java.util.Date[] BC000874_A206ExperienciaLaboralHasta ;
   private int[] BC000878_A31ProfesionalId ;
   private java.util.UUID[] BC000878_A56ExperienciaLaboralId ;
   private String[] BC000878_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] BC000878_A205ExperienciaLaboralDesde ;
   private java.util.Date[] BC000878_A206ExperienciaLaboralHasta ;
   private int[] BC000879_A31ProfesionalId ;
   private java.util.UUID[] BC000879_A57PremiosId ;
   private String[] BC000879_A207PremiosNombre ;
   private java.util.Date[] BC000879_A208PremiosFecha ;
   private String[] BC000879_A209PremiosDescripcion ;
   private int[] BC000880_A31ProfesionalId ;
   private java.util.UUID[] BC000880_A57PremiosId ;
   private int[] BC000881_A31ProfesionalId ;
   private java.util.UUID[] BC000881_A57PremiosId ;
   private String[] BC000881_A207PremiosNombre ;
   private java.util.Date[] BC000881_A208PremiosFecha ;
   private String[] BC000881_A209PremiosDescripcion ;
   private int[] BC000882_A31ProfesionalId ;
   private java.util.UUID[] BC000882_A57PremiosId ;
   private String[] BC000882_A207PremiosNombre ;
   private java.util.Date[] BC000882_A208PremiosFecha ;
   private String[] BC000882_A209PremiosDescripcion ;
   private int[] BC000886_A31ProfesionalId ;
   private java.util.UUID[] BC000886_A57PremiosId ;
   private String[] BC000886_A207PremiosNombre ;
   private java.util.Date[] BC000886_A208PremiosFecha ;
   private String[] BC000886_A209PremiosDescripcion ;
   private int[] BC000887_A31ProfesionalId ;
   private java.util.UUID[] BC000887_A58ServiciosId ;
   private String[] BC000887_A210ServiciosNombre ;
   private int[] BC000888_A31ProfesionalId ;
   private java.util.UUID[] BC000888_A58ServiciosId ;
   private int[] BC000889_A31ProfesionalId ;
   private java.util.UUID[] BC000889_A58ServiciosId ;
   private String[] BC000889_A210ServiciosNombre ;
   private int[] BC000890_A31ProfesionalId ;
   private java.util.UUID[] BC000890_A58ServiciosId ;
   private String[] BC000890_A210ServiciosNombre ;
   private int[] BC000894_A31ProfesionalId ;
   private java.util.UUID[] BC000894_A58ServiciosId ;
   private String[] BC000894_A210ServiciosNombre ;
   private int[] BC00082_A31ProfesionalId ;
   private java.util.UUID[] BC00082_A58ServiciosId ;
   private String[] BC00082_A210ServiciosNombre ;
   private int[] BC00083_A31ProfesionalId ;
   private java.util.UUID[] BC00083_A58ServiciosId ;
   private String[] BC00083_A210ServiciosNombre ;
   private int[] BC00084_A31ProfesionalId ;
   private java.util.UUID[] BC00084_A57PremiosId ;
   private String[] BC00084_A207PremiosNombre ;
   private java.util.Date[] BC00084_A208PremiosFecha ;
   private String[] BC00084_A209PremiosDescripcion ;
   private int[] BC00085_A31ProfesionalId ;
   private java.util.UUID[] BC00085_A57PremiosId ;
   private String[] BC00085_A207PremiosNombre ;
   private java.util.Date[] BC00085_A208PremiosFecha ;
   private String[] BC00085_A209PremiosDescripcion ;
   private int[] BC00086_A31ProfesionalId ;
   private java.util.UUID[] BC00086_A56ExperienciaLaboralId ;
   private String[] BC00086_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] BC00086_A205ExperienciaLaboralDesde ;
   private java.util.Date[] BC00086_A206ExperienciaLaboralHasta ;
   private int[] BC00087_A31ProfesionalId ;
   private java.util.UUID[] BC00087_A56ExperienciaLaboralId ;
   private String[] BC00087_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] BC00087_A205ExperienciaLaboralDesde ;
   private java.util.Date[] BC00087_A206ExperienciaLaboralHasta ;
   private int[] BC00088_A31ProfesionalId ;
   private java.util.UUID[] BC00088_A55EducacionId ;
   private String[] BC00088_A200EducacionNombreInstitucion ;
   private java.util.Date[] BC00088_A201EducacionDesde ;
   private java.util.Date[] BC00088_A202EducacionHasta ;
   private String[] BC00088_A203EducacionPaisDescripcion ;
   private int[] BC00089_A31ProfesionalId ;
   private java.util.UUID[] BC00089_A55EducacionId ;
   private String[] BC00089_A200EducacionNombreInstitucion ;
   private java.util.Date[] BC00089_A201EducacionDesde ;
   private java.util.Date[] BC00089_A202EducacionHasta ;
   private String[] BC00089_A203EducacionPaisDescripcion ;
   private int[] BC000810_A31ProfesionalId ;
   private short[] BC000810_A32EspecialidadId ;
   private String[] BC000810_A54SedeTipoConsulta ;
   private java.math.BigDecimal[] BC000810_A199CostoConsulta ;
   private short[] BC000810_A30SedeId ;
   private int[] BC000811_A31ProfesionalId ;
   private short[] BC000811_A32EspecialidadId ;
   private String[] BC000811_A54SedeTipoConsulta ;
   private java.math.BigDecimal[] BC000811_A199CostoConsulta ;
   private short[] BC000811_A30SedeId ;
   private short[] BC000812_A28ClinicaId ;
   private String[] BC000812_A75SedeNombre ;
   private String[] BC000813_A80ClinicaNombreAbreviado ;
   private int[] BC000814_A31ProfesionalId ;
   private short[] BC000814_A32EspecialidadId ;
   private int[] BC000815_A31ProfesionalId ;
   private short[] BC000815_A32EspecialidadId ;
   private String[] BC000816_A140EspecialidadCodigo ;
   private String[] BC000816_A71EspecialidadNombre ;
   private int[] BC000817_A31ProfesionalId ;
   private String[] BC000817_A173ProfesionalTipoDocumento ;
   private String[] BC000817_A174ProfesionalNroDocumento ;
   private String[] BC000817_A85ProfesionalApellidoPaterno ;
   private String[] BC000817_A86ProfesionalApellidoMaterno ;
   private String[] BC000817_A84ProfesionalNombres ;
   private java.util.Date[] BC000817_A176ProfesionalFechaNacimiento ;
   private String[] BC000817_A177ProfesionalSexo ;
   private String[] BC000817_A178ProfesionalDescripcion ;
   private String[] BC000817_A179ProfesionalCorreo ;
   private String[] BC000817_A88ProfesionalCOP ;
   private String[] BC000817_A180ProfesionalColorDisponible ;
   private String[] BC000817_A181ProfesionalColorCita ;
   private byte[] BC000817_A182ProfesionalTiempoCita ;
   private String[] BC000817_A183ProfesionalDireccion ;
   private String[] BC000817_A189ProfesionalFoto ;
   private String[] BC000817_A40000ProfesionalFoto_GXI ;
   private String[] BC000817_A190ProfesionalTwitter ;
   private String[] BC000817_A191ProfesionalFacebook ;
   private String[] BC000817_A192ProfesionalInstagram ;
   private String[] BC000817_A193ProfesionalLinkedin ;
   private String[] BC000817_A194ProfesionalTelefono ;
   private java.util.Date[] BC000817_A195ProfesionalFechaRegistro ;
   private boolean[] BC000817_A196ProfesionalTerminosCondiciones ;
   private String[] BC000817_A197ProfesionalEstadoCuenta ;
   private String[] BC000817_A198ProfesionalEstado ;
   private short[] BC000817_A43PaisId ;
   private String[] BC000817_A44UbigeoCode ;
   private short[] BC000817_A6SecUserId ;
   private int[] BC000818_A31ProfesionalId ;
   private String[] BC000818_A173ProfesionalTipoDocumento ;
   private String[] BC000818_A174ProfesionalNroDocumento ;
   private String[] BC000818_A85ProfesionalApellidoPaterno ;
   private String[] BC000818_A86ProfesionalApellidoMaterno ;
   private String[] BC000818_A84ProfesionalNombres ;
   private java.util.Date[] BC000818_A176ProfesionalFechaNacimiento ;
   private String[] BC000818_A177ProfesionalSexo ;
   private String[] BC000818_A178ProfesionalDescripcion ;
   private String[] BC000818_A179ProfesionalCorreo ;
   private String[] BC000818_A88ProfesionalCOP ;
   private String[] BC000818_A180ProfesionalColorDisponible ;
   private String[] BC000818_A181ProfesionalColorCita ;
   private byte[] BC000818_A182ProfesionalTiempoCita ;
   private String[] BC000818_A183ProfesionalDireccion ;
   private String[] BC000818_A189ProfesionalFoto ;
   private String[] BC000818_A40000ProfesionalFoto_GXI ;
   private String[] BC000818_A190ProfesionalTwitter ;
   private String[] BC000818_A191ProfesionalFacebook ;
   private String[] BC000818_A192ProfesionalInstagram ;
   private String[] BC000818_A193ProfesionalLinkedin ;
   private String[] BC000818_A194ProfesionalTelefono ;
   private java.util.Date[] BC000818_A195ProfesionalFechaRegistro ;
   private boolean[] BC000818_A196ProfesionalTerminosCondiciones ;
   private String[] BC000818_A197ProfesionalEstadoCuenta ;
   private String[] BC000818_A198ProfesionalEstado ;
   private short[] BC000818_A43PaisId ;
   private String[] BC000818_A44UbigeoCode ;
   private short[] BC000818_A6SecUserId ;
   private String[] BC000819_A184PaisDescripcion ;
   private String[] BC000820_A186UbigeoDepartamento ;
   private String[] BC000820_A187UbigeoProvincia ;
   private String[] BC000820_A188UbigeoDistrito ;
   private short[] BC000821_A6SecUserId ;
}

final  class profesional_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00082", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [ServiciosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00083", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? AND [ServiciosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00084", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion] FROM [ProfesionalPremios] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [PremiosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00085", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? AND [PremiosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00086", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00087", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00088", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [EducacionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00089", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? AND [EducacionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000810", "SELECT [ProfesionalId], [EspecialidadId], [SedeTipoConsulta], [CostoConsulta], [SedeId] FROM [ProfesionalEspecialidadSede] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000811", "SELECT [ProfesionalId], [EspecialidadId], [SedeTipoConsulta], [CostoConsulta], [SedeId] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000812", "SELECT [ClinicaId], [SedeNombre] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000813", "SELECT [ClinicaNombreAbreviado] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000814", "SELECT [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000815", "SELECT [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000816", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000817", "SELECT [ProfesionalId], [ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalFechaNacimiento], [ProfesionalSexo], [ProfesionalDescripcion], [ProfesionalCorreo], [ProfesionalCOP], [ProfesionalColorDisponible], [ProfesionalColorCita], [ProfesionalTiempoCita], [ProfesionalDireccion], [ProfesionalFoto], [ProfesionalFoto_GXI], [ProfesionalTwitter], [ProfesionalFacebook], [ProfesionalInstagram], [ProfesionalLinkedin], [ProfesionalTelefono], [ProfesionalFechaRegistro], [ProfesionalTerminosCondiciones], [ProfesionalEstadoCuenta], [ProfesionalEstado], [PaisId], [UbigeoCode], [SecUserId] FROM [Profesional] WITH (UPDLOCK) WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000818", "SELECT [ProfesionalId], [ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalFechaNacimiento], [ProfesionalSexo], [ProfesionalDescripcion], [ProfesionalCorreo], [ProfesionalCOP], [ProfesionalColorDisponible], [ProfesionalColorCita], [ProfesionalTiempoCita], [ProfesionalDireccion], [ProfesionalFoto], [ProfesionalFoto_GXI], [ProfesionalTwitter], [ProfesionalFacebook], [ProfesionalInstagram], [ProfesionalLinkedin], [ProfesionalTelefono], [ProfesionalFechaRegistro], [ProfesionalTerminosCondiciones], [ProfesionalEstadoCuenta], [ProfesionalEstado], [PaisId], [UbigeoCode], [SecUserId] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000819", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000820", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000821", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000822", "SELECT TM1.[ProfesionalId], TM1.[ProfesionalTipoDocumento], TM1.[ProfesionalNroDocumento], TM1.[ProfesionalApellidoPaterno], TM1.[ProfesionalApellidoMaterno], TM1.[ProfesionalNombres], TM1.[ProfesionalFechaNacimiento], TM1.[ProfesionalSexo], TM1.[ProfesionalDescripcion], TM1.[ProfesionalCorreo], TM1.[ProfesionalCOP], TM1.[ProfesionalColorDisponible], TM1.[ProfesionalColorCita], TM1.[ProfesionalTiempoCita], TM1.[ProfesionalDireccion], T2.[PaisDescripcion], TM1.[ProfesionalFoto], TM1.[ProfesionalFoto_GXI], TM1.[ProfesionalTwitter], TM1.[ProfesionalFacebook], TM1.[ProfesionalInstagram], TM1.[ProfesionalLinkedin], TM1.[ProfesionalTelefono], TM1.[ProfesionalFechaRegistro], TM1.[ProfesionalTerminosCondiciones], TM1.[ProfesionalEstadoCuenta], TM1.[ProfesionalEstado], T3.[UbigeoDepartamento], T3.[UbigeoProvincia], T3.[UbigeoDistrito], TM1.[PaisId], TM1.[UbigeoCode], TM1.[SecUserId] FROM (([Profesional] TM1 INNER JOIN [Pais] T2 ON T2.[PaisId] = TM1.[PaisId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = TM1.[UbigeoCode]) WHERE TM1.[ProfesionalId] = ? ORDER BY TM1.[ProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000823", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000824", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000825", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000826", "SELECT [ProfesionalId] FROM [Profesional] WHERE [ProfesionalId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000827", "SELECT [ProfesionalId], [ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalFechaNacimiento], [ProfesionalSexo], [ProfesionalDescripcion], [ProfesionalCorreo], [ProfesionalCOP], [ProfesionalColorDisponible], [ProfesionalColorCita], [ProfesionalTiempoCita], [ProfesionalDireccion], [ProfesionalFoto], [ProfesionalFoto_GXI], [ProfesionalTwitter], [ProfesionalFacebook], [ProfesionalInstagram], [ProfesionalLinkedin], [ProfesionalTelefono], [ProfesionalFechaRegistro], [ProfesionalTerminosCondiciones], [ProfesionalEstadoCuenta], [ProfesionalEstado], [PaisId], [UbigeoCode], [SecUserId] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000828", "SELECT [ProfesionalId], [ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalFechaNacimiento], [ProfesionalSexo], [ProfesionalDescripcion], [ProfesionalCorreo], [ProfesionalCOP], [ProfesionalColorDisponible], [ProfesionalColorCita], [ProfesionalTiempoCita], [ProfesionalDireccion], [ProfesionalFoto], [ProfesionalFoto_GXI], [ProfesionalTwitter], [ProfesionalFacebook], [ProfesionalInstagram], [ProfesionalLinkedin], [ProfesionalTelefono], [ProfesionalFechaRegistro], [ProfesionalTerminosCondiciones], [ProfesionalEstadoCuenta], [ProfesionalEstado], [PaisId], [UbigeoCode], [SecUserId] FROM [Profesional] WITH (UPDLOCK) WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000829", "INSERT INTO [Profesional]([ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalFechaNacimiento], [ProfesionalSexo], [ProfesionalDescripcion], [ProfesionalCorreo], [ProfesionalCOP], [ProfesionalColorDisponible], [ProfesionalColorCita], [ProfesionalTiempoCita], [ProfesionalDireccion], [ProfesionalFoto], [ProfesionalFoto_GXI], [ProfesionalTwitter], [ProfesionalFacebook], [ProfesionalInstagram], [ProfesionalLinkedin], [ProfesionalTelefono], [ProfesionalFechaRegistro], [ProfesionalTerminosCondiciones], [ProfesionalEstadoCuenta], [ProfesionalEstado], [PaisId], [UbigeoCode], [SecUserId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000830", "UPDATE [Profesional] SET [ProfesionalTipoDocumento]=?, [ProfesionalNroDocumento]=?, [ProfesionalApellidoPaterno]=?, [ProfesionalApellidoMaterno]=?, [ProfesionalNombres]=?, [ProfesionalFechaNacimiento]=?, [ProfesionalSexo]=?, [ProfesionalDescripcion]=?, [ProfesionalCorreo]=?, [ProfesionalCOP]=?, [ProfesionalColorDisponible]=?, [ProfesionalColorCita]=?, [ProfesionalTiempoCita]=?, [ProfesionalDireccion]=?, [ProfesionalTwitter]=?, [ProfesionalFacebook]=?, [ProfesionalInstagram]=?, [ProfesionalLinkedin]=?, [ProfesionalTelefono]=?, [ProfesionalFechaRegistro]=?, [ProfesionalTerminosCondiciones]=?, [ProfesionalEstadoCuenta]=?, [ProfesionalEstado]=?, [PaisId]=?, [UbigeoCode]=?, [SecUserId]=?  WHERE [ProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000831", "UPDATE [Profesional] SET [ProfesionalFoto]=?, [ProfesionalFoto_GXI]=?  WHERE [ProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000832", "DELETE FROM [Profesional]  WHERE [ProfesionalId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000833", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000834", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000835", "SELECT TOP 1 [ComentarioProfesionalId] FROM [ComentarioProfesional] WHERE [SGProfesionalProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000836", "SELECT TOP 1 [RatingProfesionalId] FROM [RatingProfesional] WHERE [SGProfesionalProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000837", "SELECT TOP 1 [EducacionProfesionalId] FROM [EducacionProfesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000838", "SELECT TOP 1 [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000839", "SELECT TM1.[ProfesionalId], TM1.[ProfesionalTipoDocumento], TM1.[ProfesionalNroDocumento], TM1.[ProfesionalApellidoPaterno], TM1.[ProfesionalApellidoMaterno], TM1.[ProfesionalNombres], TM1.[ProfesionalFechaNacimiento], TM1.[ProfesionalSexo], TM1.[ProfesionalDescripcion], TM1.[ProfesionalCorreo], TM1.[ProfesionalCOP], TM1.[ProfesionalColorDisponible], TM1.[ProfesionalColorCita], TM1.[ProfesionalTiempoCita], TM1.[ProfesionalDireccion], T2.[PaisDescripcion], TM1.[ProfesionalFoto], TM1.[ProfesionalFoto_GXI], TM1.[ProfesionalTwitter], TM1.[ProfesionalFacebook], TM1.[ProfesionalInstagram], TM1.[ProfesionalLinkedin], TM1.[ProfesionalTelefono], TM1.[ProfesionalFechaRegistro], TM1.[ProfesionalTerminosCondiciones], TM1.[ProfesionalEstadoCuenta], TM1.[ProfesionalEstado], T3.[UbigeoDepartamento], T3.[UbigeoProvincia], T3.[UbigeoDistrito], TM1.[PaisId], TM1.[UbigeoCode], TM1.[SecUserId] FROM (([Profesional] TM1 INNER JOIN [Pais] T2 ON T2.[PaisId] = TM1.[PaisId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = TM1.[UbigeoCode]) WHERE TM1.[ProfesionalId] = ? ORDER BY TM1.[ProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000840", "SELECT T1.[ProfesionalId], T2.[EspecialidadCodigo], T2.[EspecialidadNombre], T1.[EspecialidadId] FROM ([ProfesionalEspecialidad] T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) WHERE T1.[ProfesionalId] = ? and T1.[EspecialidadId] = ? ORDER BY T1.[ProfesionalId], T1.[EspecialidadId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000841", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000842", "SELECT [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000843", "SELECT [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000844", "SELECT [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000845", "INSERT INTO [ProfesionalEspecialidad]([ProfesionalId], [EspecialidadId]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000846", "DELETE FROM [ProfesionalEspecialidad]  WHERE [ProfesionalId] = ? AND [EspecialidadId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000847", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000848", "SELECT TOP 1 [DisponibilidadId] FROM [Disponibilidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000849", "SELECT TOP 1 [ConfComisionId] FROM [ConfComision] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000850", "SELECT T1.[ProfesionalId], T2.[EspecialidadCodigo], T2.[EspecialidadNombre], T1.[EspecialidadId] FROM ([ProfesionalEspecialidad] T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) WHERE T1.[ProfesionalId] = ? ORDER BY T1.[ProfesionalId], T1.[EspecialidadId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000851", "SELECT T2.[ClinicaId], T1.[ProfesionalId], T1.[EspecialidadId], T1.[SedeTipoConsulta], T1.[CostoConsulta], T2.[SedeNombre], T3.[ClinicaNombreAbreviado], T1.[SedeId] FROM (([ProfesionalEspecialidadSede] T1 INNER JOIN [Sede] T2 ON T2.[SedeId] = T1.[SedeId]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T2.[ClinicaId]) WHERE T1.[ProfesionalId] = ? and T1.[EspecialidadId] = ? and T1.[SedeTipoConsulta] = ? and T1.[SedeId] = ? ORDER BY T1.[ProfesionalId], T1.[EspecialidadId], T1.[SedeId], T1.[SedeTipoConsulta]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000852", "SELECT [ClinicaId], [SedeNombre] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000853", "SELECT [ClinicaNombreAbreviado] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000854", "SELECT [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000855", "SELECT [ProfesionalId], [EspecialidadId], [SedeTipoConsulta], [CostoConsulta], [SedeId] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000856", "SELECT [ProfesionalId], [EspecialidadId], [SedeTipoConsulta], [CostoConsulta], [SedeId] FROM [ProfesionalEspecialidadSede] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000857", "INSERT INTO [ProfesionalEspecialidadSede]([ProfesionalId], [EspecialidadId], [SedeTipoConsulta], [CostoConsulta], [SedeId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000858", "UPDATE [ProfesionalEspecialidadSede] SET [CostoConsulta]=?  WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000859", "DELETE FROM [ProfesionalEspecialidadSede]  WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000860", "SELECT [ClinicaId], [SedeNombre] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000861", "SELECT [ClinicaNombreAbreviado] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000862", "SELECT T2.[ClinicaId], T1.[ProfesionalId], T1.[EspecialidadId], T1.[SedeTipoConsulta], T1.[CostoConsulta], T2.[SedeNombre], T3.[ClinicaNombreAbreviado], T1.[SedeId] FROM (([ProfesionalEspecialidadSede] T1 INNER JOIN [Sede] T2 ON T2.[SedeId] = T1.[SedeId]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T2.[ClinicaId]) WHERE T1.[ProfesionalId] = ? and T1.[EspecialidadId] = ? ORDER BY T1.[ProfesionalId], T1.[EspecialidadId], T1.[SedeId], T1.[SedeTipoConsulta]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000863", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? and [EducacionId] = ? ORDER BY [ProfesionalId], [EducacionId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000864", "SELECT [ProfesionalId], [EducacionId] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? AND [EducacionId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000865", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? AND [EducacionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000866", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [EducacionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000867", "INSERT INTO [ProfesionalEducacion]([ProfesionalId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion], [EducacionId]) VALUES(?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000868", "UPDATE [ProfesionalEducacion] SET [EducacionNombreInstitucion]=?, [EducacionDesde]=?, [EducacionHasta]=?, [EducacionPaisDescripcion]=?  WHERE [ProfesionalId] = ? AND [EducacionId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000869", "DELETE FROM [ProfesionalEducacion]  WHERE [ProfesionalId] = ? AND [EducacionId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000870", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId], [EducacionId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000871", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? and [ExperienciaLaboralId] = ? ORDER BY [ProfesionalId], [ExperienciaLaboralId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000872", "SELECT [ProfesionalId], [ExperienciaLaboralId] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000873", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000874", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000875", "INSERT INTO [ProfesionalExperienciaLaboral]([ProfesionalId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta], [ExperienciaLaboralId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000876", "UPDATE [ProfesionalExperienciaLaboral] SET [ExperienciaLaboralEmpresaNombre]=?, [ExperienciaLaboralDesde]=?, [ExperienciaLaboralHasta]=?  WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000877", "DELETE FROM [ProfesionalExperienciaLaboral]  WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000878", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId], [ExperienciaLaboralId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000879", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? and [PremiosId] = ? ORDER BY [ProfesionalId], [PremiosId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000880", "SELECT [ProfesionalId], [PremiosId] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? AND [PremiosId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000881", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? AND [PremiosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000882", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion] FROM [ProfesionalPremios] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [PremiosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000883", "INSERT INTO [ProfesionalPremios]([ProfesionalId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion], [PremiosId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000884", "UPDATE [ProfesionalPremios] SET [PremiosNombre]=?, [PremiosFecha]=?, [PremiosDescripcion]=?  WHERE [ProfesionalId] = ? AND [PremiosId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000885", "DELETE FROM [ProfesionalPremios]  WHERE [ProfesionalId] = ? AND [PremiosId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000886", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId], [PremiosId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000887", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? and [ServiciosId] = ? ORDER BY [ProfesionalId], [ServiciosId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000888", "SELECT [ProfesionalId], [ServiciosId] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? AND [ServiciosId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000889", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? AND [ServiciosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000890", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [ServiciosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000891", "INSERT INTO [ProfesionalServicios]([ProfesionalId], [ServiciosNombre], [ServiciosId]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000892", "UPDATE [ProfesionalServicios] SET [ServiciosNombre]=?  WHERE [ProfesionalId] = ? AND [ServiciosId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000893", "DELETE FROM [ProfesionalServicios]  WHERE [ProfesionalId] = ? AND [ServiciosId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000894", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId], [ServiciosId]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((String[]) buf[16])[0] = rslt.getMultimediaUri(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(24);
               ((String[]) buf[24])[0] = rslt.getString(25, 2);
               ((String[]) buf[25])[0] = rslt.getString(26, 2);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 10);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((String[]) buf[16])[0] = rslt.getMultimediaUri(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(24);
               ((String[]) buf[24])[0] = rslt.getString(25, 2);
               ((String[]) buf[25])[0] = rslt.getString(26, 2);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 10);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getMultimediaFile(17, rslt.getVarchar(18));
               ((String[]) buf[17])[0] = rslt.getMultimediaUri(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 20);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(24);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 2);
               ((String[]) buf[26])[0] = rslt.getString(27, 2);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((short[]) buf[30])[0] = rslt.getShort(31);
               ((String[]) buf[31])[0] = rslt.getString(32, 10);
               ((short[]) buf[32])[0] = rslt.getShort(33);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 23 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((String[]) buf[16])[0] = rslt.getMultimediaUri(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(24);
               ((String[]) buf[24])[0] = rslt.getString(25, 2);
               ((String[]) buf[25])[0] = rslt.getString(26, 2);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 10);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((String[]) buf[16])[0] = rslt.getMultimediaUri(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(24);
               ((String[]) buf[24])[0] = rslt.getString(25, 2);
               ((String[]) buf[25])[0] = rslt.getString(26, 2);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 10);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 31 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 32 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getMultimediaFile(17, rslt.getVarchar(18));
               ((String[]) buf[17])[0] = rslt.getMultimediaUri(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 20);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(24);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 2);
               ((String[]) buf[26])[0] = rslt.getString(27, 2);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((short[]) buf[30])[0] = rslt.getShort(31);
               ((String[]) buf[31])[0] = rslt.getString(32, 10);
               ((short[]) buf[32])[0] = rslt.getShort(33);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 39 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 45 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 47 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 49 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 50 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 51 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 52 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 53 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 54 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 58 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 59 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
      }
      getresults60( cursor, rslt, buf) ;
   }

   public void getresults60( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 61 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 62 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 63 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 64 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 69 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 71 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 72 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 77 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               return;
            case 78 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 79 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               return;
            case 80 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               return;
            case 84 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               return;
            case 85 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 86 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 87 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 88 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 92 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 22 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
            case 27 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setVarchar(2, (String)parms[1], 15, false);
               stmt.setVarchar(3, (String)parms[2], 50, false);
               stmt.setVarchar(4, (String)parms[3], 50, false);
               stmt.setVarchar(5, (String)parms[4], 50, false);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setVarchar(8, (String)parms[7], 5000, false);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setVarchar(14, (String)parms[13], 200, false);
               stmt.setBLOBFile(15, (String)parms[14], true);
               stmt.setGXDbFileURI(16, (String)parms[15], (String)parms[14], 2048,"Profesional","ProfesionalFoto");
               stmt.setVarchar(17, (String)parms[16], 1000, false);
               stmt.setVarchar(18, (String)parms[17], 1000, false);
               stmt.setVarchar(19, (String)parms[18], 1000, false);
               stmt.setVarchar(20, (String)parms[19], 1000, false);
               stmt.setString(21, (String)parms[20], 20);
               stmt.setDate(22, (java.util.Date)parms[21]);
               stmt.setBoolean(23, ((Boolean) parms[22]).booleanValue());
               stmt.setString(24, (String)parms[23], 2);
               stmt.setString(25, (String)parms[24], 2);
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setString(27, (String)parms[26], 10);
               stmt.setShort(28, ((Number) parms[27]).shortValue());
               return;
            case 28 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setVarchar(2, (String)parms[1], 15, false);
               stmt.setVarchar(3, (String)parms[2], 50, false);
               stmt.setVarchar(4, (String)parms[3], 50, false);
               stmt.setVarchar(5, (String)parms[4], 50, false);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setVarchar(8, (String)parms[7], 5000, false);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setVarchar(14, (String)parms[13], 200, false);
               stmt.setVarchar(15, (String)parms[14], 1000, false);
               stmt.setVarchar(16, (String)parms[15], 1000, false);
               stmt.setVarchar(17, (String)parms[16], 1000, false);
               stmt.setVarchar(18, (String)parms[17], 1000, false);
               stmt.setString(19, (String)parms[18], 20);
               stmt.setDate(20, (java.util.Date)parms[19]);
               stmt.setBoolean(21, ((Boolean) parms[20]).booleanValue());
               stmt.setString(22, (String)parms[21], 2);
               stmt.setString(23, (String)parms[22], 2);
               stmt.setShort(24, ((Number) parms[23]).shortValue());
               stmt.setString(25, (String)parms[24], 10);
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setInt(27, ((Number) parms[26]).intValue());
               return;
            case 29 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Profesional","ProfesionalFoto");
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 31 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 32 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 39 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 45 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 48 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 49 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 1);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 50 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 51 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 52 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 54 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 55 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 1);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 56 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 1);
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 58 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 59 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
      setparameters60( cursor, stmt, parms) ;
   }

   public void setparameters60( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 61 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 62 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 63 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 64 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 65 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 300, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setVarchar(5, (String)parms[4], 200, false);
               stmt.setGUID(6, (java.util.UUID)parms[5]);
               return;
            case 66 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setGUID(6, (java.util.UUID)parms[5]);
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 69 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 70 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 73 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 300, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setGUID(5, (java.util.UUID)parms[4]);
               return;
            case 74 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setGUID(5, (java.util.UUID)parms[4]);
               return;
            case 75 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 77 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 78 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 79 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 80 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 81 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 500, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setGUID(5, (java.util.UUID)parms[4]);
               return;
            case 82 :
               stmt.setVarchar(1, (String)parms[0], 500, false);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setGUID(5, (java.util.UUID)parms[4]);
               return;
            case 83 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 84 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 85 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 86 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 87 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 88 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 89 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 300, false);
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
      }
      setparameters90( cursor, stmt, parms) ;
   }

   public void setparameters90( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 90 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
            case 91 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 92 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

