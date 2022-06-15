package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class listwwpprogramsthaniprofesional extends GXProcedure
{
   public listwwpprogramsthaniprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( listwwpprogramsthaniprofesional.class ), "" );
   }

   public listwwpprogramsthaniprofesional( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName> executeUdp( )
   {
      listwwpprogramsthaniprofesional.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      listwwpprogramsthaniprofesional.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10ProgramNames = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>(com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "ProjectThani", remoteHandle) ;
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV14name = "WPMiPerfilMedico" ;
      AV15description = "Mi Perfil" ;
      AV16link = formatLink("com.projectthani.wpmiperfilmedico", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "DisponibilidadWW" ;
      AV15description = " Disponibilidad" ;
      AV16link = formatLink("com.projectthani.disponibilidadhoraria", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "WPBandejaCitas" ;
      AV15description = "Bandeja de Citas" ;
      AV16link = formatLink("com.projectthani.wpbandejacitas", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ADDPROGRAM' Routine */
      returnInSub = false ;
      AV8IsAuthorized = true ;
      if ( AV8IsAuthorized )
      {
         AV11ProgramName = (com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName)new com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
         AV11ProgramName.setgxTv_SdtProgramNames_ProgramName_Name( AV14name );
         AV11ProgramName.setgxTv_SdtProgramNames_ProgramName_Description( AV15description );
         AV11ProgramName.setgxTv_SdtProgramNames_ProgramName_Link( AV16link );
         AV10ProgramNames.add(AV11ProgramName, 0);
      }
   }

   protected void cleanup( )
   {
      this.aP0[0] = listwwpprogramsthaniprofesional.this.AV10ProgramNames;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ProgramNames = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>(com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "ProjectThani", remoteHandle);
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV14name = "" ;
      AV15description = "" ;
      AV16link = "" ;
      AV11ProgramName = new com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private String AV14name ;
   private String AV15description ;
   private String AV16link ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName> AV10ProgramNames ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName AV11ProgramName ;
}

