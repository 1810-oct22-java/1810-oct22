import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HTTPComponent } from './http.component';

describe('HTTPComponent', () => {
  let component: HTTPComponent;
  let fixture: ComponentFixture<HTTPComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HTTPComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HTTPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
