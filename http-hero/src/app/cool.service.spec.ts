import { TestBed } from '@angular/core/testing';

import { CoolService } from './cool.service';

describe('CoolService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CoolService = TestBed.get(CoolService);
    expect(service).toBeTruthy();
  });
});
