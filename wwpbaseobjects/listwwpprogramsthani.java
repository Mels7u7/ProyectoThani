package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class listwwpprogramsthani extends GXProcedure
{
   public listwwpprogramsthani( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( listwwpprogramsthani.class ), "" );
   }

   public listwwpprogramsthani( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName> executeUdp( )
   {
      listwwpprogramsthani.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      listwwpprogramsthani.this.aP0 = aP0;
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
      AV14name = "ImportarMedico" ;
      AV15description = "Importar Data Médicos" ;
      AV16link = formatLink("com.projectthani.importarmedico", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "UbigeoWW" ;
      AV15description = "Ubigeo" ;
      AV16link = formatLink("com.projectthani.ubigeoww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "PetitorioCategWW" ;
      AV15description = "Petitorio Categ" ;
      AV16link = formatLink("com.projectthani.petitoriocategww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "CitaWW" ;
      AV15description = "Cita" ;
      AV16link = formatLink("com.projectthani.citaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "ConfigWW" ;
      AV15description = "Configuración" ;
      AV16link = formatLink("com.projectthani.configww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "DrogueriaWW" ;
      AV15description = "Drogueria" ;
      AV16link = formatLink("com.projectthani.drogueriaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "DisponibilidadWW" ;
      AV15description = "Disponibilidad" ;
      AV16link = formatLink("com.projectthani.disponibilidadhoraria", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "PaisWW" ;
      AV15description = "Pais" ;
      AV16link = formatLink("com.projectthani.paisww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "LogAccesosWW" ;
      AV15description = "Log Accesos" ;
      AV16link = formatLink("com.projectthani.logaccesosww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "SedeWW" ;
      AV15description = "Sede" ;
      AV16link = formatLink("com.projectthani.sedeww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "PetitorioSubCategWW" ;
      AV15description = "Petitorio Sub Categ" ;
      AV16link = formatLink("com.projectthani.petitoriosubcategww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "DiagnosticoWW" ;
      AV15description = "Diagnostico" ;
      AV16link = formatLink("com.projectthani.diagnosticoww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "EncuestaWW" ;
      AV15description = "Encuesta" ;
      AV16link = formatLink("com.projectthani.encuestaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "Profesional" ;
      AV15description = "Profesional" ;
      AV16link = formatLink("com.projectthani.wppaciente", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "PacienteWW" ;
      AV15description = "Paciente" ;
      AV16link = formatLink("com.projectthani.pacienteww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "LaboratorioWW" ;
      AV15description = "Laboratorio" ;
      AV16link = formatLink("com.projectthani.laboratorioww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "TemplateWW" ;
      AV15description = "Template" ;
      AV16link = formatLink("com.projectthani.templateww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "PetitorioWW" ;
      AV15description = "Petitorio" ;
      AV16link = formatLink("com.projectthani.petitorioww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "PagoWW" ;
      AV15description = "Pago" ;
      AV16link = formatLink("com.projectthani.pagoww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "ServicioCategWW" ;
      AV15description = "Servicio Categ" ;
      AV16link = formatLink("com.projectthani.serviciocategww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "EspecialidadWW" ;
      AV15description = "Especialidad" ;
      AV16link = formatLink("com.projectthani.especialidadww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "ClinicaWW" ;
      AV15description = "Clinica" ;
      AV16link = formatLink("com.projectthani.clinicaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "RecetaMedicaWW" ;
      AV15description = "Receta Medica" ;
      AV16link = formatLink("com.projectthani.recetamedicaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "ServicioWW" ;
      AV15description = "Servicio" ;
      AV16link = formatLink("com.projectthani.servicioww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "FormaFarmaceuticaWW" ;
      AV15description = "Forma Farmaceutica" ;
      AV16link = formatLink("com.projectthani.formafarmaceuticaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14name = "MedicamentoWW" ;
      AV15description = "Medicamento" ;
      AV16link = formatLink("com.projectthani.medicamentoww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV10ProgramNames.sort("Description");
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
      this.aP0[0] = listwwpprogramsthani.this.AV10ProgramNames;
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

