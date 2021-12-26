/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ComponentscontrollerService } from './componentscontroller.service';

describe('Service: Componentscontroller', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ComponentscontrollerService]
    });
  });

  it('should ...', inject([ComponentscontrollerService], (service: ComponentscontrollerService) => {
    expect(service).toBeTruthy();
  }));
});
