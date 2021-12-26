import { InboxComponent } from './../inbox/inbox.component';
import { Component, OnInit } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private controll:ComponentscontrollerService) { }

  ngOnInit(): void {

  }
  
}
