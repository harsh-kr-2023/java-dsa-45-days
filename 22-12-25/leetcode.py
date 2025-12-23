import requests
from datetime import datetime, timedelta
import json

# Step 1: Configure your username and API base URL
YOUR_USERNAME = "Harsh_Singh3"
API_BASE_URL = "https://alfa-leetcode-api.onrender.com"

print("=" * 60)
print(f"FETCHING DATA FOR USER: {YOUR_USERNAME}")
print("=" * 60)

# Step 2: Fetch recent submissions with AUTHENTICATION
submission_url = f"{API_BASE_URL}/{YOUR_USERNAME}/submission?limit=200"

# !! REPLACE THIS WITH YOUR ACTUAL COOKIE STRING !!
LEETCODE_SESSION_COOKIE = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfYXV0aF91c2VyX2lkIjoiNjE4MjkzMSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImFsbGF1dGguYWNjb3VudC5hdXRoX2JhY2tlbmRzLkF1dGhlbnRpY2F0aW9uQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6ImJhZjA5NTY2ODlhYjQ2ZmYxZWU1MzQ4ZWFhNjRhNjc4M2Q2NGVlZmVkZTY1YWEzZjVhMWFhZDk5YjczZGYwOWMiLCJzZXNzaW9uX3V1aWQiOiIyNDg0NGQ1MyIsImlkIjo2MTgyOTMxLCJlbWFpbCI6ImhrMDAwODM5MEBnbWFpbC5jb20iLCJ1c2VybmFtZSI6IkhhcnNoX1NpbmdoMyIsInVzZXJfc2x1ZyI6IkhhcnNoX1NpbmdoMyIsImF2YXRhciI6Imh0dHBzOi8vYXNzZXRzLmxlZXRjb2RlLmNvbS91c2Vycy9hdmF0YXJzL2F2YXRhcl8xNjUwMjY4NDM0LnBuZyIsInJlZnJlc2hlZF9hdCI6MTc2NjM4OTc2NCwiaXAiOiIyNDAxOjQ5MDA6OGY1NTpjNjA5OjE1ZWI6ODczZTpiNWJlOjIwNWMiLCJpZGVudGl0eSI6Ijg5ZGI3MjljZmNkYzEyOTExMWYwMTdiMGU3YWMzMjRhIiwiZGV2aWNlX3dpdGhfaXAiOlsiYTQzNDk1ZTNmZmRlZmRiN2YxZGVkNTY3ODRiOTBlYzYiLCIyNDAxOjQ5MDA6OGY1NTpjNjA5OjE1ZWI6ODczZTpiNWJlOjIwNWMiXX0.tUoNBvFppnjCeNU7jJQr-FGH_Yn2ithQYZRMeFTsPU0"

headers = {
    'Cookie': f'LEETCODE_SESSION={LEETCODE_SESSION_COOKIE}'
}

try:
    response = requests.get(submission_url, headers=headers)  # Pass headers here
    response.raise_for_status()
    all_submissions = response.json()
    
    print("\nFULL API RESPONSE STRUCTURE:")
    print(json.dumps(all_submissions, indent=2))
    
except requests.exceptions.RequestException as e:
    print(f"Error fetching submissions: {e}")
    exit()

print("\n" + "=" * 60)
print("2. ANALYZING RESPONSE STRUCTURE")
print("=" * 60)

print(f"Type of response: {type(all_submissions)}")

if isinstance(all_submissions, dict):
    print(f"Top-level keys: {list(all_submissions.keys())}")
    
    # Check for submission data in different possible locations
    possible_keys = ['submission', 'submissions', 'data', 'recentSubmissions']
    found_key = None
    for key in possible_keys:
        if key in all_submissions:
            found_key = key
            print(f"Found submission data in key: '{key}'")
            print(f"Type of '{key}': {type(all_submissions[key])}")
            
            if isinstance(all_submissions[key], list):
                print(f"Number of submissions in '{key}': {len(all_submissions[key])}")
                if len(all_submissions[key]) > 0:
                    print(f"\nFirst submission in '{key}':")
                    print(json.dumps(all_submissions[key][0], indent=2))
                    print(f"\nKeys in first submission: {list(all_submissions[key][0].keys())}")
            break
    
    if not found_key:
        print("Could not find submission data in any expected key")
        print("Available keys are:", list(all_submissions.keys()))
        
elif isinstance(all_submissions, list):
    print(f"Response is a list with {len(all_submissions)} items")
    if len(all_submissions) > 0:
        print(f"\nFirst item in list:")
        print(json.dumps(all_submissions[0], indent=2))

print("\n" + "=" * 60)
print("3. FILTERING SUBMISSIONS FROM LAST 15 DAYS")
print("=" * 60)

# Step 3: Calculate the date 15 days ago
cutoff_date = datetime.now() - timedelta(days=15)
print(f"Cutoff date (15 days ago): {cutoff_date}")
print(f"Current date: {datetime.now()}")

# Step 4: Filter submissions
recent_submissions = []
total_processed = 0

if isinstance(all_submissions, dict):
    # Try to find the submission data
    submission_key = None
    for key in ['submission', 'submissions', 'data', 'recentSubmissions']:
        if key in all_submissions and isinstance(all_submissions[key], list):
            submission_key = key
            break
    
    if submission_key:
        submissions_list = all_submissions[submission_key]
        print(f"\nProcessing {len(submissions_list)} submissions from key '{submission_key}'")
        
        for i, sub in enumerate(submissions_list):
            total_processed += 1
            print(f"\n--- Submission {i+1} ---")
            print(f"Full data: {json.dumps(sub, indent=2)}")
            
            # Get timestamp
            timestamp_str = sub.get('timestamp', sub.get('time', '0'))
            print(f"Timestamp raw value: '{timestamp_str}' (type: {type(timestamp_str)})")
            
            try:
                # Handle different timestamp formats
                if isinstance(timestamp_str, str) and timestamp_str.isdigit():
                    timestamp_int = int(timestamp_str)
                elif isinstance(timestamp_str, (int, float)):
                    timestamp_int = int(timestamp_str)
                else:
                    print(f"Skipping: Invalid timestamp format")
                    continue
                
                submission_time = datetime.fromtimestamp(timestamp_int)
                print(f"Parsed time: {submission_time}")
                
                if submission_time > cutoff_date:
                    recent_submissions.append(sub)
                    print(f"✓ INCLUDED (within last 15 days)")
                else:
                    print(f"✗ EXCLUDED (older than 15 days)")
                    
            except (ValueError, TypeError, OSError) as e:
                print(f"Error parsing timestamp '{timestamp_str}': {e}")
                continue
                
    else:
        print("Could not find submission list in response")
        
elif isinstance(all_submissions, list):
    print(f"\nProcessing {len(all_submissions)} submissions from root list")
    for i, sub in enumerate(all_submissions):
        total_processed += 1
        print(f"\n--- Submission {i+1} ---")
        print(f"Full data: {json.dumps(sub, indent=2)}")
        
        # Similar timestamp processing as above
        timestamp_str = sub.get('timestamp', sub.get('time', '0'))
        print(f"Timestamp raw value: '{timestamp_str}' (type: {type(timestamp_str)})")
        
        try:
            if isinstance(timestamp_str, str) and timestamp_str.isdigit():
                timestamp_int = int(timestamp_str)
            elif isinstance(timestamp_str, (int, float)):
                timestamp_int = int(timestamp_str)
            else:
                print(f"Skipping: Invalid timestamp format")
                continue
            
            submission_time = datetime.fromtimestamp(timestamp_int)
            print(f"Parsed time: {submission_time}")
            
            if submission_time > cutoff_date:
                recent_submissions.append(sub)
                print(f"✓ INCLUDED (within last 15 days)")
            else:
                print(f"✗ EXCLUDED (older than 15 days)")
                
        except (ValueError, TypeError, OSError) as e:
            print(f"Error parsing timestamp '{timestamp_str}': {e}")
            continue

print(f"\nTotal submissions processed: {total_processed}")
print(f"Submissions from last 15 days: {len(recent_submissions)}")

if len(recent_submissions) > 0:
    print(f"\nFirst recent submission details:")
    print(json.dumps(recent_submissions[0], indent=2))

print("\n" + "=" * 60)
print("4. FETCHING PROBLEM DIFFICULTIES")
print("=" * 60)

# Step 5: Count Medium difficulty problems
medium_count = 0
processed_problems = set()

print(f"Need to check {len(recent_submissions)} recent submissions")

for i, sub in enumerate(recent_submissions):
    print(f"\n--- Checking submission {i+1}/{len(recent_submissions)} ---")
    
    # Try different possible keys for title slug
    title_slug = sub.get('titleSlug', sub.get('title_slug', sub.get('problemSlug')))
    if not title_slug:
        print("No title slug found in submission:")
        print(json.dumps(sub, indent=2))
        continue
    
    print(f"Title slug: {title_slug}")
    
    # Skip if we've already processed this problem
    if title_slug in processed_problems:
        print(f"Skipping - already processed this problem")
        continue
        
    processed_problems.add(title_slug)
    print(f"First time processing this problem")

    # Fetch problem details to get difficulty
    problem_url = f"{API_BASE_URL}/select?titleSlug={title_slug}"
    print(f"Fetching from: {problem_url}")
    
    try:
        problem_resp = requests.get(problem_url)
        print(f"Problem API status: {problem_resp.status_code}")
        
        if problem_resp.status_code == 200:
            problem_details = problem_resp.json()
            print(f"Problem API response: {json.dumps(problem_details, indent=2)}")
            
            # Try different possible keys for difficulty
            difficulty = problem_details.get('difficulty', 
                                          problem_details.get('level',
                                          problem_details.get('problemDifficulty')))
            print(f"Extracted difficulty: {difficulty}")
            
            if difficulty == 'Medium':
                medium_count += 1
                print(f"✓ COUNTED AS MEDIUM (Total so far: {medium_count})")
            else:
                print(f"Not medium (difficulty: {difficulty})")
        else:
            print(f"Error: Problem API returned status {problem_resp.status_code}")
            print(f"Response: {problem_resp.text[:200]}")
            
    except requests.exceptions.RequestException as e:
        print(f"Error fetching problem {title_slug}: {e}")
        continue
    except json.JSONDecodeError as e:
        print(f"Error parsing problem response: {e}")
        print(f"Raw response: {problem_resp.text[:200]}")
        continue

print("\n" + "=" * 60)
print("5. FINAL RESULTS")
print("=" * 60)

print(f"Total submissions in last 15 days: {len(recent_submissions)}")
print(f"Unique problems attempted: {len(processed_problems)}")
print(f"✅ Number of UNIQUE MEDIUM problems submitted in last 15 days: {medium_count}")

# Optional: Print list of medium problems found
if medium_count > 0:
    print(f"\nMedium problems found:")
    # We could track these in the loop above if needed