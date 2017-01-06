import { ProjectsComponent } from './projects/projects.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home-component';
import {Routes, RouterModule} from "@angular/router";
import {AppComponent} from "./app.component";





const routes: Routes = [
  {
    path: '',
    redirectTo: 'Profile/home',
    pathMatch: 'full'
  },
  {
    path: 'Profile/about',
    component: AboutComponent
  },
  {
    path: 'Profile/contact',
    component: ContactComponent
  },
  {
    path: 'home',
    component: HomeComponent
  }
  ,
  {
    path: 'projects',
    component: ProjectsComponent
  }
];


export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
