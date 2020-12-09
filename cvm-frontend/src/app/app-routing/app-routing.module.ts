import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from '../component/dashboard/dashboard.component';
import {AgendaComponent} from '../component/agenda/agenda.component';
import {TransparenciaComponent} from '../component/transparencia/transparencia.component';
import {NoticiaComponent} from '../component/noticia/noticia.component';
import {IndexComponent} from '../component/index/index.component';
import { ACvmComponent } from '../component/a-cvm/a-cvm.component';
import { EducacaoInfantilComponent } from '../component/educacao-infantil/educacao-infantil.component';
import { AcolhimentoInstitucionalComponent } from '../component/acolhimento-institucional/acolhimento-institucional.component';
import { CasCentroAtendimentoSocialComponent } from '../component/cas-centro-atendimento-social/cas-centro-atendimento-social.component';
import {LoginComponent} from "../component/login/login.component";
import {Logged} from "../component/auth/logged";
import {AuthGuardService} from "../component/seguranca/auth-guard-service";
import {InclusaoProdutivaComponent} from '../component/inclusao-produtiva/inclusao-produtiva.component';
import {ComunidadeTerapeuticoComponent} from '../component/comunidade-terapeutico/comunidade-terapeutico.component';

const routes: Routes = [
  {path: 'dashboard', component: DashboardComponent, canActivate: [Logged, AuthGuardService]},
  {path: 'agenda', component: AgendaComponent, canActivate: [Logged, AuthGuardService]},
  {path: 'transparencia', component: TransparenciaComponent, canActivate: [Logged, AuthGuardService]},
  {path: 'noticia', component: NoticiaComponent, canActivate: [Logged, AuthGuardService]},
  {path: 'index', component: IndexComponent},
  {path: 'acvm', component: ACvmComponent},
  {path: 'educacaoinfantil', component: EducacaoInfantilComponent},
  {path: 'acolhimentoinstitucional', component: AcolhimentoInstitucionalComponent},
  {path: 'inclusaoprodutiva', component: InclusaoProdutivaComponent},
  {path: 'comunidadeterapeutica', component: ComunidadeTerapeuticoComponent},
  {path: 'cascentroatendimentosocial', component: CasCentroAtendimentoSocialComponent},
  {path: '', pathMatch: 'full', redirectTo: 'index'},

  {path: 'login', component: LoginComponent},
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
