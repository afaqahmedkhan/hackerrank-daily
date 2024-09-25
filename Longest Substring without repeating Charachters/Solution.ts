interface ISubstringFinder {
  findLength(s: string): number;
}

class LongestSubstringFinder implements ISubstringFinder {
  private charSet: Set<string>;
  private left: number;
  private maxLength: number;

  constructor() {
    this.charSet = new Set<string>();
    this.left = 0;
    this.maxLength = 0;
  }

  public findLength(s: string): number {
    if (s.length === 0) return 0;

    for (let right = 0; right < s.length; right++) {
      this.adjustWindow(s, right);
      this.charSet.add(s[right]);
      this.updateMaxLength(right);
    }

    return this.maxLength;
  }

  private adjustWindow(s: string, right: number): void {
    while (this.charSet.has(s[right])) {
      this.charSet.delete(s[this.left]);
      this.left++;
    }
  }

  private updateMaxLength(right: number): void {
    this.maxLength = Math.max(this.maxLength, right - this.left + 1);
  }
}

function lengthOfLongestSubstring(s: string): number {
  const finder = new LongestSubstringFinder();
  return finder.findLength(s);
}
