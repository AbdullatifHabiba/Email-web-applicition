import { InboxComponent } from './../inbox/inbox.component';
import { ComponentscontrollerService } from './../componentscontroller.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router } from '@angular/router';
import { Email } from '../Email';
import { TrashComponent } from '../Trash/Trash.component';
import { StarredComponent } from '../Starred/Starred.component';
import { DraftsComponent } from '../Drafts/Drafts.component';
import { SentItemsComponent } from '../SentItems/SentItems.component';

@Injectable({
  providedIn: 'root'
})

export class ResolveService implements Resolve<Email> {

  constructor(
    private emailService: ComponentscontrollerService,
    private router: Router
  ) { }

  public resolve(route: ActivatedRouteSnapshot ): any {
    const { id } = route.params;
    const parent=route.parent?.routeConfig?.path;
    console.log(parent);
    switch(parent){
     case 'inbox':return this.getinboxemail(+id);
     case 'Drafts':return this.getdraftemail(+id);
     case 'Star':return this.getstaremail(+id);
     case 'Trash':return this.gettrashemail(+id);
     case 'SentItems':return this.getsentemails(+id);



    }

   // return this.emailService.getemaildetails(+id)
  }

  getinboxemail(index:number){
    return this.emailService.getemaildetails(index,"Inbox");
  }
  gettrashemail(index:number){
    return this.emailService.getemaildetails(index,"Trash");

  }
  getstaremail(index:number){
    return this.emailService.getemaildetails(index,"Starred");

  }
  getdraftemail(index:number){
    return this.emailService.getemaildetails(index,"Drafts");

  }
  getsentemails(index:number){
    return this.emailService.getemaildetails(index,"Sent");

  }
}
